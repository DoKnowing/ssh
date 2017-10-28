package manager.dao;

import manager.model.Manager;

public class ManagerDao {

    public Manager getManager(String name, String pswd){
        Manager manager=new Manager();
        manager.setName("12");
        manager.setPswd("12");
        return manager;
    }
}
