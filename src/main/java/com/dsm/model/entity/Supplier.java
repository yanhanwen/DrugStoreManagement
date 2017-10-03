package com.dsm.model.entity;

import java.sql.Date;

/*
供应商信息，用于记录各个供应商所有的信息
*/

public class Supplier
{
    private String supplierNo;          //供应商编号，主键
    private String supplierName;        //供应商名称
    private String contactName;         //联系人姓名
    private String telephone;           //联系电话
    private String province;            //省
    private String city;                //市
    private String district;            //区
    private String street;              //街道
    private String addrDetail;          //地址详情
    private float rate;                 //评级，0~5，一位小数
    private java.sql.Date addDate;      //添加日期
    private String remark;              //备注
    private int onDuty;                 //是否可选，1：可选，0：不可选

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
}
