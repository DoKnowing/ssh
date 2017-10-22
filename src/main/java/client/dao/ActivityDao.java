package client.dao;

import client.model.Activity;
import client.model.Catgory;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: Sma
 * @date: 2017-10-22 16:45
 * @explain:
 */
public class ActivityDao {
    public List<Activity> getActivities(){
        List<Activity> activities=new LinkedList<>();
        for(int i=0;i<3;i++){
            Activity activity=new Activity();
            activity.setName(""+i);
            activity.setTime(new Date());
            activity.setLocation(""+i);
            activity.setOutline(""+i);
            activity.setDetail(""+i);
            activities.add(activity);
        }
        return activities;
    }
}
