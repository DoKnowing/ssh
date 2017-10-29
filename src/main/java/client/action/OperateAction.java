package client.action;

import com.opensymphony.xwork2.ActionContext;
import common.dao.ActivityDao;
import common.dao.CatgoryDao;
import common.dao.ClientDao;
import common.model.Activity;
import common.model.Catgory;
import common.model.Client;

import java.util.List;

/**
 * @Author: Sma
 * @date: 2017-10-29 17:15
 * @explain:
 */
public class OperateAction {
    List<Catgory> catgories;
    List<Activity> activities;
    CatgoryDao catgoryDao=new CatgoryDao();
    ActivityDao activityDao=new ActivityDao();
    ClientDao clientDao=new ClientDao();

    public String homePage(){

        this.catgories=catgoryDao.getCatgories();
        Client user= (Client) ActionContext.getContext().getSession().get("client");
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
