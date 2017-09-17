package com.rfid.rfs.controller.fragment;

import android.graphics.Color;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.rfid.rfs.controller.fragment.base.BaseFragement;


/**
 * 项目名称：RFS
 * 类描述：计划单
 * 创建人：lenovo
 * 创建时间：2017-09-17 4:37
 * 修改人：lenovo
 * 修改时间：2017-09-17 4:37
 * 修改备注：
 */
public class PlanFragement extends BaseFragement
{
    private static final String TAG = PlanFragement.class.getSimpleName(); //PlanFragement
    private TextView textView;
    @Override
    protected View initView()
    {
        Log.e(TAG, "任务单页面被初始化了。。。。");
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
        Log.e(TAG, "任务单页面数据被初始化了。。。。");
        textView.setText("任务单文本");
    }
}
