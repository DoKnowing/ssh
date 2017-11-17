package common.dao;

import common.model.Activity;
import common.model.Client;
import common.model.ClientActivity;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import util.ThreadUtil;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: Sma
 * @date: 2017-10-22 16:45
 * @explain:
 */
@Service("activityDao")
public class ActivityDao implements common.daoInterface.ActivityDaoInter {

    @Override
    public List<Activity> getAllActivities() {
        List<Activity> activities = null;
        Session session= ThreadUtil.getThreadLocal().get();
        String hql="FROM Activity";
        Query query=session.createQuery(hql);
        activities=query.list();
        return activities;
    }
    @Override
    public List<Activity> getActivitiesByInstitution(String institution) {
        //注：所有从该页面出现的活动都是开启的活动
        //从活动的发起人获得活动学校
        List<Activity> activities =null;
        Session session= ThreadUtil.getThreadLocal().get();
        String hql="SELECT activity FROM Client client,Activity activity WHERE activity.initiator.id=client.id and institution=? and activity.status='active'";
        Query query=session.createQuery(hql);
        query.setString(0,institution);
        activities=query.list();
        return activities;
    }

    @Override
    public  List<Activity> getActivitiesByCatgory(int catgoryId) {
        //注：所有从该页面出现的活动都是开启的活动
        List<Activity> activities = null;
        Session session= ThreadUtil.getThreadLocal().get();
        String hql="FROM Activity WHERE catgory.id=? and status='active'";
        Query query=session.createQuery(hql);
        query.setLong(0,catgoryId);
        activities=query.list();
        return activities;
    }

    @Override
    public List<Activity> getActivitiesByDate(Date startDate, Date endDate) {
        //注：所有从该页面出现的活动都是开启的活动
        List<Activity> activities = new LinkedList<>();
        Session session= ThreadUtil.getThreadLocal().get();
        String hql="FROM Activity WHERE time>=? and time<=?";
        Query query=session.createQuery(hql);
        query.setDate(0,startDate);
        query.setDate(1,endDate);
        activities=query.list();
        return activities;
    }

    @Override
    public Activity getActivityById(long activityId) {
        Activity activity=null;
        Session session= ThreadUtil.getThreadLocal().get();
        String hql="FROM Activity WHERE id=?";
        Query query=session.createQuery(hql);
        query.setLong(0,activityId);
        activity=(Activity) query.uniqueResult();
        return activity;
    }

    @Override
    public void savePartInfo(ClientActivity clientActivity) {
        Session session=ThreadUtil.getThreadLocal().get();
        session.save(clientActivity);
    }

    @Override
    public void removeParticipatition(ClientActivity clientActivity) {
        Session session=ThreadUtil.getThreadLocal().get();
        session.delete(clientActivity);
    }

    @Override
    public List<Activity> findActivitiesByCreator(long clientId) {
        List<Activity> activities =null;
        Session session=ThreadUtil.getThreadLocal().get();

        String hql="FROM Activity WHERE initiator.id=?";
        Query query=session.createQuery(hql);
        query.setLong(0,clientId);
        activities=query.list();
        return activities;
    }

    @Override
    public List<Activity> findActivitiesByParticipator(long clientId) {
        List<Activity> activities=null;
        Session session=ThreadUtil.getThreadLocal().get();
        String hql="FROM Activity WHERE id in (SELECT activity.id FROM ClientActivity WHERE client.id=?)";
        Query query=session.createQuery(hql);
        query.setLong(0,clientId);
        activities=query.list();
        return activities;
    }

    @Override
    public void closeActivityById(long activityId) {
        //将活动表中该活动状态置为关闭
        Session session=ThreadUtil.getThreadLocal().get();
        String hql="UPDATE Activity SET status='close' WHERE id=?";
        Query query=session.createQuery(hql);
        query.setLong(0,activityId);
        query.executeUpdate();
    }

    @Override
    public ClientActivity getByClientIdAndActivityId(long clientId, long activityId) {
        //在表中查找我是否已经参加过该活动
        ClientActivity clientActitivity;
        Session session=ThreadUtil.getThreadLocal().get();
        String hql="FROM ClientActivity WHERE clientId=? and activityId=?";
        Query query=session.createQuery(hql);
        query.setLong(0,clientId);
        query.setLong(1,activityId);
        clientActitivity=(ClientActivity) query.uniqueResult();
        return clientActitivity;
    }

    @Override
    public void saveActivity(Activity activity) {
        save(activity);
    }

    @Override
    public void save(Activity activity) {
        Session session=ThreadUtil.getThreadLocal().get();
        session.save(activity);
    }

    @Override
    public void remove(Activity activity) {
        Session session=ThreadUtil.getThreadLocal().get();

        session.clear();
        session.delete(activity);
    }
}
