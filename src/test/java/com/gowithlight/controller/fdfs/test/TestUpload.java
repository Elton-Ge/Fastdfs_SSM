package com.gowithlight.controller.fdfs.test;

import org.csource.common.MyException;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.StorageClient;

import java.io.IOException;

/**
 * @Auther: Elton Ge
 * @Date: 9/7/20
 * @Description: com.gowithlight.fdfs.test
 * @version: 1.0
 */
public class TestUpload {
    public static void main(String[] args) {
        //获取storageclient
        StorageClient storageClient=FastDFSUtils.getStorageClient();
        //准备上传信息
         String local_filename="uploadFiles/2.png";
         String file_ext_name="png";
        NameValuePair[] meta_list=new NameValuePair []{
                new NameValuePair("filename","2.png"),
                new NameValuePair("uploadUser","gowithlight")
        };
        //上传文件到fastfds
        String[] strings=null;
        try {
            strings = storageClient.upload_file(local_filename, file_ext_name, meta_list);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (MyException e) {
            e.printStackTrace();
        }
        //解析上传到结果
        System.out.println(strings.length);
        System.out.println(strings[0]);
        System.out.println(strings[1]);
    }

}
