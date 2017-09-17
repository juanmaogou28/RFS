package com.rfid.rfs.model;

import android.content.Context;

import com.rfid.rfs.model.dao.RfsSystemUserDao;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 项目名称：RFS
 * 类描述：数据模型层全局类
 * 创建人：lenovo
 * 创建时间：2017-09-15 19:10
 * 修改人：lenovo
 * 修改时间：2017-09-15 19:10
 * 修改备注：
 */
public class Model
{
    //定义上下文
    private  Context mContext;
    //定义线程池
    private ExecutorService executorService = Executors.newCachedThreadPool();
    //创建对象
    private static Model model = new Model();
    private RfsSystemUserDao systemUserDao;
    //私有化构造器
    private Model()
    {
    }

    //获取单例对象
    public static Model getInstantent()
    {
        return model;
    }

    //初始化方法
    public void init(Context context)
    {
        mContext = context;

        //创建用户操作类的对象
        systemUserDao = new RfsSystemUserDao(mContext);
    }
    //获取全局线程变量
    public ExecutorService getGlobalThreadPool()
    {
        return executorService;
    }
    //登录成功后的处理方法
    public void loginSuccess()
    {
    }
    //用于获取用户账号数据库的操作类对象
    public RfsSystemUserDao getRfsSystemUserDao()
    {
        return systemUserDao;
    }
}
