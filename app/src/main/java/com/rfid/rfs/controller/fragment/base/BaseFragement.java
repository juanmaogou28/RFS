package com.rfid.rfs.controller.fragment.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * 项目名称：RFS
 * 类描述：基类
 * 创建人：lenovo
 * 创建时间：2017-09-17 4:13
 * 修改人：lenovo
 * 修改时间：2017-09-17 4:13
 * 修改备注：
 */
public abstract class BaseFragement extends Fragment
{
    protected Context mContext;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        //得到上下文
        mContext = getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        return initView();
    }

    /**
     * 强制子类重写，实现子类特有的ui
     * @return
     */
    protected abstract  View initView();

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);

        //初始化数据
        initData();
    }

    /**
     * 初始化数据：当子类需要初始化数据或需要联网绑定数据或展示数据等
     */
    protected void initData()
    {

    }
}
