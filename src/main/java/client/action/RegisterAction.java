package client.action;

import client.dao.ClientDao;
import client.model.Client;
import org.apache.commons.codec.digest.DigestUtils;
import util.MailUtil;

import javax.mail.MessagingException;
import java.security.GeneralSecurityException;
import java.util.Date;
public class RegisterAction {
    private ClientDao clientDao=new ClientDao();
    private Client client;
    private String message;

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

    public void setClient(Client client) {
        this.client = client;
    }

    public Client getClient() {
        return client;
    }

    public String getMessage() {
        return message;
    }
}
