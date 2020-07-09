package com.gowithlight.controller.fdfs.test;

import org.apache.commons.io.IOUtils;
import org.csource.common.MyException;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.StorageClient;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Auther: Elton Ge
 * @Date: 9/7/20
 * @Description: com.gowithlight.fdfs.test
 * @version: 1.0
 */
public class TestDownload {
    public static void main(String[] args) {
        //获取storageclient对象
        StorageClient storageClient=FastDFSUtils.getStorageClient();
        //获取下载信息
        String group_name="group1";
        String remote_filename="M00/00/00/wKhABV8GjxmAAeQsAC1j9jw6KMY449.png";
        //下载文件
        byte[] bytes=null;
        String filename=null;
        try {
            bytes = storageClient.download_file(group_name, remote_filename);
            NameValuePair[]  metadata = storageClient.get_metadata(group_name, remote_filename);
            for (NameValuePair nvp : metadata) {
                if (nvp.getName().equals("filename")){
                    filename = nvp.getValue();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (MyException e) {
            e.printStackTrace();
        }


        //处理下载结果
        try {
            IOUtils.write(bytes,new FileOutputStream("downloadFiles/"+filename));
            System.out.println("下载成功"+filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
