package common.dao;

import common.model.Client;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import util.ThreadUtil;

import java.util.LinkedList;
import java.util.List;
@Service("clientDao")
public class ClientDao implements common.daoInterface.ClientDaoInter {

    @Override
    public void save(Client client){
        Session session=ThreadUtil.getThreadLocal().get();
        session.save(client);
    }

    @Override
    public Client find(String email){
        return getClientByEmail(email);
    }

    @Override
    public void update(Client client) {
        Session session=ThreadUtil.getThreadLocal().get();
        session.update(client);
    }

    @Override
    public Client getClientById(long id){
        Client client=null;
        Session session=ThreadUtil.getThreadLocal().get();
        String hql="FROM Client WHERE id=?";
        Query query=session.createQuery(hql);
        query.setLong(0,id);
        client=(Client) query.uniqueResult();
        return client;
    }

    @Override
    public Client getClientByEmail(String email){
        Client client=null;
        Session session=ThreadUtil.getThreadLocal().get();
        String hql="FROM Client WHERE email=?";
        Query query=session.createQuery(hql);
        query.setString(0,email);
        client=(Client) query.uniqueResult();
        return client;
    }

    @Override
    public List<Client> getAllClient() {
        List<Client> clients=null;
        Session session= ThreadUtil.getThreadLocal().get();

        String hql="FROM Client";
        Query query=session.createQuery(hql);
        clients=query.list();
        return clients;
    }

    @Override
    public void remove(Client client) {
        Session session=ThreadUtil.getThreadLocal().get();
        session.delete(client);
    }

    @Override
    public Client getClient(Client oriClient) {
        Client client=null;
        Session session=ThreadUtil.getThreadLocal().get();
        String hql="FROM Client WHERE email=? and pswd=?";
        Query query=session.createQuery(hql);
        query.setString(0,oriClient.getEmail());
        query.setString(1,oriClient.getPswd());
        client=(Client) query.uniqueResult();
        return client;
    }
}
