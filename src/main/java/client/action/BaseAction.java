package client.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import common.dao.ClientDao;
import common.model.Client;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.struts2.ServletActionContext;
import util.MailUtil;

import javax.mail.MessagingException;
import javax.servlet.http.HttpSession;
import java.security.GeneralSecurityException;
import java.util.Date;

/**
 * @Author: Sma
 * @date: 2017-10-29 16:04
 * @explain:
 */
public class BaseAction  extends ActionSupport {
    private ClientDao clientDao=new ClientDao();
    private Client client;
    private String checkCode;
    private String message;

    public String registerPage(){
        return "success";
    }

    public String loginPage(){
        return "success";
    }

    public String login() {
        if (client.getEmail() == null || client.getPswd() == null) {
            return "input";
        }
        if (clientDao.getClient(client) != null) {
            client.setPswd(null);
            ActionContext.getContext().getSession().put("client", client);
            return "success";
        }
        return "error";
    }

    public void validateLogin(){
        HttpSession session= ServletActionContext.getRequest().getSession();
        if(session.getAttribute("checkCode")==null || !session.getAttribute("checkCode").equals(checkCode)){
            addFieldError(checkCode,"输入的验证码不正确，请重新输入");
        }
    }
    public String register() throws GeneralSecurityException, MessagingException {
        client.setRegisterTime(new Date());
        client.setLastActivateTime(new Date());
        client.setValidateCode(DigestUtils.md5Hex(client.getEmail()));
        clientDao.save(client);

        //邮件内容
        StringBuilder sb=new StringBuilder("请点击下面链接激活账号，24小时生效，否则重新注册账号，链接只能使用一次，请尽快激活！\n");
        sb.append("http://localhost:8080/client/activate.action?client.email=");
        sb.append(client.getEmail());
        sb.append("&client.validateCode=");
        sb.append(client.getValidateCode());

        MailUtil.sendMail(client.getEmail(),sb.toString());
        System.out.println("发送邮件");
        return "success";
    }

    public String activate() throws Exception {
        Client client1=clientDao.find(client.getEmail());
        if(client1!=null){
            //验证用户激活状态
            if(client1.getStatus()==0){
                Date currTime=new Date();
                currTime.before(client1.getRegisterTime());
                if(currTime.before(client1.getLastActivateTime())){
                    if(client.getValidateCode().equals(client1.getValidateCode())){
                        client1.setStatus(1);
                        clientDao.update(client1);
                    }else{
                        message="激活码不正确";
                        return "failure";
                    }
                }else{
                    message="激活码已经过期";
                    return "failure";
                }
            }else{
                message="邮箱已激活，请登录";
                return "failure";
            }
        }else{
            message="该邮箱未注册（邮箱地址不存在）";
            return "failure";
        }
        return "success";
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getCheckCode() {
        return checkCode;
    }

    public void setCheckCode(String checkCode) {
        this.checkCode = checkCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
