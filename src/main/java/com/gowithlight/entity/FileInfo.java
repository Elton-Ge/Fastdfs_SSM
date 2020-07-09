package com.gowithlight.entity;

import java.io.Serializable;
import java.util.Objects;

/**
 * @Auther: Elton Ge
 * @Date: 9/7/20
 * @Description: com.gowithlight.entity
 * @version: 1.0
 */
public class FileInfo implements Serializable {
    private  long id;
    private    String fileName;
    private  String groupName;
    private  String remoteFileName;
    private String filePath;

    public FileInfo() {
    }

    public FileInfo(long id, String fileName, String groupName, String remoteFileName, String filePath) {
        this.id = id;
        this.fileName = fileName;
        this.groupName = groupName;
        this.remoteFileName = remoteFileName;
        this.filePath = filePath;
    }

    @Override
    public boolean equals(Object o) { 
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FileInfo fileInfo = (FileInfo) o;
        return id == fileInfo.id &&
                Objects.equals(fileName, fileInfo.fileName) &&
                Objects.equals(groupName, fileInfo.groupName) &&
                Objects.equals(remoteFileName, fileInfo.remoteFileName) &&
                Objects.equals(filePath, fileInfo.filePath);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fileName, groupName, remoteFileName, filePath);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getRemoteFileName() {
        return remoteFileName;
    }

    public void setRemoteFileName(String remoteFileName) {
        this.remoteFileName = remoteFileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
