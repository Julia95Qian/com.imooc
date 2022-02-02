package com.imooc.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/index")
public class IndexServlet extends HttpServlet{
    public IndexServlet() {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        Integer sum = (Integer) req.getAttribute("sum");
        Integer n = (Integer) req.getAttribute("number");
        resp.getWriter().println("<h1>" + n + "以内的累加和：" + sum + "</h1>");
    }
}
