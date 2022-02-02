package com.imooc.servlet;

import com.alibaba.fastjson.JSON;
import com.imooc.entity.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/ajax/emp")
public class EmployeeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List list = new ArrayList<String>();
        String flag = req.getParameter("flag");
        if(flag.equals("emp")){
            list.add("e1");
            list.add("e2");
            list.add("e3");
        } else if(flag.equals("post")){
            list.add("manager");
            list.add("engineer");
        } else if(flag.equals("depar")){
            list.add("hr");
            list.add("development");
            list.add("product");
        }
        String json = JSON.toJSONString(list);
        resp.setContentType("text/html;charset=UTF-8");
        resp.getWriter().println(json);
    }
}
