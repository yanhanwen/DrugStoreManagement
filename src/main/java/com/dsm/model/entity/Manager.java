package com.dsm.model.entity;

import java.math.BigDecimal;
import java.sql.Blob;
import java.sql.Date;

/*
鎬荤粡鐞嗕俊鎭紝鐢ㄤ簬璁板綍鎬荤粡鐞嗙殑鍩烘湰淇℃伅
*/

public class Manager
{
    private String managerNo;       //鎬荤粡鐞嗙紪鍙凤紝涓婚敭
    private String managerName;     //鎬荤粡鐞嗗鍚�
    private String sex;             //鎬у埆
    private Date birthday;          //鍑虹敓鏃ユ湡
    private int age;                //骞撮緞
    private String telephone;       //鑱旂郴鐢佃瘽
    private Date hireDate;          //灏辫亴鏃ユ湡
    private BigDecimal salary;      //鏈堣柂
    private String passwd;          //鐧诲綍瀵嗙爜
    private int onDuty;             //鏄惁鍦ㄨ亴锛�1锛氬湪鑱岋紝0锛氱鑱�
    private Blob icon;              //澶村儚

    public String getManagerNo()
    {
        return managerNo;
    }

    public void setManagerNo(String managerNo)
    {
        this.managerNo = managerNo;
    }

    public String getManagerName()
    {
        return managerName;
    }

    public void setManagerName(String managerName)
    {
        this.managerName = managerName;
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

    public Manager(String managerNo, String managerName, String sex, Date birthday, int age, String telephone, Date hireDate, BigDecimal salary, String passwd, int onDuty, Blob icon)
    {

        this.managerNo = managerNo;
        this.managerName = managerName;
        this.sex = sex;
        this.birthday = birthday;
        this.age = age;
        this.telephone = telephone;
        this.hireDate = hireDate;
        this.salary = salary;
        this.passwd = passwd;
        this.onDuty = onDuty;
        this.icon = icon;
    }
    public Manager()
    {
    	
    }
}
