package com.dsm.model.entity;

import java.math.BigDecimal;

/*
浠撳簱淇℃伅锛岀敤浜庝繚瀛樹粨搴撶殑鎵�鏈夊熀鏈俊鎭�
*/
public class Warehouse
{
    private String warehouseNo;         //浠撳簱缂栧彿锛屼富閿紝闈炵┖
    private String warehouseName;       //浠撳簱鍚嶇О锛岄潪绌�
    private String province;            //鎵�鍦ㄧ渷浠�
    private String city;                //鍩庡競
    private String districi;            //鍖�
    private String street;              //鎺ュ埌
    private String addrDetail;          //璇︾粏鍦板潃
    private BigDecimal monthlyCost;            //鏈堝浐瀹氬紑閿�锛堟按鐢佃垂锛岀淮淇垂绛夛級锛岄潪绌�

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
    public Warehouse()
    {
    	
    }
}
