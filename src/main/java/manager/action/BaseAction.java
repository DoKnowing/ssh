package manager.action;

import manager.dao.ManagerDao;
import manager.model.Manager;

public class BaseAction {
    ManagerDao managerDao=new ManagerDao();
    Manager manager;

    public String login(){
        if(manager.getName()==null || manager.getPswd()==null){
            return "input";
        }
        Manager returnManager= managerDao.getManager(manager);
        if(returnManager!=null){
            return "success";
        }else{
            return "error";
        }
    }

    public String homePage(){
            return "success";
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }
}
