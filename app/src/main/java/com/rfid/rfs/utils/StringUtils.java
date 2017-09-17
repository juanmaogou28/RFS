package com.rfid.rfs.utils;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * 项目名称：RFS
 * 类描述：字符串工具类
 * 创建人：lenovo
 * 创建时间：2017-09-16 9:59
 * 修改人：lenovo
 * 修改时间：2017-09-16 9:59
 * 修改备注：
 */
public class StringUtils
{
    /**
     * 函数功能说明 ： 获取去掉横线的长度为32的UUID串<br/>
     */
    public static String get32UUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    /**
     * 函数功能说明 ： 获取带横线的长度为36的UUID串<br/>
     */
    public static String get36UUID() {
        return UUID.randomUUID().toString();
    }
    /**
     * 函数功能说明 ：  判断字符串是否为空 <br/>
     */
    public static boolean isEmpty(String str) {
        return null == str || "".equals(str);
    }

    /**
     * 函数功能说明 ：  判断对象数组是否为空<br/>
     */
    public static boolean isEmpty(Object[] obj) {
        return null == obj || 0 == obj.length;
    }

    /**
     * 函数功能说明 ：判断对象是否为空 <br/>
     */
    public static boolean isEmpty(Object obj) {
        if (null == obj) {
            return true;
        }
        if (obj instanceof String) {
            return ((String) obj).trim().isEmpty();
        }
        return !(obj instanceof Number) ? false : false;
    }

    /**
     * 函数功能说明 ： 判断集合是否为空<br/>
     */
    public static boolean isEmpty(List<?> obj) {
        return null == obj || obj.isEmpty();
    }

    /**
     * 函数功能说明 ： 判断Map集合是否为空 <br/>
     */
    public static boolean isEmpty(Map<?, ?> obj) {
        return null == obj || obj.isEmpty();
    }

    /**
     * 函数功能说明 ：获得文件名的后缀名 <br/>
     */
    public static String getExt(String fileName) {
        return fileName.substring(fileName.lastIndexOf(".") + 1);
    }
    /**
     * 函数功能说明 ： 计算采用utf-8编码方式时字符串所占字节数<br/>
     */
    public static int getByteSize(String content) {
        int size = 0;
        if (null != content) {
            try {
                // 汉字采用utf-8编码时占3个字节
                size = content.getBytes("utf-8").length;
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return size;
    }

    /**
     * 函数功能说明 ： 截取字符串拼接in查询参数<br/>
     */
    public static String getInParam(String param) {
        String inParem="";
        if(!StringUtils.isEmpty(param)){
            boolean flag = param.contains(",");
            if (flag) {
                List<String> list = Arrays.asList(param.split(","));
                for(int i=0;i<list.size();i++){
                    inParem=inParem+"'"+list.get(i)+"',";
                }
                inParem=inParem.substring(0, inParem.length()-1);
            } else {
                inParem=inParem+"'"+param+"'";
            }
        }
        return inParem.trim();
    }

}
