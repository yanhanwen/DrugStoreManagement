package com.dsm.model.entity;

import java.math.BigDecimal;
import java.sql.Blob;
import java.sql.Date;

/*
浠撳簱绠＄悊鍛樹俊鎭紝鐢ㄤ簬璁板綍浠撳簱绠＄悊鍛樼殑鍩烘湰淇℃伅
*/

public class WarehouseManager
{
    private String wareManNo;           //浠撳簱绠＄悊鍛樼紪鍙凤紝涓婚敭
    private String wareManName;         //浠撳簱绠＄悊鍛樺鍚�
    private String sex;                 //鎬у埆
    private Date birthday;              //鍑虹敓鏃ユ湡
    private String telephone;           //鑱旂郴鐢佃瘽
    private Date hireDate;              //灏辫亴鏃ユ湡
    private String warehouseNo;         //绠＄悊浠撳簱缂栧彿锛屽閿�
    private BigDecimal salary;          //鏈堣柂
    private String passwd;              //鐧诲綍瀵嗙爜
    private String managerNo;           //鎬荤粡鐞嗙紪鍙�
    private int onDuty;                 //鏄惁鍦ㄨ亴锛�1锛氬湪鑱岋紝0锛氱鑱�
    private Blob icon;                  //澶村儚
	public String getWaremanno()
	{
		return wareManNo;
	}
	public void setWaremanno(String wareManNo)
	{
		this.wareManNo = wareManNo;
	}
	public String getWaremanname()
	{
		return wareManName;
	}
	public void setWaremanname(String wareManName)
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
	public String getTelephone()
	{
		return telephone;
	}
	public void setTelephone(String telephone)
	{
		this.telephone = telephone;
	}
	public Date getHiredate()
	{
		return hireDate;
	}
	public void setHiredate(Date hireDate)
	{
		this.hireDate = hireDate;
	}
	public String getWarehouseno()
	{
		return warehouseNo;
	}
	public void setWarehouseno(String warehouseNo)
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
	public String getManagerno()
	{
		return managerNo;
	}
	public void setManagerno(String managerNo)
	{
		this.managerNo = managerNo;
	}
	public int getOnduty()
	{
		return onDuty;
	}
	public void setOnduty(int onDuty)
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
	public WarehouseManager(String wareManNo, String wareManName, String sex, Date birthday, String telephone,
			Date hireDate, String warehouseNo, BigDecimal salary, String passwd, String managerNo, int onDuty)
	{
		super();
		this.wareManNo = wareManNo;
		this.wareManName = wareManName;
		this.sex = sex;
		this.birthday = birthday;
		this.telephone = telephone;
		this.hireDate = hireDate;
		this.warehouseNo = warehouseNo;
		this.salary = salary;
		this.passwd = passwd;
		this.managerNo = managerNo;
		this.onDuty = onDuty;
	}
	public WarehouseManager()
	{
		super();
	}
	
}
