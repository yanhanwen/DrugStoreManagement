package com.dsm.model.entity;

import java.math.BigDecimal;
import java.sql.Blob;
import java.sql.Timestamp;

/*
搴楀憳淇℃伅锛岀敤浜庤褰曞敭璐у憳鐨勫熀鏈俊鎭�
*/

public class Salesman
{
    private String salesmanNo;              //鍞揣鍛樼紪鍙凤紝涓婚敭
    private String salesmanName;            //鍞揣鍛樺鍚�
    private String sex;                     //鎬у埆
    private java.sql.Timestamp birthday;         //鍑虹敓鏃ユ湡
    private String telephone;               //鑱旂郴鐢佃瘽
    private java.sql.Timestamp hireDate;                  //灏辫亴鏃ユ湡
    private String storeNo;                 //灏辫亴搴楅潰缂栧彿锛屽閿�
    private BigDecimal salary;              //鏈堣柂
    private String passwd;                  //鐧诲綍瀵嗙爜
    private BigDecimal onDuty;                     //鏄惁鍦ㄨ亴锛�1锛氬湪鑱岋紝0锛氱鑱�
    private Blob icon;                      //澶村儚
	public String getSalesmanno()
	{
		return salesmanNo;
	}
	public void setSalesmanno(String salesmanNo)
	{
		this.salesmanNo = salesmanNo;
	}
	public String getSalesmanname()
	{
		return salesmanName;
	}
	public void setSalesmanname(String salesmanName)
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
	public Salesman(String salesmanNo, String salesmanName, String sex, java.sql.Timestamp birthday, String telephone, java.sql.Timestamp hireDate,
			String storeNo, BigDecimal salary, String passwd, BigDecimal onDuty)
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
	public String[] getColumns()
    {
    	String cols[] = null;
    	cols = new String[9];
    	cols[0] = "编号";
    	cols[1] = "姓名";
    	cols[2] = "性别";
    	cols[3] = "出生日期";
    	cols[4] = "联系电话";
    	cols[5] = "就职日期";
    	cols[6] = "就职店面编号";
    	cols[7] = "月薪";
    	cols[8] = "登录密码";
    	return cols;
    }
    
}
