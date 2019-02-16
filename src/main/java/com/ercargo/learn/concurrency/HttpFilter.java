package com.ercargo.learn.concurrency;


import com.ercargo.learn.concurrency.threadLocal.RequestHolder;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author ercargo  on 2019/2/16
 * @DESCRIBE
 */
@Slf4j
public class HttpFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        //request.getSession().getAttribute("user");
        log.info("do filter,{},{}",Thread.currentThread().getId(),request.getServletPath());
        /**
         * 存入对应的值（线程id）
         */
        RequestHolder.add(Thread.currentThread().getId());
        /**
         * 如果filter 不需要拦截这个请求，只想做单独的数据处理时，  就要掉用这个方法，把之前的request和response传进去
         */
        filterChain.doFilter(servletRequest,servletResponse);

    }

    @Override
    public void destroy() {

    }
}
