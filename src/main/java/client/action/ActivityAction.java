package client.action;

import common.dao.ClientDao;
import common.daoInterface.ActivityDaoInter;
import common.daoInterface.CatgoryDaoInter;
import common.daoInterface.ClientDaoInter;
import common.model.Client;
import com.opensymphony.xwork2.ActionContext;
import common.dao.ActivityDao;
import common.dao.CatgoryDao;
import common.model.Activity;
import common.model.Catgory;
import common.model.ClientActivity;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Author: Sma
 * @date: 2017-10-28 18:07
 * @explain:
 */
@Controller@Scope("prototype")
public class ActivityAction implements client.actionInterface.ActivityActionInter {
    @Resource private ActivityDaoInter activityDao;
    @Resource private ClientDaoInter clientDao;
    @Resource CatgoryDaoInter catgoryDao;
    private List<Activity> activities;
    private List<Catgory> catgories;
    private Activity activity;
    ClientActivity clientActivity;
    private int catgoryId;
    private Date startDate;
    private Date endDate;
    private long activityId;
    private File[] img;
    private String[] imgFileName;

    @Override
    public String byCatgory(){
        this.activities=activityDao.getActivitiesByCatgory(this.catgoryId);
        return "success";
    }

    @Override
    public String byDate(){
        this.activities=activityDao.getActivitiesByDate(startDate,endDate);
        return "success";
    }

    @Override
    public String detailPage(){
        this.activity=activityDao.getActivityById(activityId);
        return "success";
    }

    @Override
    public String moreDetailPage(){
        this.activity=activityDao.getActivityById(activityId);
        return "success";
    }

    @Override
    public String participatePage(){
        Client user=(Client)ActionContext.getContext().getSession().get("client");
        user=clientDao.getClientByEmail(user.getEmail());
        Activity activity=activityDao.getActivityById(activityId);
        if(activity.getStatus().equals("active")){
            if(activity.getInitiator().getId()!=user.getId() && activityDao.getByClientIdAndActivityId(user.getId(),activityId)==null){
                return "success";
            }
        }
        return "failure";
    }

    @Override
    public String participate(){
        Client client=(Client) ActionContext.getContext().getSession().get("client");
        client=clientDao.getClientByEmail(client.getEmail());
        clientActivity.setClient(client);

        clientActivity.setActivity(activityDao.getActivityById(activityId));
        activityDao.savePartInfo(clientActivity);
        return "success";
    }



    @Override
    public String myCreaActPage(){
        Client user=(Client)ActionContext.getContext().getSession().get("client");
        user=clientDao.getClientByEmail(user.getEmail());
        this.activities=activityDao.findActivitiesByCreator(user.getId());
        return "success";
    }

    @Override
    public String myPartActPage(){
        Client user=(Client)ActionContext.getContext().getSession().get("client");
        user=clientDao.getClientByEmail(user.getEmail());
        this.activities=activityDao.findActivitiesByParticipator(user.getId());
        return "success";
    }

    @Override
    public String myActivityDetailPage(){
        this.activity=activityDao.getActivityById(activityId);
        return "success";
    }

    @Override
    public String closeActivity(){
        Activity existAct=activityDao.getActivityById(activityId);
        if(existAct.getStatus()!=null && "active".equals(existAct.getStatus())){
            activityDao.closeActivityById(activityId);
        }else{
            return "failure";
        }

        return "success";
    }

    @Override
    public String dropOutActivity(){
        Client client= (Client)ActionContext.getContext().getSession().get("client");
        client=clientDao.getClientByEmail(client.getEmail());
        ClientActivity clientActivity=activityDao.getByClientIdAndActivityId(client.getId(),activityId);
        activityDao.removeParticipatition(clientActivity);
        return "success";
    }

    @Override
    public String creaActPage(){
        Client user= (Client)ActionContext.getContext().getSession().get("client");
        user=clientDao.getClientByEmail(user.getEmail());

        if(user.getIsAuthenticated()==1) {

            catgories = catgoryDao.getCatgories();
            return "success";
        }else {
            return "failure";
        }
    }

    @Override
    public String createActivity() throws IOException, ParseException {
        String relativePath="/imgs/activity/";
        String realPath="E:\\Idea_Workplace\\ssh\\src\\main\\webapp\\imgs\\activity";
        if(img!=null) {
            String[] imgUrl=new String[img.length];
            for (int i = 0; i < img.length; i++) {

                File saveFile = new File(realPath, imgFileName[i]);
                FileUtils.copyFile(img[i], saveFile);
                imgUrl[i] = relativePath + imgFileName[i];
            }
            activity.setImgs(imgUrl);
        }
        DateFormat dateFormat=DateFormat.getDateInstance();
        String dateString=dateFormat.format(activity.getTime());
        activity.setTime(new SimpleDateFormat("yyyyMMdd-HH").parse(dateString));
        activity.setStatus("active");
        Client initiator=(Client) ActionContext.getContext().getSession().get("client");
        initiator=clientDao.getClientByEmail(initiator.getEmail());
        activity.setInitiator(initiator);
        activity.setCatgory(catgoryDao.getCategoryById(catgoryId));


        activityDao.saveActivity(activity);

        return "success";
    }

    @Override
    public int getCatgoryId() {
        return catgoryId;
    }

    @Override
    public void setCatgoryId(int catgoryId) {
        this.catgoryId = catgoryId;
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
    public Date getStartDate() {
        return startDate;
    }

    @Override
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Override
    public Date getEndDate() {
        return endDate;
    }

    @Override
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Override
    public long getActivityId() {
        return activityId;
    }

    @Override
    public void setActivityId(long activityId) {
        this.activityId = activityId;
    }

    @Override
    public Activity getActivity() {
        return activity;
    }

    @Override
    public void setActivity(Activity activity) {
        this.activity = activity;
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
    public File[] getImg() {
        return img;
    }

    @Override
    public void setImg(File[] img) {
        this.img = img;
    }

    @Override
    public String[] getImgFileName() {
        return imgFileName;
    }

    @Override
    public void setImgFileName(String[] imgFileName) {
        this.imgFileName = imgFileName;
    }

    @Override
    public ClientActivity getClientActivity() {
        return clientActivity;
    }

    @Override
    public void setClientActivity(ClientActivity clientActivity) {
        this.clientActivity = clientActivity;
    }

    @Override
    public ActivityDaoInter getActivityDao() {
        return activityDao;
    }

    @Override
    public void setActivityDao(ActivityDaoInter activityDao) {
        this.activityDao = activityDao;
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
}
