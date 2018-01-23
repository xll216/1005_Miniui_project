package com.ssh.domain;

import java.io.Serializable;

/**
 * Created by 蓝鸥科技有限公司  www.lanou3g.com.
 */
public class Student implements Serializable {

    private int sid;
    private String sname;
    private String spassword;

    //保持一个外健 班级 即学生所在的班级
    private Clazz clazz;

    //用于接收注册页面中提交的班级id，不需要数据库映射
    //只做数据接收
    private String clazzId;

    public Student() {
    }

    public Student(String sname, String spassword) {
        this.sname = sname;
        this.spassword = spassword;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSpassword() {
        return spassword;
    }

    public void setSpassword(String spassword) {
        this.spassword = spassword;
    }

    public Clazz getClazz() {
        return clazz;
    }

    public void setClazz(Clazz clazz) {
        this.clazz = clazz;
    }

    public String getClazzId() {
        return clazzId;
    }

    public void setClazzId(String clazzId) {
        this.clazzId = clazzId;
    }

    @Override
    public String toString() {
        return "StudentDao{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                ", spassword='" + spassword + '\'' +
                '}';
    }
}
