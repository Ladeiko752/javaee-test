package com.example.javaeetest.parameters;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Good day, ";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        /*позволяет установить тип ответа, в данном случае это html-код*/
        response.setContentType("text/html");

        String name = request.getParameter("name");
        String surname = request.getParameter("surname");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + name + " " + surname + "</h1>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}