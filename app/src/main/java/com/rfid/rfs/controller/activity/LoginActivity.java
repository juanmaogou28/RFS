package com.rfid.rfs.controller.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.rfid.rfs.R;
import com.rfid.rfs.model.Model;
import com.rfid.rfs.model.bean.RfsSystemUser;
import com.rfid.rfs.utils.Constants;
import com.rfid.rfs.utils.DateUtils;
import com.rfid.rfs.utils.DeviceUUID;
import com.rfid.rfs.utils.JsonUtils;
import com.rfid.rfs.utils.RequestMethod;
import com.rfid.rfs.utils.StringUtils;

import java.io.IOException;
import java.util.Date;

import static com.rfid.rfs.utils.JsonUtils.getStringForJson;

public class LoginActivity extends AppCompatActivity
{
    private EditText edt_login_code;            //账号
    private EditText edt_login_pwd;             //密码
    private Button   btn_login_reg;             //注册
    private Button   btn_login_login;           //登录



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //初始化页面
        this.initView();
        //初始化监听
        this.initListener();
    }

    /**
     * 用来处理注册与登录
     */
    public void initListener()
    {
        //注册按钮监听
        btn_login_reg.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                reg();
            }
        });

        //登录按钮监听
        btn_login_login.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                login();
            }
        });
    }

    /**
     * 登录业务逻辑处理
     */
    private void login()
    {
        //获取账号与密码
        final String code = edt_login_code.getText().toString();
        final String pwd = edt_login_pwd.getText().toString();

        //进行校验
        if (TextUtils.isEmpty(code))
        {
            Toast.makeText(LoginActivity.this,"账号不能为空!", Toast.LENGTH_SHORT).show();
            edt_login_code.setFocusable(true);
            return;
        }
        if(TextUtils.isEmpty(pwd))
        {
            Toast.makeText(LoginActivity.this,"密码不能这空!", Toast.LENGTH_SHORT).show();
            edt_login_pwd.setFocusable(true);
            return;
        }

        //登录业务逻辑处理
        Model.getInstantent().getGlobalThreadPool().execute(new Runnable()
        {
            @Override
            public void run()
            {
                try 
                {
                    String url = Constants.LOGIN_URL + code + "/"  + pwd + "/" + DeviceUUID.getUniquePsuedoID();
                    String requestResult = RequestMethod.get(url);
                    String json = getStringForJson(requestResult, "result");
                    String flag =  JsonUtils.getStringForJson(requestResult, "success");
                    if ("true".equals(flag))
                    {
                        //登录成功后对数据模型层的处理
                        Model.getInstantent().loginSuccess();
                        //保存数据账号信息到本地数据库
                        RfsSystemUser systemUser = JsonUtils.jsonToObject(json, RfsSystemUser.class);

                        Model.getInstantent().getRfsSystemUserDao().addSystemUser(systemUser);
                        //提示登录成功
                        runOnUiThread(new Runnable()
                        {
                            @Override
                            public void run()
                            {
                                Toast.makeText(LoginActivity.this,"登录成功!", Toast.LENGTH_SHORT).show();
                            }
                        });
                        //登录成功后跳转到主界面
                        Intent mainIntent = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(mainIntent);
                    } 
                    else 
                    {
                        runOnUiThread(new Runnable()
                        {
                            @Override
                            public void run()
                            {
                                Toast.makeText(LoginActivity.this,"登录失败!", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                } catch (Exception e)
                {
                    e.printStackTrace();
                }

            }
        });

    }

    /**
     * 注册业务逻辑处理
     */
    private void reg()
    {
        //获取账号与密码
        final String code = edt_login_code.getText().toString();
        final String pwd = edt_login_pwd.getText().toString();
        
        //进行校验
        if (TextUtils.isEmpty(code))
        {
            Toast.makeText(LoginActivity.this,"账号不能为空!", Toast.LENGTH_SHORT).show();
            edt_login_code.setFocusable(true);
            return;
        }
        if(TextUtils.isEmpty(pwd))
        {
            Toast.makeText(LoginActivity.this,"密码不能这空!", Toast.LENGTH_SHORT).show();
            edt_login_pwd.setFocusable(true);
            return;
        }
        
        //请求服务器,开一个线程来进行处理
        Model.getInstantent().getGlobalThreadPool().execute(new Runnable()
        {
            @Override
            public void run()
            {
                try
                {
                    //发送post请求调用服务器
                    String jsonResult = registerRequest(code, pwd, DeviceUUID.getUniquePsuedoID());
                    //解析返回结果
                    String result = getStringForJson(jsonResult, "success");
                    if ("true".equals(result))
                    {
                        //注册成功，更新页面，子线程中无法更新
                        runOnUiThread(new Runnable()
                        {
                            @Override
                            public void run()
                            {
                                Toast.makeText(LoginActivity.this,"注册成功!", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                    else
                    {
                        //子线程操作主线程，要返回主线程在操作
                        runOnUiThread(new Runnable()
                        {
                            @Override
                            public void run()
                            {
                                Toast.makeText(LoginActivity.this,"注册失败!", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                } catch (Exception e)
                {
                    e.printStackTrace();
                    runOnUiThread(new Runnable()
                    {
                        @Override
                        public void run()
                        {
                            Toast.makeText(LoginActivity.this,"注册失败!", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });
    }

    /**
     * 发送post请求
     * @param code
     * @param pwd
     * @param uniquePsuedoID
     */
    private String registerRequest(String code, String pwd, String uniquePsuedoID) throws IOException
    {
        RfsSystemUser systemUser = new RfsSystemUser();
        systemUser.setId(StringUtils.get36UUID());
        systemUser.setCode(code);
        systemUser.setPasswd(pwd);
        systemUser.setDeviceId(uniquePsuedoID);
        systemUser.setPwdNum(0);
        systemUser.setStatus(1);
        systemUser.setCreateTime(DateUtils.dateFormatString(new Date()));

        String json = JsonUtils.getJsonForObject(systemUser);
        return RequestMethod.post(Constants.REGIST_URL, json);
    }

    /**
     * 初始化页面控件
     * @return
     */
    private void initView()
    {
        //账号-密码
        edt_login_code = (EditText) findViewById(R.id.edt_login_code);
        edt_login_pwd = (EditText) findViewById(R.id.edt_login_pwd);

        //注册-登录
        btn_login_reg = (Button) findViewById(R.id.btn_login_reg);
        btn_login_login = (Button) findViewById(R.id.btn_login_login);
    }
}
