package com.gowithlight.controller.fdfs.test;

import org.csource.common.MyException;
import org.csource.fastdfs.StorageClient;

import java.io.IOException;

/**
 * @Auther: Elton Ge
 * @Date: 9/7/20
 * @Description: com.gowithlight.fdfs.test
 * @version: 1.0
 */
public class TestDelete {
    public static void main(String[] args) {
        //获取storageclient对象
        StorageClient storageClient=FastDFSUtils.getStorageClient();
        //获取下载信息
        String group_name="group1";
        String remote_filename="M00/00/00/wKhABV8GjxmAAeQsAC1j9jw6KMY449.png";

        int flag=0;
        try {
             flag = storageClient.delete_file(group_name, remote_filename);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (MyException e) {
            e.printStackTrace();
        }

        System.out.println("删除成功"+flag);
    }
}
