package manager.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import common.model.Client;
import manager.model.Manager;

/**
 * @Author: Sma
 * @date: 2017-10-29 10:57
 * @explain:
 */
public class LoginInterceptor extends AbstractInterceptor{
    @Override
    public String intercept(ActionInvocation invocation) throws Exception {
        Manager manager;
        manager=(Manager)invocation.getInvocationContext().getSession().get("manager");
        if(manager!=null){
            return invocation.invoke();
        }
        return "input";
    }
}
