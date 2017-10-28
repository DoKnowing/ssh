package client.action;

import client.dao.ActivityDao;
import client.dao.CatgoryDao;
import client.dao.ClientDao;
import client.model.Activity;
import client.model.Catgory;
import client.model.Client;
import com.opensymphony.xwork2.ActionContext;

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
    ClientDao clientDao=new ClientDao();

    public String homePage(){

        this.catgories=catgoryDao.getCatgories();
        Client user= (Client)ActionContext.getContext().getSession().get("client");
        Client client=clientDao.getClientByEmail(user.getEmail());
        this.activities=activityDao.getActivitiesByInstitution(client.getInstitution());
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
