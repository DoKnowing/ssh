package client.action;

import client.dao.ActivityDao;
import client.dao.CatgoryDao;
import client.model.Activity;
import client.model.Catgory;

import java.util.List;

/**
 * @Author: Sma
 * @date: 2017-10-22 11:10
 * @explain:
 */
public class HomeAction {
    List<Catgory> catgories;
    List<Activity> activities;
    CatgoryDao catgoryDao=new CatgoryDao();
    ActivityDao activityDao=new ActivityDao();

    public String home(){
        this.catgories=catgoryDao.getCatgories();
        this.activities=activityDao.getActivities();
        return "success";
    }

    public List<Catgory> getCatgories() {
        return catgories;
    }

    public void setCatgories(List<Catgory> catgories) {
        this.catgories = catgories;
    }

    public List<Activity> getActivities() {
        return activities;
    }

    public void setActivities(List<Activity> activities) {
        this.activities = activities;
    }
}
