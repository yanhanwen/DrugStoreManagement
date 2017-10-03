package com.dsm.model.entity;

import java.math.BigDecimal;
import java.sql.Blob;
import java.sql.Date;

/*
仓库管理员信息，用于记录仓库管理员的基本信息
*/

public class WarehouseManager
{
    private String wareManNo;           //仓库管理员编号，主键
    private String wareManName;         //仓库管理员姓名
    private String sex;                 //性别
    private Date birthday;              //出生日期
    private int age;                    //年龄
    private String telephone;           //联系电话
    private Date hireDate;              //就职日期
    private String warehouseNo;         //管理仓库编号，外键
    private BigDecimal salary;          //月薪
    private String passwd;              //登录密码
    private String managerNo;           //总经理编号
    private int onDuty;                 //是否在职，1：在职，0：离职
    private Blob icon;                  //头像

    public String getWareManNo()
    {
        return wareManNo;
    }

    public void setWareManNo(String wareManNo)
    {
        this.wareManNo = wareManNo;
    }

    public String getWareManName()
    {
        return wareManName;
    }

    public void setWareManName(String wareManName)
    {
        this.wareManName = wareManName;
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

    public String getWarehouseNo()
    {
        return warehouseNo;
    }

    public void setWarehouseNo(String warehouseNo)
    {
        this.warehouseNo = warehouseNo;
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

    public WarehouseManager(String wareManNo, String wareManName, String sex, Date birthday, int age, String telephone, Date hireDate, String warehouseNo, BigDecimal salary, String passwd, String managerNo, int onDuty, Blob icon)
    {

        this.wareManNo = wareManNo;
        this.wareManName = wareManName;
        this.sex = sex;
        this.birthday = birthday;
        this.age = age;
        this.telephone = telephone;
        this.hireDate = hireDate;
        this.warehouseNo = warehouseNo;
        this.salary = salary;
        this.passwd = passwd;
        this.managerNo = managerNo;
        this.onDuty = onDuty;
        this.icon = icon;
    }
}
