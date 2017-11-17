package client.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import common.dao.ActivityDao;
import common.dao.CatgoryDao;
import common.dao.ClientDao;
import common.daoInterface.ActivityDaoInter;
import common.daoInterface.CatgoryDaoInter;
import common.daoInterface.ClientDaoInter;
import common.model.Activity;
import common.model.Catgory;
import common.model.Client;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import util.MailUtil;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.servlet.http.HttpSession;
import java.security.GeneralSecurityException;
import java.util.Date;
import java.util.List;

/**
 * @Author: Sma
 * @date: 2017-10-29 16:04
 * @explain:
 */

@Controller@Scope("prototype")
public class BaseClientAction extends ActionSupport implements client.actionInterface.BaseActionInter {
    @Resource private ClientDaoInter clientDao;
    @Resource private CatgoryDaoInter catgoryDao;
    @Resource private ActivityDaoInter activityDao;
    private List<Catgory> catgories;
    private List<Activity> activities;
    private Client client;
    private String checkCode;
    private String message;

    @Override
    public String homePage(){

        this.catgories=catgoryDao.getCatgories();
        Client user= (Client) ActionContext.getContext().getSession().get("client");
        Client client=clientDao.getClientByEmail(user.getEmail());
        this.activities=activityDao.getActivitiesByInstitution(client.getInstitution());
        return "success";
    }

    @Override
    public String registerPage(){
        return "success";
    }

    @Override
    public String loginPage(){
        return "success";
    }

    @Override
    public String login() {
        if (client.getEmail() == null || client.getPswd() == null) {
            return "input";
        }
        if (clientDao.getClient(client) != null) {
            client.setPswd(null);
            ActionContext.getContext().getSession().put("client", client);
            return "success";
        }else{
            addFieldError(client.toString(),"账号不存在或者密码错误");
        }
        return "error";
    }

    @Override
    public void validateLogin(){
        HttpSession session= ServletActionContext.getRequest().getSession();
        if(session.getAttribute("checkCode")==null || !session.getAttribute("checkCode").equals(checkCode)){
            addFieldError(checkCode,"输入的验证码不正确，请重新输入");
        }
    }
    @Override
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

    @Override
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

    @Override
    public Client getClient() {
        return client;
    }

    @Override
    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String getCheckCode() {
        return checkCode;
    }

    @Override
    public void setCheckCode(String checkCode) {
        this.checkCode = checkCode;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public List<Catgory> getCatgories() {
        return catgories;
    }

    @Override
    public void setCatgories(List<Catgory> catgories) {
        this.catgories = catgories;
    }

    @Override
    public List<Activity> getActivities() {
        return activities;
    }

    @Override
    public void setActivities(List<Activity> activities) {
        this.activities = activities;
    }

    @Override
    public ClientDaoInter getClientDao() {
        return clientDao;
    }

    @Override
    public void setClientDao(ClientDaoInter clientDao) {
        this.clientDao = clientDao;
    }

    @Override
    public CatgoryDaoInter getCatgoryDao() {
        return catgoryDao;
    }

    @Override
    public void setCatgoryDao(CatgoryDaoInter catgoryDao) {
        this.catgoryDao = catgoryDao;
    }

    @Override
    public ActivityDaoInter getActivityDao() {
        return activityDao;
    }

    @Override
    public void setActivityDao(ActivityDaoInter activityDao) {
        this.activityDao = activityDao;
    }
}
