package com.dsm.model.entity;

import java.math.BigDecimal;
import java.sql.Blob;
import java.sql.Date;

/*
搴楀憳淇℃伅锛岀敤浜庤褰曞敭璐у憳鐨勫熀鏈俊鎭�
*/

public class Salesman
{
    private String salesmanNo;              //鍞揣鍛樼紪鍙凤紝涓婚敭
    private String salesmanName;            //鍞揣鍛樺鍚�
    private String sex;                     //鎬у埆
    private java.sql.Date birthday;         //鍑虹敓鏃ユ湡
    private String telephone;               //鑱旂郴鐢佃瘽
    private java.sql.Date hireDate;                  //灏辫亴鏃ユ湡
    private String storeNo;                 //灏辫亴搴楅潰缂栧彿锛屽閿�
    private BigDecimal salary;              //鏈堣柂
    private String passwd;                  //鐧诲綍瀵嗙爜
    private int onDuty;                     //鏄惁鍦ㄨ亴锛�1锛氬湪鑱岋紝0锛氱鑱�
    private Blob icon;                      //澶村儚
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
	public java.sql.Date getBirthday()
	{
		return birthday;
	}
	public void setBirthday(java.sql.Date birthday)
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
	public Salesman(String salesmanNo, String salesmanName, String sex, Date birthday, String telephone, Date hireDate,
			String storeNo, BigDecimal salary, String passwd, int onDuty)
	{
		super();
		this.salesmanNo = salesmanNo;
		this.salesmanName = salesmanName;
		this.sex = sex;
		this.birthday = birthday;
		this.telephone = telephone;
		this.hireDate = hireDate;
		this.storeNo = storeNo;
		this.salary = salary;
		this.passwd = passwd;
		this.onDuty = onDuty;
	}
	public Salesman()
	{
		super();
	}
    
}
