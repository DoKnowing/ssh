package client.actionInterface;

import common.daoInterface.ActivityDaoInter;
import common.daoInterface.CatgoryDaoInter;
import common.daoInterface.ClientDaoInter;
import common.model.Activity;
import common.model.Catgory;
import common.model.Client;

import javax.mail.MessagingException;
import java.security.GeneralSecurityException;
import java.util.List;

public interface BaseActionInter {
    String homePage();

    String registerPage();

    String loginPage();

    String login();

    void validateLogin();

    String register() throws GeneralSecurityException, MessagingException;

    String activate() throws Exception;

    Client getClient();

    void setClient(Client client);

    String getCheckCode();

    void setCheckCode(String checkCode);

    String getMessage();

    void setMessage(String message);

    List<Catgory> getCatgories();

    void setCatgories(List<Catgory> catgories);

    List<Activity> getActivities();

    void setActivities(List<Activity> activities);

    ClientDaoInter getClientDao();

    void setClientDao(ClientDaoInter clientDao);

    CatgoryDaoInter getCatgoryDao();

    void setCatgoryDao(CatgoryDaoInter catgoryDao);

    ActivityDaoInter getActivityDao();

    void setActivityDao(ActivityDaoInter activityDao);
}
