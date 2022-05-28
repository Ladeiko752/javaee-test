package com.example.javaeetest.crud;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "AddUserServlet", value = "/add_user")
public class AddUserServlet extends HttpServlet {
    private Map<Integer, MyUser> users;
    private Integer id;

    @Override
    public void init() throws ServletException {
        Object users = getServletContext().getAttribute("users");

        if (users == null || !(users instanceof HashMap)){
            throw new IllegalStateException("Cuckold error");
        }else {
            this.users = (Map<Integer, MyUser>) users;
        }
        id = new Integer(1);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));

        MyUser myUser = new MyUser(id, name, age);
        users.put(id++, myUser);
        response.sendRedirect("/users");
    }
}
