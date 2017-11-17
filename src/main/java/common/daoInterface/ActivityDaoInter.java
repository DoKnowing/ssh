package common.daoInterface;

import common.model.Activity;
import common.model.ClientActivity;

import java.util.Date;
import java.util.List;

public interface ActivityDaoInter {
    List<Activity> getAllActivities();

    List<Activity> getActivitiesByInstitution(String institution);

    List<Activity> getActivitiesByCatgory(int catgoryId);

    List<Activity> getActivitiesByDate(Date startDate, Date endDate);

    Activity getActivityById(long activityId);

    void savePartInfo(ClientActivity clientActivity);

    void removeParticipatition(ClientActivity clientActivity);

    List<Activity> findActivitiesByCreator(long clientId);

    List<Activity> findActivitiesByParticipator(long clientId);

    void closeActivityById(long activityId);

    ClientActivity getByClientIdAndActivityId(long clientId, long activityId);

    void saveActivity(Activity activity);

    void save(Activity activity);

    void remove(Activity activity);
}
