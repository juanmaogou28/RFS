package com.rfid.rfs.model.dao.table;

/**
 * 项目名称：RFS
 * 类描述：创建RfsSystemUser表
 * 创建人：lenovo
 * 创建时间：2017-09-16 3:21
 * 修改人：lenovo
 * 修改时间：2017-09-16 3:21
 * 修改备注：
 */
public class RfsSystemUserTable
{
    public static final String TAB_NAME = "rfs_system_user";
    public static final String COL_ID   = "id";
    public static final String COL_CODE   = "code";
    public static final String COL_PASSWD   = "passwd";
    public static final String COL_DEVICEID   = "device_id";
    public static final String COL_PWDNUM   = "pwd_num";
    public static final String COL_CREATETIME   = "create_time";
    public static final String COL_STATUS   = "status";
    public static final String COL_NOTES   = "notes";
    public static final String COL_BY1   = "by1";
    public static final String COL_BY2   = "by2";
    public static final String COL_BY3   = "by3";
    public static final String COL_BY4   = "by4";

    public static final String CREATE_TAB = "create table" + " "
            + TAB_NAME + " " + "("
            + COL_ID + " " + "varchar(36) primary key" + ","
            + COL_CODE + " " + "varchar(36) not null" + ","
            + COL_PASSWD + " " + "varchar(50) not null" + ","
            + COL_DEVICEID + " " + "varchar(36) not null" + ","
            + COL_PWDNUM + " " + "int(2) not null" + ","
            + COL_CREATETIME + " " + "varchar(36) not null" + ","
            + COL_STATUS + " " + "int(2) not null" + ","
            + COL_NOTES + " " + "varchar(255)" + ","
            + COL_BY1 + " " + "varchar(255)" + ","
            + COL_BY2 + " " + "varchar(255)" + ","
            + COL_BY3 + " " + "varchar(255)" + ","
            + COL_BY4 + " " + "varchar(255)" + ")" + ";";
}
