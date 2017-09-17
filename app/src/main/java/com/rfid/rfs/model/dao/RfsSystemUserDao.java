package com.rfid.rfs.model.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.rfid.rfs.model.bean.RfsSystemUser;
import com.rfid.rfs.model.dao.table.RfsSystemUserTable;
import com.rfid.rfs.model.db.RfsSystemUserDB;

/**
 * 项目名称：RFS
 * 类描述：用户账号数据库的操作类
 * 创建人：lenovo
 * 创建时间：2017-09-15 19:01
 * 修改人：lenovo
 * 修改时间：2017-09-15 19:01
 * 修改备注：
 */
public class RfsSystemUserDao
{
    public final RfsSystemUserDB hepler;

    public RfsSystemUserDao(Context context)
    {
        hepler = new RfsSystemUserDB(context);

    }

    /**
     * 添加操作
     * @param systemUser
     */
    public void addSystemUser(RfsSystemUser systemUser)
    {

        SQLiteDatabase db = hepler.getReadableDatabase();

        ContentValues values = new ContentValues();
        values.put(RfsSystemUserTable.COL_ID, systemUser.getId());
        values.put(RfsSystemUserTable.COL_CODE, systemUser.getCode());
        values.put(RfsSystemUserTable.COL_PASSWD, systemUser.getPasswd());
        values.put(RfsSystemUserTable.COL_DEVICEID, systemUser.getDeviceId());
        values.put(RfsSystemUserTable.COL_PWDNUM, systemUser.getPwdNum());
        values.put(RfsSystemUserTable.COL_NOTES, systemUser.getNotes());
        values.put(RfsSystemUserTable.COL_CREATETIME, systemUser.getCreateTime());
        values.put(RfsSystemUserTable.COL_STATUS, systemUser.getStatus());
        values.put(RfsSystemUserTable.COL_BY1, systemUser.getBy1());
        values.put(RfsSystemUserTable.COL_BY2, systemUser.getBy2());
        values.put(RfsSystemUserTable.COL_BY3, systemUser.getBy3());
        values.put(RfsSystemUserTable.COL_BY4, systemUser.getBy4());

        db.replace(RfsSystemUserTable.TAB_NAME, null, values);
    }

    /**
     * 根据账号获得用户信息
     * @param code
     * @return
     */
    public RfsSystemUser getSystemUserInfor(String code)
    {
        SQLiteDatabase db = hepler.getReadableDatabase();
        String sql = "select * from " + RfsSystemUserTable.TAB_NAME + " where "
                                        + RfsSystemUserTable.COL_CODE + "= ?";
        Cursor cursor = db.rawQuery(sql, new String[]{code});

        RfsSystemUser systemUser = null;
        if (cursor.moveToNext())
        {
            systemUser = new RfsSystemUser();

            // 封装对象
            systemUser.setId(cursor.getString(cursor.getColumnIndex(RfsSystemUserTable.COL_ID)));
            systemUser.setCode(cursor.getString(cursor.getColumnIndex(RfsSystemUserTable.COL_CODE)));
            systemUser.setPasswd(cursor.getString(cursor.getColumnIndex(RfsSystemUserTable.COL_PASSWD)));
            systemUser.setDeviceId(cursor.getString(cursor.getColumnIndex(RfsSystemUserTable.COL_DEVICEID)));
            systemUser.setPwdNum(cursor.getInt(cursor.getColumnIndex(RfsSystemUserTable.COL_PWDNUM)));
            systemUser.setCreateTime(cursor.getString(cursor.getColumnIndex(RfsSystemUserTable.COL_CREATETIME)));
            systemUser.setStatus(cursor.getInt(cursor.getColumnIndex(RfsSystemUserTable.COL_STATUS)));
            systemUser.setNotes(cursor.getString(cursor.getColumnIndex(RfsSystemUserTable.COL_NOTES)));
            systemUser.setBy1(cursor.getString(cursor.getColumnIndex(RfsSystemUserTable.COL_BY1)));
            systemUser.setBy2(cursor.getString(cursor.getColumnIndex(RfsSystemUserTable.COL_BY2)));
            systemUser.setBy3(cursor.getString(cursor.getColumnIndex(RfsSystemUserTable.COL_BY3)));
            systemUser.setBy4(cursor.getString(cursor.getColumnIndex(RfsSystemUserTable.COL_BY4)));
        }

        //关闭资源
        cursor.close();

        //返回数据
        return systemUser;
   }

    /**
     * 通过设备Id得到用户账号所有信息
     * @param deviceId
     * @return
     */
   public RfsSystemUser getRfsSystemUserByDeviceId(String deviceId)
   {
       SQLiteDatabase db = hepler.getReadableDatabase();
       String sql = "select * from " + RfsSystemUserTable.TAB_NAME + " where " + RfsSystemUserTable.COL_DEVICEID
                                    + "= ?";
       String[] values = new String[] {deviceId};
       Cursor cursor = db.rawQuery(sql, values);

       RfsSystemUser systemUser = null;
       if (cursor.moveToNext())
       {
           systemUser = new RfsSystemUser();

           //封装对象
          systemUser.setId(cursor.getString(cursor.getColumnIndex(RfsSystemUserTable.COL_ID)));
           systemUser.setCode(cursor.getString(cursor.getColumnIndex(RfsSystemUserTable.COL_CODE)));
           systemUser.setPasswd(cursor.getString(cursor.getColumnIndex(RfsSystemUserTable.COL_PASSWD)));
           systemUser.setDeviceId(cursor.getString(cursor.getColumnIndex(RfsSystemUserTable.COL_DEVICEID)));
           systemUser.setPwdNum(cursor.getInt(cursor.getColumnIndex(RfsSystemUserTable.COL_PWDNUM)));
           systemUser.setCreateTime(cursor.getString(cursor.getColumnIndex(RfsSystemUserTable.COL_CREATETIME)));
           systemUser.setStatus(cursor.getInt(cursor.getColumnIndex(RfsSystemUserTable.COL_STATUS)));
           systemUser.setNotes(cursor.getString(cursor.getColumnIndex(RfsSystemUserTable.COL_NOTES)));
           systemUser.setBy1(cursor.getString(cursor.getColumnIndex(RfsSystemUserTable.COL_BY1)));
           systemUser.setBy2(cursor.getString(cursor.getColumnIndex(RfsSystemUserTable.COL_BY2)));
           systemUser.setBy3(cursor.getString(cursor.getColumnIndex(RfsSystemUserTable.COL_BY3)));
           systemUser.setBy4(cursor.getString(cursor.getColumnIndex(RfsSystemUserTable.COL_BY4)));
       }

       //关闭资源
       cursor.close();

       //返回数据
       return systemUser;
   }
}