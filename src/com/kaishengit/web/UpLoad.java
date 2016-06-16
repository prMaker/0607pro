package com.kaishengit.web;

import com.kaishengit.service.DocumentService;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;
import java.util.UUID;

/**
 * Created by Administrator on 2016/6/16.
 */
@WebServlet("/upload")
@MultipartConfig
public class UpLoad extends HttpServlet {

    private Logger logger = LoggerFactory.getLogger(UpLoad.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/upload.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String desc = req.getParameter("desc");
        Part part = req.getPart("doc");

        Long size = part.getSize();
        String contentType = part.getContentType();
        InputStream inputStream = part.getInputStream();
        String fileName = getFileName(part);
        logger.debug("contentType:{}", contentType);

        DocumentService documentService = new DocumentService();
        documentService.documentService(fileName,inputStream,size);
    }

    public void saveIOUtil(Part part, String fileName) throws IOException {
        File dir = new File("D:/fileDemo");
        if (!dir.exists()) {
            dir.mkdir();
        }

        String extName = fileName.substring(fileName.lastIndexOf("."));
        fileName = UUID.randomUUID().toString()+extName;
        InputStream inputStream = part.getInputStream();
        FileOutputStream fileOutputStream = new FileOutputStream(new File(dir, fileName));

        IOUtils.copy(inputStream, fileOutputStream);
        inputStream.close();
        fileOutputStream.close();
    }

    /**
     * 没有使用commons进行IO
     *
     * @param part
     * @param fileName
     * @throws IOException
     */
    public void saveIO(Part part, String fileName) throws IOException {

        File dir = new File("D:/fileDemo");
        if (!dir.exists()) {
            dir.mkdir();
        }

        String extName = fileName.substring(fileName.lastIndexOf("."));
        fileName = UUID.randomUUID().toString();
        fileName = fileName + extName;

        InputStream inputStream = part.getInputStream();
        FileOutputStream fileOutputStream = new FileOutputStream(new File(dir, fileName));

        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);

        byte[] bytes = new byte[1024 * 8];
        int length = -1;
        while ((length = bufferedInputStream.read(bytes)) != -1) {
            bufferedOutputStream.write(bytes, 0, length);
        }
        bufferedOutputStream.flush();
        bufferedOutputStream.close();
        bufferedInputStream.close();
        fileOutputStream.flush();
        fileOutputStream.close();
        inputStream.close();


    }

    public String getFileName(Part part) {

        String fileName = part.getHeader("Content-Disposition");
        fileName = fileName.substring(fileName.indexOf("filename=\""));
        fileName = fileName.substring(fileName.indexOf("\"") + 1, fileName.length() - 1);
        logger.debug("文件名：{}", fileName);
        return fileName;
    }
}
