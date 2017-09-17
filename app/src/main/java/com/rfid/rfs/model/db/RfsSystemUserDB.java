package com.rfid.rfs.model.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.rfid.rfs.model.dao.table.RfsSystemUserTable;

/**
 * 项目名称：RFS
 * 类描述：
 * 创建人：lenovo
 * 创建时间：2017-09-16 3:16
 * 修改人：lenovo
 * 修改时间：2017-09-16 3:16
 * 修改备注：
 */
public class RfsSystemUserDB extends SQLiteOpenHelper
{

    public RfsSystemUserDB(Context context)
    {
        super(context, "rfs.db", null, 1);
    }

    /**
     * 创建数据库
     * @param db
     */
    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL(RfsSystemUserTable.CREATE_TAB);
    }

    /**
     * 更新数据库
     * @param db
     * @param oldVersion
     * @param newVersion，从1开始向上升级
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {

    }
}
