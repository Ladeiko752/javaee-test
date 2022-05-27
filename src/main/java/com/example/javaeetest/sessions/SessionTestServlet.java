package com.example.javaeetest.sessions;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/servlet-test")
public class SessionTestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        User user = (User) session.getAttribute("user");

        PrintWriter printWriter = response.getWriter();

        if (user == null){
            printWriter.println("You are with us for the first time! Welcome!");
            user = new User("Anton", "Ladejko", "IT", "Java, Spring, Hibernate, MySQL");
            session.setAttribute("user", user);
        }else {
            printWriter.println("Welcome back, " + user.getName() + "! We are glad to see you again!");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
