package com.ziabo.ziabo.readmvc.utils;

import android.util.Log;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by ziabo on 2016/12/9.
 * 本类需要在异步里面做处理
 */

public class HttpUtils {
    private static OkHttpClient mClient = new OkHttpClient();
    public static InputStream getDataByGet(String url) {
        Request request = new Request.Builder()
                .url(url)
                .build();
        Response response = null;
        try {
            response = mClient.newCall(request).execute();
            if (response.isSuccessful()){
                return response.body().byteStream();
            } else {
            Log.d("OKHttp", "getDataByGet: okHttp is request error");
        }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String postImgToService(File file){
        RequestBody fileBody = RequestBody.create(MediaType.parse("image/png"),file);
        RequestBody requestBody = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("inputFile",file.getName(),fileBody)
                .build();
        Request request = new Request.Builder()
                .url("http://192.168.1.123:3000/upload")
                .addHeader("enctype","multipart/form-data")
                .addHeader("ContentType","application/json;charset=utf-8")
                .post(requestBody)
                .build();
        Response response;
        try {
            response = mClient.newCall(request).execute();
            if (response.isSuccessful()){
                Log.d("HttpUtils", "链接成功了!!!");
            }else {
                Log.d("HttpUtils", "连接失败了!!!");
            }
            return response.body().string();
        } catch (IOException e) {
            Log.d("HttpUtils", "postImgToService:"+e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
}
