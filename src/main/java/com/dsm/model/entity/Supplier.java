package com.dsm.model.entity;

import java.sql.Date;

/*
渚涘簲鍟嗕俊鎭紝鐢ㄤ簬璁板綍鍚勪釜渚涘簲鍟嗘墍鏈夌殑淇℃伅
*/

public class Supplier
{
    private String supplierNo;          //渚涘簲鍟嗙紪鍙凤紝涓婚敭
    private String supplierName;        //渚涘簲鍟嗗悕绉�
    private String contactName;         //鑱旂郴浜哄鍚�
    private String telephone;           //鑱旂郴鐢佃瘽
    private String province;            //鐪�
    private String city;                //甯�
    private String district;            //鍖�
    private String street;              //琛楅亾
    private String addrDetail;          //鍦板潃璇︽儏
    private float rate;                 //璇勭骇锛�0~5锛屼竴浣嶅皬鏁�
    private java.sql.Date addDate;      //娣诲姞鏃ユ湡
    private String remark;              //澶囨敞
    private int onDuty;                 //鏄惁鍙�夛紝1锛氬彲閫夛紝0锛氫笉鍙��

    public String getSupplierNo()
    {
        return supplierNo;
    }

    public void setSupplierNo(String supplierNo)
    {
        this.supplierNo = supplierNo;
    }

    public String getSupplierName()
    {
        return supplierName;
    }

    public void setSupplierName(String supplierName)
    {
        this.supplierName = supplierName;
    }

    public String getContactName()
    {
        return contactName;
    }

    public void setContactName(String contactName)
    {
        this.contactName = contactName;
    }

    public String getTelephone()
    {
        return telephone;
    }

    public void setTelephone(String telephone)
    {
        this.telephone = telephone;
    }

    public String getProvince()
    {
        return province;
    }

    public void setProvince(String province)
    {
        this.province = province;
    }

    public String getCity()
    {
        return city;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public String getDistrict()
    {
        return district;
    }

    public void setDistrict(String district)
    {
        this.district = district;
    }

    public String getStreet()
    {
        return street;
    }

    public void setStreet(String street)
    {
        this.street = street;
    }

    public String getAddrDetail()
    {
        return addrDetail;
    }

    public void setAddrDetail(String addrDetail)
    {
        this.addrDetail = addrDetail;
    }

    public float getRate()
    {
        return rate;
    }

    public void setRate(float rate)
    {
        this.rate = rate;
    }

    public Date getAddDate()
    {
        return addDate;
    }

    public void setAddDate(Date addDate)
    {
        this.addDate = addDate;
    }

    public String getRemark()
    {
        return remark;
    }

    public void setRemark(String remark)
    {
        this.remark = remark;
    }

    public int getOnDuty()
    {
        return onDuty;
    }

    public void setOnDuty(int onDuty)
    {
        this.onDuty = onDuty;
    }

    public Supplier(String supplierNo, String supplierName, String contactName, String telephone, String province, String city, String district, String street, String addrDetail, float rate, Date addDate, String remark, int onDuty)
    {

        this.supplierNo = supplierNo;
        this.supplierName = supplierName;
        this.contactName = contactName;
        this.telephone = telephone;
        this.province = province;
        this.city = city;
        this.district = district;
        this.street = street;
        this.addrDetail = addrDetail;
        this.rate = rate;
        this.addDate = addDate;
        this.remark = remark;
        this.onDuty = onDuty;
    }
    public Supplier()
    {
    	
    }
}
