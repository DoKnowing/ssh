package client.action;

import client.dao.ClientDao;
import client.model.Activity;
import client.model.Client;
import com.opensymphony.xwork2.ActionContext;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class ClientAction {
    ClientDao clientDao=new ClientDao();
    private List<Activity> activities;
    private long participatorId;
    private Client participator;
    private Client client;
    private File img;
    private String imgFileName;

    public String participator(){
        this.participator=clientDao.getClientById(participatorId);
        return "success";
    }

    public String participatePage(){
        return "success";
    }

    public String personalPage(){
        Client user=(Client) ActionContext.getContext().getSession().get("client");
        this.client=clientDao.getClientByEmail(user.getEmail());
        return "success";
    }

    public String modifyImgUrl() throws IOException {
        String realPath= ServletActionContext.getServletContext().
                getRealPath("/WEB-INF/imgs/");
        File saveFile=new File(realPath,imgFileName);
        FileUtils.copyFile(img,saveFile);

        Client user=(Client)ActionContext.getContext().getSession().get("client");
        user=clientDao.getClientByEmail(user.getEmail());
        user.setImgUrl(realPath+imgFileName);
        clientDao.save(user);
        return "success";
    }

    public String modifyImgUrlPage(){
        return "success";
    }
    public String modifyPersonalInfoPage(){
        return "success";
    }

    public String modifyPersonalInfo(){
        Client user=(Client)ActionContext.getContext().getSession().get("client");
        user=clientDao.getClientByEmail(user.getEmail());
        if(!client.getName().equals("")){
            user.setName(client.getName());
        }
        if(!client.getGender().equals("")){
            user.setGender(client.getGender());
        }
        if(client.getAge()>0){
            user.setAge(client.getAge());
        }
        if(!client.getEmail().equals("")){
            user.setEmail(client.getEmail());
        }
        clientDao.save(user);
        return "success";
    }



    public String myPartActPage(){
        return "success";
    }

    public long getParticipatorId() {
        return participatorId;
    }

    public void setParticipatorId(long participatorId) {
        this.participatorId = participatorId;
    }

    public Client getParticipator() {
        return participator;
    }

    public void setParticipator(Client participator) {
        this.participator = participator;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public File getImg() {
        return img;
    }

    public void setImg(File img) {
        this.img = img;
    }

    public String getImgFileName() {
        return imgFileName;
    }

    public void setImgFileName(String imgFileName) {
        this.imgFileName = imgFileName;
    }

    public List<Activity> getActivities() {
        return activities;
    }

    public void setActivities(List<Activity> activities) {
        this.activities = activities;
    }
}
