package com.kaishengit.web;

import com.kaishengit.entity.Document;
import com.kaishengit.service.DocumentService;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by Administrator on 2016/6/16.
 */
@WebServlet("/preview")
public class Preview extends HttpServlet {

    Logger logger = LoggerFactory.getLogger(Preview.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String md5 = req.getParameter("md5");
        String flag = req.getParameter("down");
        DocumentService documentService = new DocumentService();
        Document document = documentService.getDocumentByMd5(md5);

        logger.debug("document:{}", document);
        FileInputStream fileInputStream = new FileInputStream(new File("D:/fileDemo", document.getSaveName()));
        OutputStream outputStream = resp.getOutputStream();

        if ("true".equals(flag)) {
            resp.setContentType("application/octet-stream");

            // intValue

            // 遇见可能是汉字的随时getBytes("UTF-8")
            resp.setContentLength(document.getSize().intValue());
            String fileName =new String(document.getFileName().getBytes("UTF-8"));
            resp.setHeader("Content-Disposition","attachment;filename=\""+fileName+"\"");
        }
        IOUtils.copy(fileInputStream, outputStream);

        outputStream.flush();
        outputStream.close();
        fileInputStream.close();
    }
}
