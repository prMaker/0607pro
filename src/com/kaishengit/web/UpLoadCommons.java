package com.kaishengit.web;

import com.kaishengit.entity.Document;
import com.kaishengit.service.DocumentService;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by Administrator on 2016/6/16.
 */

public class UpLoadCommons extends HttpServlet {

    Logger logger = LoggerFactory.getLogger(UpLoadCommons.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/upload.jsp").forward(req, resp);
    }



    //    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        if (ServletFileUpload.isMultipartContent(req)) {
//
//            DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
//            File repository = (File) req.getServletContext().getAttribute("javax.servlet.context.tempdir");
//            diskFileItemFactory.setRepository(repository);
//            diskFileItemFactory.setSizeThreshold(1024 * 8);
//
//            ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
//            try {
//                List<FileItem> fileItemList = servletFileUpload.parseRequest(req);
//                DocumentService documentService = new DocumentService();
//                for (FileItem fileItem : fileItemList) {
//                    if (fileItem.isFormField()) {
//                        String desc = fileItem.getFieldName();
//                        if ("desc".equals(desc)) {
//                            String descValue = fileItem.getString("Utf-8");
//                            logger.debug("{}->{}", desc, descValue);
//                        }
//                    } else {
//
//                        String contentType = fileItem.getContentType();
//                        Long size = fileItem.getSize();
//                        String fileName = fileItem.getName();
//                        InputStream inputStream = fileItem.getInputStream();
//
//                        documentService.documentService(fileName, inputStream, size);
//                    }
//                }
//            } catch (FileUploadException e) {
//                e.printStackTrace();
//            }
//        }
//    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(ServletFileUpload.isMultipartContent(req)){

            File repository = (File) req.getServletContext().getAttribute("javax.servlet.comtext.tempdir");
            DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
            diskFileItemFactory.setRepository(repository);
            diskFileItemFactory.setSizeThreshold(1024*8);

            DocumentService documentService = new DocumentService();
            ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
            try {
                List<FileItem> fileItemList = servletFileUpload.parseRequest(req);
                for(FileItem fileItem : fileItemList){
                    if(fileItem.isFormField()){
                        String fieldName = fileItem.getFieldName();
                        if("desc".equals(fieldName)){
                            String fieldValue = fileItem.getString("UTF-8");
                            logger.debug("{}->{}",fieldName,fieldValue);
                        }
                    }else{
                        String ContestType = fileItem.getContentType();
                        String name = fileItem.getName();
                        Long size = fileItem.getSize();
                        InputStream inputStream = fileItem.getInputStream();

                        documentService.documentService(name,inputStream,size);
                    }
                }
            } catch (FileUploadException e) {
                e.printStackTrace();
            }

        }
    }
}
