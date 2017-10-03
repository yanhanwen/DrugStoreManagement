package com.dsm.model.entity;

import java.math.BigDecimal;

/*
仓库信息，用于保存仓库的所有基本信息
*/
public class Warehouse
{
    private String warehouseNo;         //仓库编号，主键，非空
    private String warehouseName;       //仓库名称，非空
    private String province;            //所在省份
    private String city;                //城市
    private String districi;            //区
    private String street;              //接到
    private String addrDetail;          //详细地址
    private BigDecimal monthlyCost;            //月固定开销（水电费，维修费等），非空

    public String getWarehouseNo()
    {
        return warehouseNo;
    }

    public void setWarehouseNo(String warehouseNo)
    {
        this.warehouseNo = warehouseNo;
    }

    public String getWarehouseName()
    {
        return warehouseName;
    }

    public void setWarehouseName(String warehouseName)
    {
        this.warehouseName = warehouseName;
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

    public String getDistrici()
    {
        return districi;
    }

    public void setDistrici(String districi)
    {
        this.districi = districi;
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

    public BigDecimal getMonthlyCost()
    {
        return monthlyCost;
    }

    public void setMonthlyCost(BigDecimal monthlyCost)
    {
        this.monthlyCost = monthlyCost;
    }

    public Warehouse(String warehouseNo, String warehouseName, String province, String city, String districi, String street, String addrDetail, BigDecimal monthlyCost)
    {
        this.warehouseNo = warehouseNo;
        this.warehouseName = warehouseName;
        this.province = province;
        this.city = city;
        this.districi = districi;
        this.street = street;
        this.addrDetail = addrDetail;
        this.monthlyCost = monthlyCost;
    }
}
