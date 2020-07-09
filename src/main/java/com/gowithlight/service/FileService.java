package com.gowithlight.service;

import com.gowithlight.entity.FileInfo;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.List;

/**
 * @Auther: Elton Ge
 * @Date: 9/7/20
 * @Description: com.gowithlight.service
 * @version: 1.0
 */
public interface FileService {

    boolean upload(MultipartFile file);

    List<FileInfo> findAll();

    InputStream getFile(Long fileInfoId);

    FileInfo getFileInfoById(Long fileInfoId) ;
}
