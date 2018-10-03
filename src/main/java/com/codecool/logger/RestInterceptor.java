package com.codecool.logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class RestInterceptor implements HandlerInterceptor {

    private final Logger logger = LoggerFactory.getLogger(RestInterceptor.class);

    private void log(String message) {
        logger.info(message);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        String message = String.format("%s %s - %d",    request.getMethod(),
                                                        request.getRequestURI(),
                                                        response.getStatus());
        log(message);
    }
}

