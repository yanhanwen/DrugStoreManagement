package com.dsm.model.entity;

import java.math.BigDecimal;
import java.sql.Blob;

/*
鎬荤粡鐞嗕俊鎭紝鐢ㄤ簬璁板綍鎬荤粡鐞嗙殑鍩烘湰淇℃伅
*/

public class Manager
{
    private String managerNo;       //鎬荤粡鐞嗙紪鍙凤紝涓婚敭
    private String managerName;     //鎬荤粡鐞嗗鍚�
    private String sex;             //鎬у埆
    private java.sql.Timestamp birthday;          //鍑虹敓鏃ユ湡
    private String telephone;       //鑱旂郴鐢佃瘽
    private java.sql.Timestamp hireDate;          //灏辫亴鏃ユ湡
    private BigDecimal salary;      //鏈堣柂
    private String passwd;          //鐧诲綍瀵嗙爜
    private BigDecimal onDuty;             //鏄惁鍦ㄨ亴锛�1锛氬湪鑱岋紝0锛氱鑱�
    private Blob icon;              //澶村儚
	public String getManagerno()
	{
		return managerNo;
	}
	public void setManagerno(String managerNo)
	{
		this.managerNo = managerNo;
	}
	public String getManagername()
	{
		return managerName;
	}
	public void setManagername(String managerName)
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
	public java.sql.Timestamp getBirthday()
	{
		return birthday;
	}
	public void setBirthday(java.sql.Timestamp birthday)
	{
		this.birthday = birthday;
	}
	public String getTelephone()
	{
		return telephone;
	}
	public void setTelephone(String telephone)
	{
		this.telephone = telephone;
	}
	public java.sql.Timestamp getHiredate()
	{
		return hireDate;
	}
	public void setHiredate(java.sql.Timestamp hireDate)
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
	public BigDecimal getOnduty()
	{
		return onDuty;
	}
	public void setOnduty(BigDecimal onDuty)
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
	public Manager(String managerNo, String managerName, String sex, java.sql.Timestamp birthday, String telephone, java.sql.Timestamp hireDate,
			BigDecimal salary, String passwd, BigDecimal onDuty)
	{
		super();
		this.managerNo = managerNo;
		this.managerName = managerName;
		this.sex = sex;
		this.birthday = birthday;
		this.telephone = telephone;
		this.hireDate = hireDate;
		this.salary = salary;
		this.passwd = passwd;
		this.onDuty = onDuty;
	}
	public Manager()
	{
		super();
	}
    public String[] getColumns()
    {
    	String cols[] = null;
    	cols = new String[8];
    	cols[0] = "编号";
    	cols[1] = "姓名";
    	cols[2] = "性别";
    	cols[3] = "出生日期";
    	cols[4] = "联系电话";
    	cols[5] = "就职日期";
    	cols[6] = "月薪";
    	cols[7] = "登录密码";
    	return cols;
    }
}
