package manager.actionInterface;

import manager.daoInterface.ManagerDaoInter;
import manager.model.Manager;

public interface BaseActionInter {
    String loginPage();

    String login();

    String homePage();

    Manager getManager();

    void setManager(Manager manager);

    ManagerDaoInter getManagerDao();

    void setManagerDao(ManagerDaoInter managerDao);
}
