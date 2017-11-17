package manager.action;

import com.opensymphony.xwork2.ActionContext;
import manager.dao.ManagerDao;
import manager.daoInterface.ManagerDaoInter;
import manager.model.Manager;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

@Controller@Scope("prototype")
public class BaseManagerAction implements manager.actionInterface.BaseActionInter {
    @Resource private ManagerDaoInter managerDao;
    Manager manager;

    @Override
    public String loginPage(){
        return "success";
    }

    @Override
    public String login(){
        if(manager.getName()==null || manager.getPswd()==null){
            return "input";
        }
        Manager returnManager= managerDao.getManager(manager);
        if(returnManager!=null){
            ActionContext.getContext().getSession().put("manager",manager);
            return "success";
        }else{
            return "error";
        }
    }

    @Override
    public String homePage(){
            return "success";
    }

    @Override
    public Manager getManager() {
        return manager;
    }

    @Override
    public void setManager(Manager manager) {
        this.manager = manager;
    }

    @Override
    public ManagerDaoInter getManagerDao() {
        return managerDao;
    }

    @Override
    public void setManagerDao(ManagerDaoInter managerDao) {
        this.managerDao = managerDao;
    }
}
