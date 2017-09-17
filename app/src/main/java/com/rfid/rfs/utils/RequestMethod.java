package com.rfid.rfs.utils;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * 项目名称：RFS
 * 类描述：
 * 创建人：lenovo
 * 创建时间：2017-09-16 9:45
 * 修改人：lenovo
 * 修改时间：2017-09-16 9:45
 * 修改备注：
 */
public class RequestMethod
{
    public static OkHttpClient client = new OkHttpClient();
    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    /**
     * get请求
     *
     * @param url 网络连接
     * @return
     * @throws IOException
     */
    public static  String get(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }


    /**
     * okhttp3的post请求
     *
     * @param url
     * @param json
     * @return
     * @throws IOException
     */
    public static String post(String url, String json) throws IOException
    {
        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }
}
