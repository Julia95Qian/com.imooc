package com.imooc.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/sd")
public class RedirectServlet extends HttpServlet{
    public RedirectServlet() {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String addNumber = req.getParameter("addNumber");
        int n = Integer.parseInt(addNumber);
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        req.setAttribute("sum", sum);
        req.setAttribute("number", n);
        req.getRequestDispatcher("/index").forward(req,resp);
    }
}
