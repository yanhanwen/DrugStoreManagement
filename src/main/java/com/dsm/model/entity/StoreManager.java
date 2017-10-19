package com.dsm.model.entity;

import java.math.BigDecimal;
import java.sql.Blob;
import java.sql.Date;

/*
鍒嗗簵缁忕悊锛岀敤浜庤褰曞垎搴楃粡鐞嗙殑鍩烘湰淇℃伅
*/

public class StoreManager
{
    private String storeManNo;      //鍒嗗簵缁忕悊缂栧彿锛屼富閿�
    private String storeManName;    //鍒嗗簵缁忕悊濮撳悕
    private String sex;             //鎬у埆
    private Date birthday;          //鍑虹敓鏃ユ湡
    private String telephone;       //鑱旂郴鐢佃瘽
    private Date hireDate;          //灏辫亴鏃堕棿
    private String storeNo;         //灏辫亴搴楅潰缂栧彿
    private BigDecimal salary;      //鏈堣柂
    private String passwd;          //鐧诲綍瀵嗙爜
    private String managerNo;       //鎬荤粡鐞嗙紪鍙�
    private int onDuty;             //鏄惁鍦ㄨ亴锛�1锛氬湪鑱岋紝0锛氱鑱�
    private Blob icon;              //澶村儚
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
	public StoreManager(String storeManNo, String storeManName, String sex, Date birthday, String telephone,
			Date hireDate, String storeNo, BigDecimal salary, String passwd, String managerNo, int onDuty)
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
