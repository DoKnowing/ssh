package client.action;

import common.dao.ClientDao;
import common.model.Client;
import com.opensymphony.xwork2.ActionContext;
import common.dao.ActivityDao;
import common.dao.CatgoryDao;
import common.model.Activity;
import common.model.Catgory;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * @Author: Sma
 * @date: 2017-10-28 18:07
 * @explain:
 */
public class ActivityAction {
    private ActivityDao activityDao=new ActivityDao();
    private ClientDao clientDao=new ClientDao();
    CatgoryDao catgoryDao=new CatgoryDao();
    private List<Activity> activities;
    private List<Catgory> catgories;
    private Activity activity;
    private int catgoryId;
    private Date startDate;
    private Date endDate;
    private int activityId;
    private File[] img;
    private String[] imgFileName;

    public String byCatgory(){
        this.activities=activityDao.getActivitiesByCatgory(this.catgoryId);
        return "success";
    }

    public String byDate(){
        this.activities=activityDao.getActivitiesByDate(startDate,endDate);
        return "success";
    }

    public String detailPage(){
        this.activity=activityDao.getActivityById(activityId);
        return "success";
    }

    public String moreDetailPage(){
        this.activity=activityDao.getActivityById(activityId);
        return "success";
    }

    public String participatePage(){
        Client user=(Client) ActionContext.getContext().getSession().get("client");
        if(activityDao.getActivityByIdAndEmail(activityId,user.getEmail())==null)
            return "success";
        else
            return "failure";
    }

    public String participate(){
        activityDao.savePartInfo();
        return "success";
    }



    public String myCreaActPage(){
        Client user=(Client)ActionContext.getContext().getSession().get("client");
        this.activities=activityDao.findActivitiesByCreator(user.getEmail());
        return "success";
    }

    public String myPartActPage(){
        Client user=(Client)ActionContext.getContext().getSession().get("client");
        this.activities=activityDao.findActivitiesByParticipator(user.getEmail());
        return "success";
    }

    public String myActivityDetailPage(){
        this.activity=activityDao.getActivityById(activityId);
        return "success";
    }

    public String closeActivity(){
        Activity existAct=activityDao.getActivityById(activityId);
        if(existAct.getStatus()!=null && "开启".equals(existAct.getStatus())){
            activityDao.closeActivityById(activityId);
        }else{
            return "failure";
        }

        return "success";
    }

    public String dropOutActivity(){
        Client client= (Client)ActionContext.getContext().getSession().get("client");
        activityDao.removeParticipatition(client.getEmail(),activityId);
        return "success";
    }

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

    public String createActivity() throws IOException {

        String realPath= ServletActionContext.getServletContext().
                getRealPath("/WEB-INF/imgs/");
        if(img!=null) {
            String[] imgUrl=new String[img.length];
            for (int i = 0; i < img.length; i++) {

                File saveFile = new File(realPath, imgFileName[i]);
                FileUtils.copyFile(img[i], saveFile);
                imgUrl[i] = realPath + imgFileName[i];
            }
            activity.setImgs(imgUrl);
        }

        activity.setStatus("开启");
        activity.setInitiator((Client) ActionContext.getContext().getSession().get("client"));
        activity.setCatgory(catgoryDao.getCategoryById(catgoryId));


        activityDao.saveActivity(activity);

        return "success";
    }

    public int getCatgoryId() {
        return catgoryId;
    }

    public void setCatgoryId(int catgoryId) {
        this.catgoryId = catgoryId;
    }

    public List<Activity> getActivities() {
        return activities;
    }

    public void setActivities(List<Activity> activities) {
        this.activities = activities;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getActivityId() {
        return activityId;
    }

    public void setActivityId(int activityId) {
        this.activityId = activityId;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public List<Catgory> getCatgories() {
        return catgories;
    }

    public void setCatgories(List<Catgory> catgories) {
        this.catgories = catgories;
    }

    public File[] getImg() {
        return img;
    }

    public void setImg(File[] img) {
        this.img = img;
    }

    public String[] getImgFileName() {
        return imgFileName;
    }

    public void setImgFileName(String[] imgFileName) {
        this.imgFileName = imgFileName;
    }
}
