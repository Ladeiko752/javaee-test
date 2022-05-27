package com.example.javaeetest.crud;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.HashMap;
import java.util.Map;

@WebListener
public class ContextListener implements ServletContextListener {

    private Map<Integer, MyUser> users;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext servletContext = servletContextEvent.getServletContext();
        users = new HashMap<>();
        servletContext.setAttribute("users", users);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        users = null;
    }
}
