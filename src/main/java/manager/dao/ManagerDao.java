package manager.dao;

import manager.model.Manager;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import util.HibernateUtils;
import util.ThreadUtil;
@Service
public class ManagerDao implements manager.daoInterface.ManagerDaoInter {

    @Override
    public Manager getManager(Manager manager){
        Session session= ThreadUtil.getThreadLocal().get();
        Manager returnManager;
//        idea一般默认会检查ql语句，会报错说can't resolve...，在左边的灯泡里面禁用检查即可
        String hql="FROM  Manager WHERE name=? and pswd=?";
        Query query=session.createQuery(hql);
        query.setString(0,manager.getName());
        query.setString(1,manager.getPswd());
        returnManager=(Manager) query.uniqueResult();
        return returnManager;
    }
}
