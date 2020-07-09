package com.gowithlight.controller.fdfs.test;

import org.csource.common.MyException;
import org.csource.fastdfs.*;

import java.io.IOException;

/**
 * @Auther: Elton Ge
 * @Date: 9/7/20
 * @Description: com.gowithlight.fdfs.test
 * @version: 1.0
 */
public class TestConnection {
    public static void main(String[] args) {

        try {
            ClientGlobal.init("src/main/resources/fdfs/fdfs.conf");
            TrackerClient trackerClient=new TrackerClient();
            TrackerServer trackerServer=trackerClient.getConnection();
            StorageServer storageServer=trackerClient.getStoreStorage(trackerServer);
            StorageClient storageClient=new StorageClient(trackerServer,storageServer);

            System.out.println("trackerClient = " + trackerClient);
            System.out.println("trackerServer = " + trackerServer);
            System.out.println("storageServer = " + storageServer);
            System.out.println("storageClient = " + storageClient);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (MyException e) {
            e.printStackTrace();
        }
    }
}
