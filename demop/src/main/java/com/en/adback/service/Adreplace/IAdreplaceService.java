package com.en.adback.service.Adreplace;

import com.en.adback.entity.adreplace.AdReplaceInParams;
import com.en.adback.entity.adreplace.ResponseModel;
import org.springframework.scheduling.annotation.Async;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface IAdreplaceService {
    /*提供从本服务器下载功能*/
    public void downLoad(String fileName, HttpServletResponse response) throws IOException;

    /*从本服务器上传到市州服务器*/
    public ResponseModel upLoad(String targetUrl, String fileName, Boolean isAsync);

    @Async
    public void upLoadAsync(String targetUrl, String fileName, Boolean isAsync);

    /*从本服务器下发文件名，市州服务器自主从本服务器下载*/
    public  ResponseModel dispatch(String targetUrl, String fileName, Boolean isAsync);

    @Async
    public  void dispatchAsync(String targetUrl, String fileName, Boolean isAsync);

    /*市州服务器上传或下载结果报告*/
    void asyncCallback(String callbackJson);

    /*广告替换操作*/
    public void advertReplace(AdReplaceInParams adReplaceInParams);
}
