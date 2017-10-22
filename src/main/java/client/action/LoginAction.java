package client.action;

import client.model.Client;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpSession;

public class LoginAction extends ActionSupport{
    private Client client;
    private String checkCode;

    public String login(){

        return "success";
    }


    public void validate(){
        HttpSession session= ServletActionContext.getRequest().getSession();
        if(!session.getAttribute("checkCode").equals(checkCode)){
            addFieldError(checkCode,"输入的验证码不正确，请重新输入");
        }
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
}
