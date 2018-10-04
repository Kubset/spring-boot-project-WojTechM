package com.codecool.logger;

import com.codecool.controller.EmailController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;

@Component
public class EmailInterceptor implements HandlerInterceptor {

    private EmailController emailController;

    @Autowired
    public EmailInterceptor(EmailController emailController) {
        this.emailController = emailController;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        if (response.getStatus() < 500) return;
        String message = String.format("[%s] %s: %s %s - %d",
                LocalDateTime.now().toString(),
                request.getRemoteAddr(),
                request.getMethod(),
                request.getRequestURI(),
                response.getStatus());

        emailController.sendEmailWithoutTemplating("exception", message);
    }
}

