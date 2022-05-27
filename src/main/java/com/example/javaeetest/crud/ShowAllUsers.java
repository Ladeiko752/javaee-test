package com.example.javaeetest.crud;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "ShowAllUsers", value = "/users")
public class ShowAllUsers extends HttpServlet {
    private Map<Integer, MyUser> users;

    @Override
    public void init() throws ServletException {
        Object users = getServletContext().getAttribute("users");

        if (users == null || !(users instanceof HashMap)){
            throw new IllegalStateException("Cuckold error");
        }else {
            this.users = (Map<Integer, MyUser>) users;
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("users", users.values());
        request.getRequestDispatcher("/user_page.jsp").forward(request, response);

        /*for (MyUser user: users.values()){
            System.out.println(user.getId() + " " + user.getName() + " " + user.getAge());
        }*/
    }

}
