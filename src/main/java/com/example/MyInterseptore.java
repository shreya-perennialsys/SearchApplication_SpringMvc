package com.example;

import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyInterseptore extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("This is pre handler..");
        String name=request.getParameter("user");
        if (name.startsWith("s")){
            response.setContentType("text/html");
            response.getWriter().println("Invalid name....Name should not start with s");
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("this post handler");
        modelAndView.setStatus(HttpStatus.ACCEPTED);
        HttpStatus status=modelAndView.getStatus();
        modelAndView.addObject("status",status);
        super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("This is after completion of method...");

        super.afterCompletion(request, response, handler, ex);
    }
}
