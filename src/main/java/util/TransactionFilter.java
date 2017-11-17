package util;

import javax.servlet.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.io.IOException;

public class TransactionFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        Transaction tx=null;
        Session session= HibernateUtils.openSession();
        ThreadUtil.getThreadLocal().set(session);
        try {
            tx=session.beginTransaction();
            chain.doFilter(req,res);
            tx.commit();
        }catch (Exception e){
            tx.rollback();
            throw e;
        }finally {
            session.close();
            ThreadUtil.getThreadLocal().remove();
        }
    }

    @Override
    public void destroy() {

    }
}
