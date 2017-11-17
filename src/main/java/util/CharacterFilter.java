package util;

import org.apache.struts2.dispatcher.ng.filter.StrutsPrepareAndExecuteFilter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class CharacterFilter extends StrutsPrepareAndExecuteFilter {
    @Override
    public void doFilter(javax.servlet.ServletRequest req, javax.servlet.ServletResponse res, javax.servlet.FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request=(HttpServletRequest)req;
        request.setCharacterEncoding("UTF-8");
        chain.doFilter(request,res);
//        super.doFilter(req, res, chain);
    }
}
