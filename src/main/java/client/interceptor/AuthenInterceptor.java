package client.interceptor;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import common.dao.ClientDao;
import common.model.Client;

/**
 * @Author: Sma
 * @date: 2017-10-29 11:07
 * @explain:
 */
public class AuthenInterceptor extends AbstractInterceptor {
    @Override
    public String intercept(ActionInvocation invocation) throws Exception {
        ClientDao clientDao=new ClientDao();
        ActionContext context=invocation.getInvocationContext();
        Client client=(Client)context.getSession().get("client");
        client=clientDao.getClientByEmail(client.getEmail());
        if(client.getIsAuthenticated()==1){
            return invocation.invoke();
        }
        context.put("tip", "你还没有认证");
        return "authentication";

    }
}
