package com.dstz.security.filter;

import com.dstz.security.IngoreChecker;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 防止CSRF跨站请求攻击。<br>
 * 这个主要是防止外链连入到本系统。
 */
public class RefererCsrfFilter extends IngoreChecker implements Filter {


    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;

        //判断是否外链。
        String referer = req.getHeader("Referer");
        String serverName = request.getServerName();
        //请求不是来自本网站。
        if (null != referer && referer.indexOf(serverName) < 0) {
            //是否包含当前URL
            boolean isIngoreUrl = this.isIngores(referer);
            if (isIngoreUrl) {
                chain.doFilter(request, response);
            } else {
                req.getRequestDispatcher("/commons/csrf.jsp").forward(req, response);
            }
        } else {
            chain.doFilter(request, response);
        }
    }

    @Override
    public void init(FilterConfig config) throws ServletException {
    }

}
