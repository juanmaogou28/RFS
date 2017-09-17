package com.rfid.rfs.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.List;

/**
 * 项目名称：RFS
 * 类描述：
 * 创建人：lenovo
 * 创建时间：2017-09-16 10:18
 * 修改人：lenovo
 * 修改时间：2017-09-16 10:18
 * 修改备注：
 */
public class JsonUtils
{
    /**
     * 此类不需要实例化
     */
    private JsonUtils() {
    }

    /**
     * 把Object转化为json字符串
     *
     * @param obj
     * @return json
     */
    public static String getJsonForObject(Object obj) {
        return JSON.toJSONString(obj);
    }

    /**
     * 将list转化为json字符串
     * @param list
     * @return
     */
    public static String listObjectToJson(List<Object> list)
    {
        return JSONArray.toJSONString(list);
    }
    /**
     * 从json字符串里面根据key获取value
     *
     * @param json
     * @param key
     * @return
     */
    public static String getStringForJson(String json, String key) {
        return JSONObject.parseObject(json).getString(key);
    }

    /**
     * json转object
     */
    public static <T> T jsonToObject(String jsonString, Class<T> pojoCalss) {
        return JSONObject.parseObject(jsonString, pojoCalss);
    }

    /**
     * json转 List
     */
    public static <T> List<T> jsonToListObject(JSONArray jsonArray, Class<T> pojoCalss) {
        return JSONArray.parseArray(jsonArray.toString(), pojoCalss);
    }

}
