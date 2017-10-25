package com.dsm.model.entity;

import java.math.BigDecimal;
import java.sql.Blob;

/*
鍒嗗簵缁忕悊锛岀敤浜庤褰曞垎搴楃粡鐞嗙殑鍩烘湰淇℃伅
*/

public class StoreManager
{
    private String storeManNo;      //鍒嗗簵缁忕悊缂栧彿锛屼富閿�
    private String storeManName;    //鍒嗗簵缁忕悊濮撳悕
    private String sex;             //鎬у埆
    private java.sql.Timestamp birthday;          //鍑虹敓鏃ユ湡
    private String telephone;       //鑱旂郴鐢佃瘽
    private java.sql.Timestamp hireDate;          //灏辫亴鏃堕棿
    private String storeNo;         //灏辫亴搴楅潰缂栧彿
    private BigDecimal salary;      //鏈堣柂
    private String passwd;          //鐧诲綍瀵嗙爜
    private String managerNo;       //鎬荤粡鐞嗙紪鍙�
    private int onDuty;             //鏄惁鍦ㄨ亴锛�1锛氬湪鑱岋紝0锛氱鑱�
    private Blob icon;              //澶村儚
	public String getStoremanno()
	{
		return storeManNo;
	}
	public void setStoremanno(String storeManNo)
	{
		this.storeManNo = storeManNo;
	}
	public String getStoremanname()
	{
		return storeManName;
	}
	public void setStoremanname(String storeManName)
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
	public String getStoreno()
	{
		return storeNo;
	}
	public void setStoreno(String storeNo)
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
	public StoreManager(String storeManNo, String storeManName, String sex, java.sql.Timestamp birthday, String telephone,
			java.sql.Timestamp hireDate, String storeNo, BigDecimal salary, String passwd, String managerNo, int onDuty)
	{
		super();
		this.storeManNo = storeManNo;
		this.storeManName = storeManName;
		this.sex = sex;
		this.birthday = birthday;
		this.telephone = telephone;
		this.hireDate = hireDate;
		this.storeNo = storeNo;
		this.salary = salary;
		this.passwd = passwd;
		this.managerNo = managerNo;
		this.onDuty = onDuty;
	}
	public StoreManager()
	{
		super();
	}
}
