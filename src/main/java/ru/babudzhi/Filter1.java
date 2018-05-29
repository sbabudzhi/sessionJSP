package ru.babudzhi;


import javax.servlet.*;
import java.io.IOException;
import java.util.Date;

public class Filter1 implements Filter {

    public void init(FilterConfig filterConfig) {
        String testParam = filterConfig.getInitParameter("test-param");
        System.out.println("Test " + testParam);
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String ip = servletRequest.getRemoteAddr();
        System.out.println("IpAdress " + ip + "  Time " + new Date().toString());
        filterChain.doFilter(servletRequest,servletResponse);
    }

    public void destroy() {

    }
}
