package com.taotao;


import org.csource.fastdfs.*;
import org.junit.Test;
import utils.FastDFSClient;

public class FastDFSTest {
    @Test
    public void testUploadFile() throws Exception{
        //1.创建一个配置文件,用来连接trackerServer

        //2.加载配置文件
        ClientGlobal.init("E:\\java23\\Idea_java\\taotao_parent\\taotao_manager_web\\src\\main\\resources\\resource\\fastdfs.conf");

        //3.构建trackerclien对象
        TrackerClient trackerClient = new TrackerClient();

        //4.构建trakerserver对象
        TrackerServer trackerServer = trackerClient.getConnection();

        //5.构建storageServer

        StorageServer storageServer = null;

        //6.构建stoagerClient
        StorageClient storageClient = new StorageClient(trackerServer, storageServer);

        //7.使用stroageClient上传图片
        String[] strings = storageClient.upload_file("F:\\city.jpg", "jpg", null);
        for (String string : strings) {
            System.out.println(string);
        }
    }

    @Test
    public void testFastDfsClient() throws Exception{
        FastDFSClient fastDFSClient = new FastDFSClient("E:\\java23\\Idea_java\\taotao_parent\\taotao_manager_web\\src\\main\\resources\\resource\\fastdfs.conf");
        fastDFSClient.uploadFile("F:\\city.jpg", "jpg", null);
    }

}
