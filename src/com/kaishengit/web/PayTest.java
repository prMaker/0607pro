package com.kaishengit.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.UUID;

/**
 * Created by Administrator on 2016/6/13.
 */
@WebServlet("/pay")
public class PayTest extends HttpServlet{

    Logger logger = LoggerFactory.getLogger(PayTest.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String token = UUID.randomUUID().toString();

        HttpSession session = req.getSession();
        session.setAttribute("token",token);
        req.setAttribute("token",token);

        req.getRequestDispatcher("/WEB-INF/views/pay.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String token =  req.getParameter("token");
        String sessionToken = (String) req.getSession().getAttribute("token");
        logger.debug("sessionToken:{}",sessionToken);
        if(token!=null&&token.equals(sessionToken)){
            req.getSession().removeAttribute("token");
            req.getRequestDispatcher("/WEB-INF/views/paysuc.jsp").forward(req,resp);
        }else{
            resp.sendRedirect("/pay?error=10001");
        }
    }
}
