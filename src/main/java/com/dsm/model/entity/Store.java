package com.dsm.model.entity;

import java.math.BigDecimal;
import java.sql.Date;

/*
搴楅潰淇℃伅锛岀敤浜庤褰曞悇涓簵闈㈡墍鏈夌殑鍩烘湰淇℃伅
*/

public class Store
{
    private String storeNo;             //搴楅潰缂栧彿锛屼富閿�
    private String storeName;           //搴楅潰鍚嶇О
    private String province;            //鐪�
    private String city;                //甯�
    private String district;            //鍖�
    private String street;              //琛楅亾
    private String addrDetail;          //璇︾粏鍦板潃
    private String telephone;           //鑱旂郴鐢佃瘽锛岄潪绌�
    private java.sql.Date openDate;     //寮�涓氭棩鏈�
    private BigDecimal monthlyCost;     //鏈堝浐瀹氬紑閿�锛堟埧绉燂紝姘寸數璐圭瓑锛夛紝闈炵┖
    private int isOpen;                 //鏄惁钀ヤ笟锛�1锛氳惀涓氾紝0锛氬凡鍏抽棴

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
    public Store()
    {
    	
    }
}
