package client.action;

import org.apache.struts2.ServletActionContext;
import org.junit.Test;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import util.MailUtil;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Random;

@Controller@Scope("prototype")
public class CreateImageAction implements client.actionInterface.CreateImageActionInter {
    private static int WIDTH = 60;
    private static int HEIGHT = 20;

    @Override
    public String createRandom(){
        String str="0123456789qwertyuiopasdfghjklzxcvbnm";
        char[] rands=new char[4];
        Random random=new Random();
        for(int i=0;i<4;i++){
            rands[i]=str.charAt(random.nextInt(36));
        }
        return new String(rands);
    }

    @Override
    public void drawBackground(Graphics g){
        //画灰色的背景
        g.setColor(new Color(0xDCDCDC));
        g.fillRect(0,0,WIDTH,HEIGHT);
        //随机产生120个干扰点
        for(int i=0;i<120;i++){
            int x=(int)(Math.random()*WIDTH);
            int y=(int)(Math.random()*HEIGHT);
            int red=(int)(Math.random()*255);
            int green=(int)(Math.random()*255);
            int blue=(int)(Math.random()*255);
            g.setColor(new Color(red,green,blue));
            g.drawOval(x,y,1,0);
        }
        //产生干扰线
        for (int i = 0; i < 5; i++) {
            int x2 =(int)(Math.random()*WIDTH);
            int y2 =(int)(Math.random()*HEIGHT);
            int x3 = (int)(Math.random()*50);
            int y3 = (int)(Math.random()*50);
            int red=(int)(Math.random()*255);
            int green=(int)(Math.random()*255);
            int blue=(int)(Math.random()*255);
            g.setColor(new Color(red,green,blue));
            g.drawLine(x2, y2, x2 + x3, y2 + y3);
        }
    }

    @Override
    public void drawRands(Graphics g, String rands){
        g.setColor(Color.BLACK);
        g.setFont(new Font(null,Font.ITALIC | Font.BOLD,18));
        //在不同的高度上输出验证码的每个字符
        g.drawString(""+rands.charAt(0),1,17);
        g.drawString(""+rands.charAt(1),16,15);
        g.drawString(""+rands.charAt(2),31,18);
        g.drawString(""+rands.charAt(3),46,16);
        System.out.println(rands);
    }

    @Override
    public String create() throws IOException {
        HttpServletResponse response= ServletActionContext.getResponse();
        //设置浏览器不要缓存此图片
        response.setContentType("images/jpeg");
        response.setHeader("Pragma","no-cache");
        response.setHeader("Cache-Control","no-cache");
        response.setDateHeader("Expires",0);

        String rands=createRandom();
        BufferedImage img=new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_RGB);
        Graphics g=img.getGraphics();
        drawBackground(g);
        drawRands(g,rands);
        g.dispose();// 结束图像 的绘制 过程， 完成图像

        ServletOutputStream outputStream=response.getOutputStream();
        ImageIO.write(img,"jpeg",outputStream);
        outputStream.close();

        //将校验码放到session中，便于后面登录的时候校验
        HttpSession session=ServletActionContext.getRequest().getSession();
        session.setAttribute("checkCode",rands);
        return "success";
    }

}
