package com.taotao.controller;

import com.taotao.common.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import utils.FastDFSClient;

import java.util.HashMap;
import java.util.Map;

@Controller
public class UploadController {
    @Value("${TAOTAO_IMAGE_URL}")
    private String TAOTAO_IMAGE_URL;
    //当返回的数据的content-type如果是application/json的时候，google是可以的，但是火狐不支持，它支持的是content-type=text/plain;,produces = MediaType.TEXT_PLAIN_VALUE+";charset=utf-8"
    @RequestMapping(value = "/pic/upload",produces = MediaType.TEXT_PLAIN_VALUE+";charset=utf-8")
    @ResponseBody
    public String upload(MultipartFile uploadFile){
        //1.上传文件处理   //1.加入file-upload的jar包   pox.xml中 //2.配置文件解析   springmvc.xml
        //2.调用fastdfs提供的客户端,把流写入到对应的storage中
        try {
            //3.
            FastDFSClient fastDFSClient = new FastDFSClient("classpath:resource/fastdfs.conf");
            //4.上传图片
            //获取文件的后缀名
            String originalFilename = uploadFile.getOriginalFilename();
            //得到不带"."的后缀
            String extName = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
            String imagePath = fastDFSClient.uploadFile(uploadFile.getBytes(), extName);
            //拼接url 将完整的url 存入到数据库里面
            String complPath = TAOTAO_IMAGE_URL + imagePath;
            //返回jason给界面,成功和失败的两种jason格式
            //成功的格式
//            {
//                "error" : 0,
//                    "url" : "http://www.example.com/path/to/file.ext"
//            }
            Map<String,Object> map = new HashMap<>();
            map.put("error",0);
            map.put("url",complPath);
            return JsonUtils.objectToJson(map);
        } catch (Exception e) {
            //失败时
//            {
//                "error" : 1,
//                    "message" : "错误信息"
//            }
            e.printStackTrace();
            Map<String,Object> map = new HashMap<>();
            map.put("error",1);
            map.put("message","上传失败");
            return JsonUtils.objectToJson(map);
        }
    }

}
