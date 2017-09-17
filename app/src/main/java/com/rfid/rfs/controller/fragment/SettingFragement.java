package com.rfid.rfs.controller.fragment;

import android.graphics.Color;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.rfid.rfs.controller.fragment.base.BaseFragement;


/**
 * 项目名称：RFS
 * 类描述：设置
 * 创建人：lenovo
 * 创建时间：2017-09-17 4:37
 * 修改人：lenovo
 * 修改时间：2017-09-17 4:37
 * 修改备注：
 */
public class SettingFragement extends BaseFragement
{
    private static final String TAG = SettingFragement.class.getSimpleName(); //SettingFragement
    private TextView textView;
    @Override
    protected View initView()
    {
        Log.e(TAG, "设置页面被初始化了。。。。");
        textView = new TextView(mContext);
        textView.setTextSize(20);
        textView.setGravity(Gravity.CENTER);
        textView.setTextColor(Color.RED);

        return textView;
    }

    @Override
    protected void initData()
    {
        super.initData();
        Log.e(TAG, "设置页面数据被初始化了。。。。");
        textView.setText("设置文本");
    }
}
