package com.codecool.logger;

import com.codecool.App;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;

@Component
public class RestInterceptor implements HandlerInterceptor {

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        String message = String.format("[%s] %s: %s %s - %d",
                LocalDateTime.now().toString(),
                request.getRemoteAddr(),
                request.getMethod(),
                request.getRequestURI(),
                response.getStatus());
        App.log(message);
    }
}

