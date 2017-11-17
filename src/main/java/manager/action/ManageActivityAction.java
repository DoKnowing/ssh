package manager.action;

import common.dao.CatgoryDao;
import common.dao.ClientDao;
import common.daoInterface.ActivityDaoInter;
import common.daoInterface.CatgoryDaoInter;
import common.daoInterface.ClientDaoInter;
import common.model.Catgory;
import common.model.Client;
import common.dao.ActivityDao;
import common.model.Activity;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @Author: Sma
 * @date: 2017-10-28 16:13
 * @explain:
 */
@Controller@Scope("prototype")
public class ManageActivityAction implements manager.actionInterface.ManageActivityActionInter {
    @Resource private ActivityDaoInter activityDao;
    @Resource private ClientDaoInter clientDao;
    @Resource private CatgoryDaoInter catgoryDao;
    private List<Activity> activities;
    private Activity activity;
    private long activityId;
    private File[] img;
    private String[] imgFileName;
    private String email;
    private List<Catgory> catgories;
    private long catgoryId;

    @Override
    public String manageActivityPage(){
        this.activities=activityDao.getAllActivities();
        return "success";
    }

    @Override
    public String addActivityPage(){
        catgories=catgoryDao.getCatgories();
        return "success";
    }

    @Override
    public String addActivity() throws IOException {
        Client client=clientDao.getClientByEmail(email);
        activity.setCatgory(catgoryDao.getCategoryById(catgoryId));
        activity.setInitiator(client);
        if(imgFileName!=null && imgFileName.length>0){
            String relativePath="/imgs/catgory/";
            String realPath="E:\\Idea_Workplace\\ssh\\src\\main\\webapp\\imgs\\catgory";
            for(int i=0;i<imgFileName.length;i++){
                File saveFile=new File(realPath,imgFileName[i]);
                FileUtils.copyFile(img[i],saveFile);
                imgFileName[i]=relativePath+imgFileName[i];
            }
            activity.setImgs(imgFileName);
        }
        activityDao.save(activity);
        return "success";
    }

    @Override
    public String modifyActivityPage(){
        activity=activityDao.getActivityById(activityId);
//        catgories=catgoryDao.getCatgories();
        return "success";
    }

    @Override
    public String modifyActivity() throws IOException {
        Activity activity=activityDao.getActivityById(activityId);
        if(activity.getName()!=null && !"".equals(activity.getName())){
            activity.setName(activity.getName());
        }
        if(imgFileName!=null && imgFileName.length>0){
            String relativePath="/imgs/activity/";
            String realPath="E:\\Idea_Workplace\\ssh\\src\\main\\webapp\\imgs\\activity";
            for(int i=0;i<imgFileName.length;i++){
                File saveFile=new File(realPath,imgFileName[i]);
                FileUtils.copyFile(img[i],saveFile);
                imgFileName[i]=relativePath+imgFileName[i];
            }
            activity.setImgs(imgFileName);
        }
        activityDao.save(activity);
        return "success";
    }

    @Override
    public String deleteActivity(){
        Activity activity=activityDao.getActivityById(activityId);
        activityDao.remove(activity);
        return "success";
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
    public Activity getActivity() {
        return activity;
    }

    @Override
    public void setActivity(Activity activity) {
        this.activity = activity;
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
    public String getEmail() {
        return email;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
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
    public long getCatgoryId() {
        return catgoryId;
    }

    @Override
    public void setCatgoryId(long catgoryId) {
        this.catgoryId = catgoryId;
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
