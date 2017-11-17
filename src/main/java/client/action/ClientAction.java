package client.action;

import common.dao.ClientDao;
import common.daoInterface.ActivityDaoInter;
import common.daoInterface.ClientDaoInter;
import common.model.Activity;
import common.model.Client;
import com.opensymphony.xwork2.ActionContext;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import util.ThreadUtil;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller@Scope("prototype")
public class ClientAction implements client.actionInterface.ClientActionInter {
    @Resource private ClientDaoInter clientDao;
    private List<Activity> activities;
    private long participatorId;
    private Client participator;
    private Client client;
    private File img;
    private String imgFileName;

    @Override
    public String participator(){
        this.participator=clientDao.getClientById(participatorId);
        return "success";
    }


    @Override
    public String personalPage(){
        Client user=(Client) ActionContext.getContext().getSession().get("client");
        this.client=clientDao.getClientByEmail(user.getEmail());
        return "success";
    }

    @Override
    public String modifyImgUrl() throws IOException {
        if(imgFileName!=null && !"".equals(imgFileName)) {
            String relativePath="/imgs/client/";
            String realPath="E:\\Idea_Workplace\\ssh\\src\\main\\webapp\\imgs\\client";
            File saveFile = new File(realPath, imgFileName);
            FileUtils.copyFile(img, saveFile);
            Client user=(Client)ActionContext.getContext().getSession().get("client");
            user=clientDao.getClientByEmail(user.getEmail());
            user.setImgUrl(relativePath+imgFileName);
            clientDao.save(user);
        }        return "success";
    }

    @Override
    public String modifyImgUrlPage(){
        return "success";
    }
    @Override
    public String modifyPersonalInfoPage(){
        Client user=(Client)ActionContext.getContext().getSession().get("client");
        this.client=clientDao.getClientByEmail(user.getEmail());
        return "success";
    }

    @Override
    public String modifyPersonalInfo(){
        Client user=(Client)ActionContext.getContext().getSession().get("client");
        user=clientDao.getClientByEmail(user.getEmail());
        if(client.getName()!=null && !"".equals(client.getName())){
            user.setName(client.getName());
        }
        if(client.getGender()!=null && !"".equals(client.getGender())){
            user.setGender(client.getGender());
        }
        if(client.getAge()>0){
            user.setAge(client.getAge());
        }
        if(client.getEmail()!=null && !"".equals(client.getEmail())){
            user.setEmail(client.getEmail());
        }
        clientDao.save(user);
        return "success";
    }



    @Override
    public String myPartActPage(Long clientId){
        Session session= ThreadUtil.getThreadLocal().get();
        String hql="SELECT Activity FROM client_activity,activity WHERE clientId=? and activity.id=activityId";
        Query query=session.createQuery(hql);
        query.setLong(0,clientId);
        this.activities=query.list();
        return "success";
    }

    @Override
    public long getParticipatorId() {
        return participatorId;
    }

    @Override
    public void setParticipatorId(long participatorId) {
        this.participatorId = participatorId;
    }

    @Override
    public Client getParticipator() {
        return participator;
    }

    @Override
    public void setParticipator(Client participator) {
        this.participator = participator;
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
    public File getImg() {
        return img;
    }

    @Override
    public void setImg(File img) {
        this.img = img;
    }

    @Override
    public String getImgFileName() {
        return imgFileName;
    }

    @Override
    public void setImgFileName(String imgFileName) {
        this.imgFileName = imgFileName;
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

}
