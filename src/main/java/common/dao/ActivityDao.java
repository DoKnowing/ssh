package common.dao;

import common.model.Activity;
import common.model.Client;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: Sma
 * @date: 2017-10-22 16:45
 * @explain:
 */
public class ActivityDao {
    private List<Activity> activitiesByInstitution;

    public List<Activity> getAllActivities() {
        List<Activity> activities = new LinkedList<>();
        for (int i = 0; i < 3; i++) {
            Activity activity = new Activity();
            activity.setId(i);
            activity.setName("" + i);
            activity.setTime(new Date());
            activity.setLocation("" + i);
            activity.setOutline("" + i);
            activity.setDetail("" + i);
            activity.setStatus("开启");
            List<Client> participators=new LinkedList<>();
            Client client=new Client();
            client.setName("lq");
            client.setAge(3);
            client.setGender("女");
            client.setInstitution("华南理工大学");
            client.setImgUrl("/imgs/1.jpg");
            participators.add(client);
            activity.setParticipators(participators);
            activity.setImgs(new String[]{"/imgs/1.jpg"});

            activities.add(activity);
        }
        return activities;
    }
    public List<Activity> getActivitiesByInstitution(String institution) {

        //注：所有从该页面出现的活动都是开启的活动
        //从活动的发起人获得活动学校
        List<Activity> activities = new LinkedList<>();
        for (int i = 0; i < 3; i++) {
            Activity activity = new Activity();
            activity.setId(i);
            activity.setName("" + i);
            activity.setTime(new Date());
            activity.setLocation("" + i);
            activity.setOutline("" + i);
            activity.setDetail("" + i);
            activity.setStatus("开启");
            List<Client> participators=new LinkedList<>();
            Client client=new Client();
            client.setName("lq");
            client.setAge(3);
            client.setGender("女");
            client.setInstitution("华南理工大学");
            client.setImgUrl("/imgs/1.jpg");
            participators.add(client);
            activity.setParticipators(participators);
            activity.setImgs(new String[]{"/imgs/1.jpg"});

            activities.add(activity);
        }
        return activities;
    }

    public  List<Activity> getActivitiesByCatgory(int catgoryId) {
        //注：所有从该页面出现的活动都是开启的活动
        List<Activity> activities = new LinkedList<>();
        for (int i = 0; i < 3; i++) {
            Activity activity = new Activity();
            activity.setId(i);
            activity.setName("" + i);
            activity.setTime(new Date());
            activity.setLocation("" + i);
            activity.setOutline("" + i);
            activity.setDetail("" + i);
            activity.setStatus("开启");
            List<Client> participators=new LinkedList<>();
            Client client=new Client();
            client.setName("lq");
            client.setAge(3);
            client.setGender("女");
            client.setInstitution("华南理工大学");
            client.setImgUrl("/imgs/1.jpg");
            participators.add(client);
            activity.setParticipators(participators);
            activity.setImgs(new String[]{"imgs/1.jpg"});

            activities.add(activity);
        }
        return activities;
    }

    public List<Activity> getActivitiesByDate(Date startDate, Date endDate) {
        //注：所有从该页面出现的活动都是开启的活动
        List<Activity> activities = new LinkedList<>();
        for (int i = 0; i < 3; i++) {
            Activity activity = new Activity();
            activity.setId(i);
            activity.setName("" + i);
            activity.setTime(new Date());
            activity.setLocation("" + i);
            activity.setOutline("" + i);
            activity.setDetail("" + i);
            activity.setStatus("开启");
            List<Client> participators=new LinkedList<>();
            Client client=new Client();
            client.setName("lq");
            client.setAge(3);
            client.setGender("女");
            client.setInstitution("华南理工大学");
            client.setImgUrl("/imgs/1.jpg");
            participators.add(client);
            activity.setParticipators(participators);
            activity.setImgs(new String[]{"/imgs/1.jpg"});

            activities.add(activity);
        }
        return activities;
    }

    public Activity getActivityById(long activityId) {
        int i=1;
        Activity activity=new Activity();
        activity.setId(i);
        activity.setName("Name" + i);
        activity.setTime(new Date());
        activity.setLocation("Location" + i);
        activity.setOutline("Outline" + i);
        activity.setDetail("Detail" + i);
        activity.setStatus("开启");
        List<Client> participators=new LinkedList<>();
        Client client=new Client();
        client.setName("lq");
        client.setAge(3);
        client.setGender("女");
        client.setInstitution("华南理工大学");
        client.setImgUrl("/imgs/1.jpg");
        participators.add(client);
        activity.setParticipators(participators);
        activity.setImgs(new String[]{"/imgs/1.jpg"});
        return activity;
    }

    public void savePartInfo() {

    }

    public boolean hasParticipated(int activityId) {
        return true;
    }

    public void removeParticipatition(String email, int activityId) {
    }

    public List<Activity> findActivitiesByCreator(String email) {
        List<Activity> activities = new LinkedList<>();
        for (int i = 0; i < 3; i++) {
            Activity activity = new Activity();
            activity.setId(i);
            activity.setName("" + i);
            activity.setTime(new Date());
            activity.setLocation("" + i);
            activity.setOutline("" + i);
            activity.setDetail("" + i);
            activity.setStatus("开启");
            List<Client> participators=new LinkedList<>();
            Client client=new Client();
            client.setName("lq");
            client.setAge(3);
            client.setGender("女");
            client.setInstitution("华南理工大学");
            client.setImgUrl("/imgs/1.jpg");
            participators.add(client);
            activity.setParticipators(participators);
            activity.setImgs(new String[]{"/imgs/1.jpg"});

            activities.add(activity);
        }
        return activities;
    }

    public List<Activity> findActivitiesByParticipator(String email) {
        List<Activity> activities = new LinkedList<>();
        for (int i = 0; i < 3; i++) {
            Activity activity = new Activity();
            activity.setId(i);
            activity.setName("" + i);
            activity.setTime(new Date());
            activity.setLocation("" + i);
            activity.setOutline("" + i);
            activity.setDetail("" + i);
            activity.setStatus("开启");
            List<Client> participators=new LinkedList<>();
            Client client=new Client();
            client.setName("lq");
            client.setAge(3);
            client.setGender("女");
            client.setInstitution("华南理工大学");
            client.setImgUrl("/imgs/1.jpg");
            participators.add(client);
            activity.setParticipators(participators);
            activity.setImgs(new String[]{"/imgs/1.jpg"});

            activities.add(activity);
        }
        return activities;
    }

    public void closeActivityById(int activityId) {
        //将活动表中该活动状态置为关闭
    }

    public Activity getActivityByIdAndEmail(long id,String email) {
        //在表中查找我是否已经参加过该活动
        Activity activity=new Activity();
        return activity;
    }

    public void saveActivity(Activity activity) {
    }

    public void save(Activity activity) {
    }

    public void remove(Activity activity) {
    }
}
