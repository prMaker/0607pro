package com.kaishengit.dao;

import com.kaishengit.dbutils.DbHelp;
import com.kaishengit.entity.Document;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.util.List;

/**
 * Created by Administrator on 2016/6/16.
 */
public class DocumentDao {

    public void save(Document document) {
        String sql = "INSERT INTO t_document(filename, savename, extname, size, displaysize, md5) VALUES (?,?,?,?,?,?);";
        DbHelp.updateUser(sql, document.getFileName(), document.getSaveName(), document.getExtName(), document.getSize(), document.getDisplaySize(), document.getMd5());
    }

    public Document queryByMd5(String md5) {
        String sql = "SELECT * FROM t_document WHERE md5 = ?";
        return DbHelp.queryUser(sql,new BeanHandler<>(Document.class),md5);
    }

    public List<Document> queryAll() {

        String sql = "SELECT * FROM t_document ORDER BY id DESC ";
        return DbHelp.queryUser(sql,new BeanListHandler<>(Document.class));

    }
}
