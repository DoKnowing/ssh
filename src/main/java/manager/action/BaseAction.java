package manager.action;

import client.dao.CatgoryDao;
import manager.dao.ManagerDao;
import manager.model.Manager;

public class BaseAction {
    ManagerDao managerDao=new ManagerDao();
    private String name;
    private String pswd;

    public String login(){
        Manager manager= managerDao.getManager(this.name,this.pswd);
        if(manager!=null){
            return "success";
        }else{
            return "error";
        }
    }

    public String homePage(){
            return "success";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPswd() {
        return pswd;
    }

    public void setPswd(String pswd) {
        this.pswd = pswd;
    }
}
