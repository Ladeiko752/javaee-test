package com.example.javaeetest.crud;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "UpdateUserServlet", value = "/update")
public class UpdateUserServlet extends HttpServlet {
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
        int currentID = Integer.parseInt(request.getParameter("id"));
        MyUser user = users.get(currentID);
        request.setAttribute("user", user);

        request.getRequestDispatcher("update.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int currentID = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));

        MyUser user = users.get(currentID);
        user.setName(name);
        user.setAge(age);

        response.sendRedirect("/users");
    }
}
