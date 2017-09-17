package com.rfid.rfs.utils;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * 项目名称：RFS
 * 类描述：日期工具类
 * 创建人：lenovo
 * 创建时间：2017-09-16 10:13
 * 修改人：lenovo
 * 修改时间：2017-09-16 10:13
 * 修改备注：
 */
public class DateUtils
{
    /**
     * 函数功能说明 ： 时间date转string<br/>
     * 修改者名字： <br/>
     * 修改日期： <br/>
     * 修改内容：<br/>
     * 作者：roncoo-lrx <br/>
     * 参数：@param dateTime
     * 参数：@return <br/>
     * return：String <br/>
     */
    public static String dateFormatString(Date dateTime) {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return formatter.format(dateTime);
    }
}
