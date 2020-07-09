package com.gowithlight.service.impl;

import com.gowithlight.entity.FileInfo;
import com.gowithlight.fdfs.FastDFSCommonUtils;
import com.gowithlight.mapper.FileInfoMapper;
import com.gowithlight.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

/**
 * @Auther: Elton Ge
 * @Date: 9/7/20
 * @Description: com.gowithlight.service.impl
 * @version: 1.0
 */
@Service
public class FileServiceImpl implements FileService {
    @Autowired
    private FileInfoMapper fileInfoMapper;
    @Override
    public boolean upload(MultipartFile file) {
        try {
            String[] strings = FastDFSCommonUtils.up(file.getInputStream(), file.getOriginalFilename());
            if (strings==null){
                return false;
            }
//            System.out.println(Arrays.toString(strings));
            FileInfo fileInfo=new FileInfo();
            fileInfo.setFileName(file.getOriginalFilename());
            fileInfo.setGroupName(strings[0]);
            fileInfo.setRemoteFileName(strings[1]);
            fileInfo.setFilePath(strings[0]+"/"+strings[1]);
            fileInfoMapper.insertFileInfo(fileInfo);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<FileInfo> findAll() {
        List<FileInfo> fileInfos = fileInfoMapper.selectAll();
        return fileInfos;
    }

    @Override
    public InputStream getFile(Long fileInfoId) {
        FileInfo fileInfo = fileInfoMapper.selectById(fileInfoId);

        InputStream inputStream = FastDFSCommonUtils.download(fileInfo.getGroupName(), fileInfo.getRemoteFileName());

        return inputStream;
    }

    @Override
    public FileInfo getFileInfoById(Long fileInfoId) {
        FileInfo fileInfo = fileInfoMapper.selectById(fileInfoId);

        return fileInfo;
    }
}
