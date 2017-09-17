package com.rfid.rfs.controller.activity;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.widget.RadioGroup;

import com.rfid.rfs.R;
import com.rfid.rfs.controller.fragment.InventoryFragement;
import com.rfid.rfs.controller.fragment.PlanFragement;
import com.rfid.rfs.controller.fragment.SettingFragement;
import com.rfid.rfs.controller.fragment.base.BaseFragement;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity
{
    private RadioGroup rg_main;
    private List<BaseFragement> mBaseFragement;
    private int position;       //选中radioButtom位置
    private Fragment mContent;  //上次切换的fragment

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //初始化页面控件
        this.initView();

        //初始化fragement
        initFragement();

        //设置radioButtom的监听事件
        initRadioButtomListener();
    }

    /**
     * 设置radioButtom的监听事件
     */
    private void initRadioButtomListener()
    {
        rg_main.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId)
            {
                switch (checkedId)
                {
                    case R.id.rb_inventory_plan:
                        //任务单
                        position = 0;
                        break;
                    case R.id.rb_inventory_operator:
                        //盘点
                        position = 1;
                        break;
                    case R.id.rb_parameter_setting:
                        //设置
                        position = 2;
                        break;
                    default:
                        position = 0;
                        break;
                }

                //根据位置得到相应的fragement
                BaseFragement to = getFragement();

                //替换到布局
                switchFragment(mContent, to);
            }
        });

        //默认选中第一个radioButton即任务单
        rg_main.check(R.id.rb_inventory_plan);
    }

    /**
     *
     * @param from 刚显示的fragment马上就要被隐藏了
     * @param to 马上要切换到的fragment一会要显示
     */
    private void switchFragment(Fragment from, Fragment to)
    {
        //切换前提条件
        if (from != to)
        {
            mContent = to;
            //开启事务
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            //才切换
            //判断有没有被添加
            if(!to.isAdded())
            {
                //没有被添加
                //from隐藏
                if (from != null)
                {
                    transaction.hide(from);
                }
                //to添加
                if(to != null)
                {
                    transaction.add(R.id.fl_content, to).commit();
                }
            }
            else
            {
                //已经被添加
                //from隐藏
                if (from != null)
                {
                    transaction.hide(from);
                }
                //to显示
                if (to != null)
                {
                    transaction.show(to).commit();
                }
            }
        }
    }
    /**
     * 根据位置得到相应的fragement
     * @return
     */
    private BaseFragement getFragement()
    {
        return mBaseFragement.get(position);
    }
    /**
     * 初始化fragement
     */
    private void initFragement()
    {
        mBaseFragement = new ArrayList<BaseFragement>();
        mBaseFragement.add(new PlanFragement());        //任务单
        mBaseFragement.add(new InventoryFragement());   //盘点
        mBaseFragement.add(new SettingFragement());     //设置

    }

    /**
     * 初始化页面控件
     */
    private void initView()
    {
        rg_main = (RadioGroup) findViewById(R.id.rg_main);
    }
}
