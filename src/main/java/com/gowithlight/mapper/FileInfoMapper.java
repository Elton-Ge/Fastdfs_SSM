package com.gowithlight.mapper;

import com.gowithlight.entity.FileInfo;

import java.util.List;

/**
 * @Auther: Elton Ge
 * @Date: 9/7/20
 * @Description: com.gowithlight.mapper
 * @version: 1.0
 */
public interface FileInfoMapper {
    void insertFileInfo(FileInfo fileInfo);

    List<FileInfo> selectAll();

     FileInfo  selectById (Long id);
}
