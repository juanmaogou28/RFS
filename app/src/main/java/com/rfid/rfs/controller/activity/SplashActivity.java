package com.rfid.rfs.controller.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import com.rfid.rfs.R;
import com.rfid.rfs.model.Model;
import com.rfid.rfs.model.bean.RfsSystemUser;
import com.rfid.rfs.utils.DeviceUUID;
import com.rfid.rfs.utils.StringUtils;

/**
 * 欢迎界面
 */
public class SplashActivity extends Activity
{
    private Handler handler = new Handler(){
        public void handleMessage(Message msg){
            // 如果当前activity已经退出，那么我就不处理handler中的消息
            if(isFinishing()) {
                return;
            }

            // 判断进入主页面还是登录页面
            toMainOrLogin();
        }
    };

    /**
     * 判断是登录过还是没有登录
     */
    private void toMainOrLogin()
    {
        //使用线程池来进行处理
        Model.getInstantent().getGlobalThreadPool().execute(new Runnable()
        {
            @Override
            public void run()
            {
                //判断当前账号是否已经登录
                String deviceId = DeviceUUID.getUniquePsuedoID();
                RfsSystemUser systemUser = Model.getInstantent().getRfsSystemUserDao().getRfsSystemUserByDeviceId(deviceId);
                //登录直接跳转到主界面，没有登录进行登录
                if (StringUtils.isEmpty(systemUser))
                {
                    //进入登录界面
                    Intent loginIntent = new Intent(SplashActivity.this, LoginActivity.class);
                    startActivity(loginIntent);
                }
                else
                {
                    //直接跳转到主界面
                    Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                    startActivity(intent);
                }

                //结束当前页面
                finish();
            }
        });
    }


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //发送2延时消息
        handler.sendMessageDelayed(Message.obtain(), 2000);
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        //销毁消息
        handler.removeCallbacksAndMessages(null);
    }
}
