package com.dsm.model.entity;

import java.math.BigDecimal;
import java.sql.Blob;
import java.sql.Date;

/*
店员信息，用于记录售货员的基本信息
*/

public class Salesman
{
    private String salesmanNo;              //售货员编号，主键
    private String salesmanName;            //售货员姓名
    private String sex;                     //性别
    private java.sql.Date birthday;         //出生日期
    private int age;                        //年龄
    private String telephone;               //联系电话
    private Date hireDate;                  //就职日期
    private String storeNo;                 //就职店面编号，外键
    private BigDecimal salary;              //月薪
    private String passwd;                  //登录密码
    private int onDuty;                     //是否在职，1：在职，0：离职
    private Blob icon;                      //头像

    public String getSalesmanNo()
    {
        return salesmanNo;
    }

    public void setSalesmanNo(String salesmanNo)
    {
        this.salesmanNo = salesmanNo;
    }

    public String getSalesmanName()
    {
        return salesmanName;
    }

    public void setSalesmanName(String salesmanName)
    {
        this.salesmanName = salesmanName;
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

    public Salesman(String salesmanNo, String salesmanName, String sex, Date birthday, int age, String telephone, Date hireDate, String storeNo, BigDecimal salary, String passwd, int onDuty, Blob icon)
    {

        this.salesmanNo = salesmanNo;
        this.salesmanName = salesmanName;
        this.sex = sex;
        this.birthday = birthday;
        this.age = age;
        this.telephone = telephone;
        this.hireDate = hireDate;
        this.storeNo = storeNo;
        this.salary = salary;
        this.passwd = passwd;
        this.onDuty = onDuty;
        this.icon = icon;
    }
}
