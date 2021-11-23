package com.imooc.restful.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class AccessHistoryInterceptor implements HandlerInterceptor {
    private Logger logger = LoggerFactory.getLogger(AccessHistoryInterceptor.class);

    public boolean preHandle(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, Object handler) throws Exception {
        StringBuilder log = new StringBuilder();
        log.append(request.getRemoteAddr());
        log.append("|");
        log.append(request.getRequestURL());
        log.append("|");
        log.append(request.getHeader("user-agent"));
        logger.info(log.toString());
        return true;
    }
}
