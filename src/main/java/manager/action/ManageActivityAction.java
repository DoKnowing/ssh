package manager.action;

import common.dao.CatgoryDao;
import common.dao.ClientDao;
import common.model.Catgory;
import common.model.Client;
import common.dao.ActivityDao;
import common.model.Activity;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @Author: Sma
 * @date: 2017-10-28 16:13
 * @explain:
 */
public class ManageActivityAction {
    ActivityDao activityDao=new ActivityDao();
    ClientDao clientDao=new ClientDao();
    CatgoryDao catgoryDao=new CatgoryDao();
    List<Activity> activities;
    Activity activity;
    private long activityId;
    private File[] img;
    private String[] imgFileName;
    private String email;
    private List<Catgory> catgories;
    private long catgoryId;

    public String manageActivityPage(){
        this.activities=activityDao.getAllActivities();
        return "success";
    }

    public String addActivityPage(){
        catgories=catgoryDao.getCatgories();
        return "success";
    }

    public String addActivity() throws IOException {
        Client client=clientDao.getClientByEmail(email);
        activity.setCatgory(catgoryDao.getCategoryById(catgoryId));
        activity.setInitiator(client);
        if(imgFileName!=null && imgFileName.length>0){
            String realPath= ServletActionContext.getServletContext().
                    getRealPath("/imgs/activity/");
            for(int i=0;i<imgFileName.length;i++){
                File saveFile=new File(realPath,imgFileName[i]);
                FileUtils.copyFile(img[i],saveFile);
                imgFileName[i]=realPath+imgFileName[i];
            }
            activity.setImgs(imgFileName);
        }
        activityDao.save(activity);
        return "success";
    }

    public String modifyActivityPage(){
        activity=activityDao.getActivityById(activityId);
        catgories=catgoryDao.getCatgories();
        return "success";
    }

    public String modifyActivity() throws IOException {
        Activity activity=activityDao.getActivityById(activityId);
        if(activity.getName()!=null && !"".equals(activity.getName())){
            activity.setName(activity.getName());
        }
        if(imgFileName!=null && imgFileName.length>0){
            String realPath= ServletActionContext.getServletContext().
                    getRealPath("/imgs/activity/");
            for(int i=0;i<imgFileName.length;i++){
                File saveFile=new File(realPath,imgFileName[i]);
                FileUtils.copyFile(img[i],saveFile);
                imgFileName[i]=realPath+imgFileName[i];
            }
            activity.setImgs(imgFileName);
        }
        activityDao.save(activity);
        return "success";
    }

    public String deleteActivity(){
        Activity activity=activityDao.getActivityById(activityId);
        activityDao.remove(activity);
        return "success";
    }

    public List<Activity> getActivities() {
        return activities;
    }

    public void setActivities(List<Activity> activities) {
        this.activities = activities;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public long getActivityId() {
        return activityId;
    }

    public void setActivityId(long activityId) {
        this.activityId = activityId;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Catgory> getCatgories() {
        return catgories;
    }

    public void setCatgories(List<Catgory> catgories) {
        this.catgories = catgories;
    }

    public long getCatgoryId() {
        return catgoryId;
    }

    public void setCatgoryId(long catgoryId) {
        this.catgoryId = catgoryId;
    }
}
