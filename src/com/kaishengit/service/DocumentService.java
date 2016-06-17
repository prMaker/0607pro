package com.kaishengit.service;

import com.kaishengit.dao.DocumentDao;
import com.kaishengit.dao.UserDao;
import com.kaishengit.dbutils.ByteCountToDisplaySize;
import com.kaishengit.entity.Document;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.IOUtils;

import java.io.*;
import java.util.List;
import java.util.UUID;

/**
 * Created by Administrator on 2016/6/16.
 */
public class DocumentService {

    public void documentService(String fileName, InputStream inputStream, Long size) throws IOException {

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(IOUtils.toByteArray(inputStream));

        String md5 = DigestUtils.md5Hex(byteArrayInputStream);
        DocumentDao documentDao = new DocumentDao();
        if (documentDao.queryByMd5(md5) == null) {
            String saveName = saveIOUtil(byteArrayInputStream,fileName);

            Document document = new Document();
            document.setDisplaySize(ByteCountToDisplaySize.byteCountToDisplaySize(size));
            document.setExtName(fileName.substring(fileName.lastIndexOf(".")));
            document.setFileName(fileName);
            document.setMd5(md5);
            document.setSaveName(saveName);
            document.setSize(size);

            documentDao.save(document);
        }
    }

    public String saveIOUtil(ByteArrayInputStream byteArrayInputStream,String fileName) throws IOException {
        byteArrayInputStream.reset();

        File dir = new File("D:/fileDemo");
        if (!dir.exists()) {
            dir.mkdir();
        }

        String extName = fileName.substring(fileName.lastIndexOf("."));
        fileName = UUID.randomUUID().toString()+extName;

        FileOutputStream fileOutputStream = new FileOutputStream(new File(dir, fileName));

        IOUtils.copy(byteArrayInputStream, fileOutputStream);
        byteArrayInputStream.close();
        fileOutputStream.close();
        return fileName;
    }


    DocumentDao documentDao = new DocumentDao();
    public List<Document> getDocumentAll() {
        return documentDao.queryAll();

    }

    public Document getDocumentByMd5(String md5) {

        return documentDao.queryByMd5(md5);

    }
}
