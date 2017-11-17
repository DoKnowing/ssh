package client.actionInterface;

import common.daoInterface.ClientDaoInter;
import common.model.Activity;
import common.model.Client;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface ClientActionInter {
    String participator();

    String personalPage();

    String modifyImgUrl() throws IOException;

    String modifyImgUrlPage();

    String modifyPersonalInfoPage();

    String modifyPersonalInfo();

    String myPartActPage(Long clientId);

    long getParticipatorId();

    void setParticipatorId(long participatorId);

    Client getParticipator();

    void setParticipator(Client participator);

    Client getClient();

    void setClient(Client client);

    File getImg();

    void setImg(File img);

    String getImgFileName();

    void setImgFileName(String imgFileName);

    List<Activity> getActivities();

    void setActivities(List<Activity> activities);

    ClientDaoInter getClientDao();

    void setClientDao(ClientDaoInter clientDao);
}
