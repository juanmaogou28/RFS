package com.rfid.rfs;

import android.app.Application;
import android.content.Context;

import com.rfid.rfs.model.Model;

/**
 * 项目名称：RFS
 * 类描述：
 * 创建人：lenovo
 * 创建时间：2017-09-15 19:21
 * 修改人：lenovo
 * 修改时间：2017-09-15 19:21
 * 修改备注：
 */
public class RfsApplication extends Application
{
    private static Context mContext;

    @Override
    public void onCreate()
    {
        System.out.println("RfsApplication--onCreate");
        super.onCreate();

        //初始化数据模型层
        Model.getInstantent().init(this);

        //初始化全局上下文对象
        mContext = this;
    }

    public static Context getGlobalApplication()
    {
        return mContext;
    }
}
