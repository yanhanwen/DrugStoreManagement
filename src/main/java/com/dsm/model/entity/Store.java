package com.dsm.model.entity;

import java.math.BigDecimal;
import java.sql.Date;

/*
店面信息，用于记录各个店面所有的基本信息
*/

public class Store
{
    private String storeNo;             //店面编号，主键
    private String storeName;           //店面名称
    private String province;            //省
    private String city;                //市
    private String district;            //区
    private String street;              //街道
    private String addrDetail;          //详细地址
    private String telephone;           //联系电话，非空
    private java.sql.Date openDate;     //开业日期
    private BigDecimal monthlyCost;     //月固定开销（房租，水电费等），非空
    private int isOpen;                 //是否营业，1：营业，0：已关闭

    public String getStoreNo()
    {
        return storeNo;
    }

    public void setStoreNo(String storeNo)
    {
        this.storeNo = storeNo;
    }

    public String getStoreName()
    {
        return storeName;
    }

    public void setStoreName(String storeName)
    {
        this.storeName = storeName;
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

    public String getTelephone()
    {
        return telephone;
    }

    public void setTelephone(String telephone)
    {
        this.telephone = telephone;
    }

    public Date getOpenDate()
    {
        return openDate;
    }

    public void setOpenDate(Date openDate)
    {
        this.openDate = openDate;
    }

    public BigDecimal getMonthlyCost()
    {
        return monthlyCost;
    }

    public void setMonthlyCost(BigDecimal monthlyCost)
    {
        this.monthlyCost = monthlyCost;
    }

    public int getIsOpen()
    {
        return isOpen;
    }

    public void setIsOpen(int isOpen)
    {
        this.isOpen = isOpen;
    }

    public Store(String storeNo, String storeName, String province, String city, String district, String street, String addrDetail, String telephone, Date openDate, BigDecimal monthlyCost, int isOpen)
    {

        this.storeNo = storeNo;
        this.storeName = storeName;
        this.province = province;
        this.city = city;
        this.district = district;
        this.street = street;
        this.addrDetail = addrDetail;
        this.telephone = telephone;
        this.openDate = openDate;
        this.monthlyCost = monthlyCost;
        this.isOpen = isOpen;
    }
}
