package com.example.javaeetest.json;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "JsonHandlerServlet", value = "/json")
public class JsonHandlerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = new User(1, "Anton", 20);
        String json = new ObjectMapper().writeValueAsString(user);
        response.getWriter().write(json);
    }
}
