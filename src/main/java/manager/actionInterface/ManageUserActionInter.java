package manager.actionInterface;

import common.daoInterface.ClientDaoInter;
import common.model.Client;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface ManageUserActionInter {
    String manageUserPage();

    String addUserPage();

    String addUser() throws IOException;

    String modifyUserPage();

    String modifyUser() throws IOException;

    String deleteUser();

    List<Client> getClients();

    void setClients(List<Client> clients);

    Client getClient();

    void setClient(Client client);

    long getClientId();

    void setClientId(long clientId);

    File getImg();

    void setImg(File img);

    String getImgFileName();

    void setImgFileName(String imgFileName);

    ClientDaoInter getClientDao();

    void setClientDao(ClientDaoInter clientDao);
}
