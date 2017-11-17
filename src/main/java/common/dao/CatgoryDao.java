package common.dao;

import common.daoInterface.CatgoryDaoInter;
import common.model.Catgory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import util.ThreadUtil;

import java.util.List;

/**
 * @Author: Sma
 * @date: 2017-10-22 16:31
 * @explain:
 */
@Service("catgoryDao")
public class CatgoryDao implements CatgoryDaoInter {

    @Override
    public List<Catgory> getCatgories(){
        List<Catgory> catgories;
        Session session= ThreadUtil.getThreadLocal().get();
        String hql="FROM Catgory";
        Query query=session.createQuery(hql);
        catgories=query.list();
        return catgories;
    }

    @Override
    public Catgory getCategoryById(long catgoryId) {
        Catgory catgory;
        Session session= ThreadUtil.getThreadLocal().get();
        String hql="FROM Catgory WHERE id=?";
        Query query=session.createQuery(hql);
        query.setLong(0,catgoryId);
        catgory=(Catgory)query.uniqueResult();
        return catgory;
    }

    @Override
    public void save(Catgory catgory) {
        Session session= ThreadUtil.getThreadLocal().get();
        session.save(catgory);
    }

    @Override
    public void remove(Catgory catgory) {
        Session session= ThreadUtil.getThreadLocal().get();
        session.delete(catgory);
    }
}
