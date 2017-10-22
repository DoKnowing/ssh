package util;

import com.sun.mail.util.MailSSLSocketFactory;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.security.GeneralSecurityException;
import java.util.Properties;

public class MailUtil {

    private static String HOST = "smtp.exmail.qq.com";
    private static int PORT = 465;
    private static String FROM = "852925993@qq.com";
    private static String PWD = "tqwtifnmaebhbbdf";

    public static void sendMail(String toAddress, String content) throws GeneralSecurityException, MessagingException {
        Properties props = new Properties();
        props.setProperty("mail.debug", "true");// 开启debug调试
        props.setProperty("mail.smtp.auth", "true");// 发送服务器需要身份验证
        props.setProperty("mail.host", "smtp.qq.com");// 设置邮件服务器主机名
        props.setProperty("mail.transport.protocol", "smtp");// 发送邮件协议名称

        MailSSLSocketFactory sf = new MailSSLSocketFactory();
        sf.setTrustAllHosts(true);
        props.put("mail.smtp.ssl.enable", "true");
        props.put("mail.smtp.ssl.socketFactory", sf);

        Session session = Session.getInstance(props);
        Message msg = new MimeMessage(session);
        msg.setSubject("注册校验");
        msg.setText(content);
        msg.setFrom(new InternetAddress(FROM));
        Transport transport = session.getTransport();
        transport.connect("smtp.qq.com", FROM, PWD);

        transport.sendMessage(msg, new Address[] { new InternetAddress(toAddress) });
        transport.close();


    }

    public static void main(String[] args){
        //test
        String subject = "测试邮件";
        String content = "http://123.com?a=1&b=2";
        String to = "1004258728@qq.com";
        try {

            MailUtil.sendMail(to,  content);
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
