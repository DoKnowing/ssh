package manager.actionInterface;

import common.daoInterface.ActivityDaoInter;
import common.daoInterface.CatgoryDaoInter;
import common.daoInterface.ClientDaoInter;
import common.model.Activity;
import common.model.Catgory;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface ManageActivityActionInter {
    String manageActivityPage();

    String addActivityPage();

    String addActivity() throws IOException;

    String modifyActivityPage();

    String modifyActivity() throws IOException;

    String deleteActivity();

    List<Activity> getActivities();

    void setActivities(List<Activity> activities);

    Activity getActivity();

    void setActivity(Activity activity);

    long getActivityId();

    void setActivityId(long activityId);

    File[] getImg();

    void setImg(File[] img);

    String[] getImgFileName();

    void setImgFileName(String[] imgFileName);

    String getEmail();

    void setEmail(String email);

    List<Catgory> getCatgories();

    void setCatgories(List<Catgory> catgories);

    long getCatgoryId();

    void setCatgoryId(long catgoryId);

    ActivityDaoInter getActivityDao();

    void setActivityDao(ActivityDaoInter activityDao);

    ClientDaoInter getClientDao();

    void setClientDao(ClientDaoInter clientDao);

    CatgoryDaoInter getCatgoryDao();

    void setCatgoryDao(CatgoryDaoInter catgoryDao);
}
