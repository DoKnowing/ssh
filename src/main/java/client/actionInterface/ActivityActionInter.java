package client.actionInterface;

import common.daoInterface.ActivityDaoInter;
import common.daoInterface.CatgoryDaoInter;
import common.daoInterface.ClientDaoInter;
import common.model.Activity;
import common.model.Catgory;
import common.model.ClientActivity;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

public interface ActivityActionInter {
    String byCatgory();

    String byDate();

    String detailPage();

    String moreDetailPage();

    String participatePage();

    String participate();

    String myCreaActPage();

    String myPartActPage();

    String myActivityDetailPage();

    String closeActivity();

    String dropOutActivity();

    String creaActPage();

    String createActivity() throws IOException, ParseException;

    int getCatgoryId();

    void setCatgoryId(int catgoryId);

    List<Activity> getActivities();

    void setActivities(List<Activity> activities);

    Date getStartDate();

    void setStartDate(Date startDate);

    Date getEndDate();

    void setEndDate(Date endDate);

    long getActivityId();

    void setActivityId(long activityId);

    Activity getActivity();

    void setActivity(Activity activity);

    List<Catgory> getCatgories();

    void setCatgories(List<Catgory> catgories);

    File[] getImg();

    void setImg(File[] img);

    String[] getImgFileName();

    void setImgFileName(String[] imgFileName);

    ClientActivity getClientActivity();

    void setClientActivity(ClientActivity clientActivity);

    ActivityDaoInter getActivityDao();

    void setActivityDao(ActivityDaoInter activityDao);

    ClientDaoInter getClientDao();

    void setClientDao(ClientDaoInter clientDao);

    CatgoryDaoInter getCatgoryDao();

    void setCatgoryDao(CatgoryDaoInter catgoryDao);
}
