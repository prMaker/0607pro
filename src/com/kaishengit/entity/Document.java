package com.kaishengit.entity;

/**
 * Created by Administrator on 2016/6/16.
 */
public class Document {

    private Integer id;
    private String fileName;
    private String saveName;
    private String extName;
    private Long size;
    private String displaySize;
    private String md5;

    @Override
    public String toString() {
        return "Document{" +
                "id=" + id +
                ", fileName='" + fileName + '\'' +
                ", saveName='" + saveName + '\'' +
                ", extName='" + extName + '\'' +
                ", size=" + size +
                ", displaySize='" + displaySize + '\'' +
                ", md5='" + md5 + '\'' +
                '}';
    }

    public boolean isPreview(){

        if(getFileName().endsWith(".gif")||getFileName().endsWith(".png")
                ||getFileName().endsWith(".jpg")
                ||getFileName().endsWith(".jpeg")
                ||getFileName().endsWith(".pdf")
                ||getFileName().endsWith(".pdf")
                ||getFileName().endsWith(".bmf")){
            return true;
        }
        return false;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getSaveName() {
        return saveName;
    }

    public void setSaveName(String saveName) {
        this.saveName = saveName;
    }

    public String getExtName() {
        return extName;
    }

    public void setExtName(String extName) {
        this.extName = extName;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public String getDisplaySize() {
        return displaySize;
    }

    public void setDisplaySize(String displaySize) {
        this.displaySize = displaySize;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }
}
