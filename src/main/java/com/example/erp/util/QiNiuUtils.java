package com.example.erp.util;

import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;

import java.io.FileInputStream;
import java.util.UUID;
/**
 * @author qzp
 * @date 2020/5/11
 */
public class QiNiuUtils {
    public  static String qiniu_img_url_pre = "http://qa64j9eti.bkt.clouddn.com/";
    public  static String accessKey = "7GP1nUxPD5O1SlkX5tILO1c5D0ICKdSB5MygqPWZ";
    public  static String secretKey = "x2YNeUH6_eQv4fZ9UG7waacAOWG9zywZ74iUxpP_";
    public  static String bucket = "face-url";

    /**
     * 上传文件
     * @param bytes 文件内容，字节数组
     * @param uploadFileName 保存到服务端的文件名
     */
    public static void upload2QiNiu(byte[] bytes, String uploadFileName){
        //构造一个带指定Zone对象的配置类,Zone.zone0()代表华东地区
        Configuration cfg = new Configuration(Zone.zone0());
        //...其他参数参考类注释
        UploadManager uploadManager = new UploadManager(cfg);

        //默认不指定key的情况下，以文件内容的hash值作为文件名
        Auth auth = Auth.create(accessKey, secretKey);
        String upToken = auth.uploadToken(bucket);
        try {
            Response response = uploadManager.put(bytes, uploadFileName, upToken);
            //解析上传成功的结果
            System.out.println(response.bodyString());
            // 访问路径
            System.out.println(qiniu_img_url_pre+uploadFileName);
        } catch (QiniuException ex) {
            Response r = ex.response;
            System.err.println(r.toString());
            try {
                System.err.println(r.bodyString());
            } catch (QiniuException ex2) {
                //ignore
                ex.printStackTrace();
            }
        }
    }

    public static void deletePic(String fileName){
        try {
            Auth auth = Auth.create(accessKey, secretKey);
            Configuration configuration = new Configuration(Zone.zone0());
            BucketManager bucketManager = new BucketManager(auth, configuration);
            bucketManager.delete(bucket,fileName);
        } catch (QiniuException e) {
            e.printStackTrace();
        }
    }

    // 测试上传
    public static void main(String[] args) throws Exception{
        // 测试上传
        String localFilePath = "C:\\Users\\Administrator\\Documents\\Pictures\\Camera Roll\\38185259.jpg";
        FileInputStream fileInputStream = new FileInputStream(localFilePath);
        byte[] data = new byte[1024*1024];
        fileInputStream.read(data);
        String saveFileName = UUID.randomUUID().toString().replace("-","");
        QiNiuUtils.upload2QiNiu(data,saveFileName);
    }
}
