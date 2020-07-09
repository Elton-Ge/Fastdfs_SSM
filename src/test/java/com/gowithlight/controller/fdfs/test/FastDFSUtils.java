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
public class FastDFSUtils {
    private static final String configFile = "src/main/resources/fdfs/fdfs.conf";
    private static StorageClient storageClient;

    static {
        try {
            ClientGlobal.init(configFile);
            TrackerClient trackerClient=new TrackerClient();
            TrackerServer trackerServer=trackerClient.getConnection();
            StorageServer storageServer=trackerClient.getStoreStorage(trackerServer);
            storageClient=new StorageClient(trackerServer,storageServer);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (MyException e) {
            e.printStackTrace();
        }
    }

    public static StorageClient getStorageClient(){
        return storageClient;
    }

    /*public static void main(String[] args) {
        StorageClient storageClient=FastDFSUtils.getStorageClient();
        System.out.println("storageClient = " + storageClient);
    }*/
}
