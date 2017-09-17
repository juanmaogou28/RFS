package com.rfid.rfs.model.bean;

/**
 * 项目名称：RFS
 * 类描述：用户账号信息
 * 创建人：lenovo
 * 创建时间：2017-09-16 3:11
 * 修改人：lenovo
 * 修改时间：2017-09-16 3:11
 * 修改备注：
 */
public class RfsSystemUser
{
    public RfsSystemUser()
    {
    }

    private String id;

    private String code;

    private String passwd;

    private String deviceId;

    private Integer pwdNum;

    private String createTime;

    private Integer status;

    private String notes;

    private String by1;

    private String by2;

    private String by3;

    private String by4;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd == null ? null : passwd.trim();
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId == null ? null : deviceId.trim();
    }

    public Integer getPwdNum() {
        return pwdNum;
    }

    public void setPwdNum(Integer pwdNum) {
        this.pwdNum = pwdNum;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes == null ? null : notes.trim();
    }

    public String getBy1() {
        return by1;
    }

    public void setBy1(String by1) {
        this.by1 = by1 == null ? null : by1.trim();
    }

    public String getBy2() {
        return by2;
    }

    public void setBy2(String by2) {
        this.by2 = by2 == null ? null : by2.trim();
    }

    public String getBy3() {
        return by3;
    }

    public void setBy3(String by3) {
        this.by3 = by3 == null ? null : by3.trim();
    }

    public String getBy4() {
        return by4;
    }

    public void setBy4(String by4) {
        this.by4 = by4 == null ? null : by4.trim();
    }

    @Override
    public String toString()
    {
        return "RfsSystemUser{" +
                "id='" + id + '\'' +
                ", code='" + code + '\'' +
                ", passwd='" + passwd + '\'' +
                ", deviceId='" + deviceId + '\'' +
                ", pwdNum=" + pwdNum +
                ", createTime='" + createTime + '\'' +
                ", status=" + status +
                ", notes='" + notes + '\'' +
                ", by1='" + by1 + '\'' +
                ", by2='" + by2 + '\'' +
                ", by3='" + by3 + '\'' +
                ", by4='" + by4 + '\'' +
                '}';
    }
}
