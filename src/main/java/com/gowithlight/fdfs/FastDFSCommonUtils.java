package com.gowithlight.fdfs;

import org.csource.common.MyException;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @Auther: Elton Ge
 * @Date: 9/7/20
 * @Description: com.gowithlight.fdfs
 * @version: 1.0
 */
public class FastDFSCommonUtils {
    private static StorageClient storageClient;

    static {
        try {
            ClientGlobal.init(
                    Thread.currentThread().getContextClassLoader().getResource("").getPath()
                            +"fdfs/fdfs.conf");
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

    public  static  String[]  up(InputStream inputStream,String filename){
        try {
            NameValuePair [] metalist=new NameValuePair[]{
                    new NameValuePair("filename",filename)
            } ;
            String file_ext_name = filename.substring(filename.lastIndexOf(".") + 1);
            byte[] data=new byte[inputStream.available()];
            inputStream.read(data);
            String[] strings = storageClient.upload_file(data, file_ext_name, metalist);
            return strings;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } catch (MyException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static  InputStream download(String groupName, String remoteFileName){
        try {
            byte[] bytes = storageClient.download_file(groupName, remoteFileName);
            return new ByteArrayInputStream(bytes);
        } catch (IOException e) {
            e.printStackTrace();
            return null; 
        } catch (MyException e) {
            e.printStackTrace();
            return null;
        }


    }
}
