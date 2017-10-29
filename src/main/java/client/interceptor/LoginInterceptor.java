package client.interceptor;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import common.model.Client;

/**
 * @Author: Sma
 * @date: 2017-10-29 10:57
 * @explain:
 */
public class LoginInterceptor extends AbstractInterceptor{
    @Override
    public String intercept(ActionInvocation invocation) throws Exception {
        Client client;
        ActionContext context=invocation.getInvocationContext();
        client=(Client)context.getSession().get("client");
        if(client!=null){
            return invocation.invoke();
        }
        context.put("tip", "你还没有登录");
        return "input";
    }
}
