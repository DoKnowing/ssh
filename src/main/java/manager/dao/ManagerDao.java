package manager.dao;

import manager.model.Manager;

public class ManagerDao {

    public Manager getManager(Manager manager){
        Manager returnManager=new Manager();
        returnManager.setName("12");
        returnManager.setPswd("12");
        return returnManager;
    }
}
