package com.kaishengit.web;

import com.kaishengit.entity.Document;
import com.kaishengit.service.DocumentService;
import com.mysql.jdbc.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Administrator on 2016/6/16.
 */
@WebServlet("/download")
public class DownLoad extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        DocumentService documentService = new DocumentService();
        List<Document> documentList = documentService.getDocumentAll();
        req.setAttribute("documentList",documentList);
        req.getRequestDispatcher("/WEB-INF/views/download.jsp").forward(req,resp);

    }

}
