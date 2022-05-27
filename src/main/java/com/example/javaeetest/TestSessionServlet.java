package com.example.javaeetest;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/main")
public class TestSessionServlet extends HttpServlet {

    private static final String NAME = "name";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();

        String name = request.getParameter(NAME);
        if (name != null){
            session.setAttribute(NAME, name);
            response.getWriter().println("Welcome back, " + name);
            return;
        }

        Object attribute = session.getAttribute(NAME);
        if (attribute == null){
            response.getWriter().println("Name is Empty!");
            return;
        }else {
            String currentName = (String) attribute;
            response.getWriter().println("Current name: " + currentName);
            response.getWriter().println("Session id: " + session.getId());
        }
    }
}
