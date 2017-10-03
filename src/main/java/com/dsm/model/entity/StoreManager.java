package com.dsm.model.entity;

import java.math.BigDecimal;
import java.sql.Blob;
import java.sql.Date;

/*
分店经理，用于记录分店经理的基本信息
*/

public class StoreManager
{
    private String storeManNo;      //分店经理编号，主键
    private String storeManName;    //分店经理姓名
    private String sex;             //性别
    private Date birthday;          //出生日期
    private int age;                //年龄
    private String telephone;       //联系电话
    private Date hireDate;          //就职时间
    private String storeNo;         //就职店面编号
    private BigDecimal salary;      //月薪
    private String passwd;          //登录密码
    private String managerNo;       //总经理编号
    private int onDuty;             //是否在职，1：在职，0：离职
    private Blob icon;              //头像

    public String getStoreManNo()
    {
        return storeManNo;
    }

    public void setStoreManNo(String storeManNo)
    {
        this.storeManNo = storeManNo;
    }

    public String getStoreManName()
    {
        return storeManName;
    }

    public void setStoreManName(String storeManName)
    {
        this.storeManName = storeManName;
    }

    public String getSex()
    {
        return sex;
    }

    public void setSex(String sex)
    {
        this.sex = sex;
    }

    public Date getBirthday()
    {
        return birthday;
    }

    public void setBirthday(Date birthday)
    {
        this.birthday = birthday;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public String getTelephone()
    {
        return telephone;
    }

    public void setTelephone(String telephone)
    {
        this.telephone = telephone;
    }

    public Date getHireDate()
    {
        return hireDate;
    }

    public void setHireDate(Date hireDate)
    {
        this.hireDate = hireDate;
    }

    public String getStoreNo()
    {
        return storeNo;
    }

    public void setStoreNo(String storeNo)
    {
        this.storeNo = storeNo;
    }

    public BigDecimal getSalary()
    {
        return salary;
    }

    public void setSalary(BigDecimal salary)
    {
        this.salary = salary;
    }

    public String getPasswd()
    {
        return passwd;
    }

    public void setPasswd(String passwd)
    {
        this.passwd = passwd;
    }

    public String getManagerNo()
    {
        return managerNo;
    }

    public void setManagerNo(String managerNo)
    {
        this.managerNo = managerNo;
    }

    public int getOnDuty()
    {
        return onDuty;
    }

    public void setOnDuty(int onDuty)
    {
        this.onDuty = onDuty;
    }

    public Blob getIcon()
    {
        return icon;
    }

    public void setIcon(Blob icon)
    {
        this.icon = icon;
    }

    public StoreManager(String storeManNo, String storeManName, String sex, Date birthday, int age, String telephone, Date hireDate, String storeNo, BigDecimal salary, String passwd, String managerNo, int onDuty, Blob icon)
    {

        this.storeManNo = storeManNo;
        this.storeManName = storeManName;
        this.sex = sex;
        this.birthday = birthday;
        this.age = age;
        this.telephone = telephone;
        this.hireDate = hireDate;
        this.storeNo = storeNo;
        this.salary = salary;
        this.passwd = passwd;
        this.managerNo = managerNo;
        this.onDuty = onDuty;
        this.icon = icon;
    }
}
