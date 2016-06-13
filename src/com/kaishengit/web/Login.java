package com.kaishengit.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Administrator on 2016/6/13.
 */
@WebServlet("/login")
public class Login extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        String captcha = req.getParameter("captcha");

        String sessionCaptcha = (String) req.getSession().getAttribute("captcha");
        if(captcha!=null&&captcha.equals(sessionCaptcha)){
            resp.sendRedirect("/WEB-INF/viess/paysuc.jsp");
        }else{
            resp.sendRedirect("/login?error=1001");
        }

    }
}
