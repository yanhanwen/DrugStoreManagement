package com.dsm.model.entity;

import java.math.BigDecimal;

/*
鍦ㄥ敭淇℃伅锛岀敤浜庝繚瀛樺湪鍞灦涓婄殑鑽搧鐨勪俊鎭�
*/

public class OnSale
{
	private String OnSaleNo;		//鍦ㄥ敭缂栧彿
	private String medicineNo;      //鑽搧缂栧彿锛屽閿�
    private String storeNo;         //搴楅潰缂栧彿锛屽閿�
    private int count;              //鍦ㄥ敭鏁伴噺
    private BigDecimal price;       //鍞环
    private BigDecimal cost;        //杩涗环
    private java.sql.Timestamp validPeriod;       //鏈夋晥鏈�
    private int frameNo;            //鍞灦鍙�
    
    public String getOnsaleno() {
		return OnSaleNo;
	}
	public void setOnsaleno(String onSaleNo) {
		OnSaleNo = onSaleNo;
	}
    public String getMedicineno()
    {
        return medicineNo;
    }

    public void setMedicineno(String medicineNo)
    {
        this.medicineNo = medicineNo;
    }

    public String getStoreno()
    {
        return storeNo;
    }

    public void setStoreno(String storeNo)
    {
        this.storeNo = storeNo;
    }

    public int getCount()
    {
        return count;
    }

    public void setCount(int count)
    {
        this.count = count;
    }

    public BigDecimal getPrice()
    {
        return price;
    }

    public void setPrice(BigDecimal price)
    {
        this.price = price;
    }

    public BigDecimal getCost()
    {
        return cost;
    }

    public void setCost(BigDecimal cost)
    {
        this.cost = cost;
    }

    public java.sql.Timestamp getValidperiod()
    {
        return validPeriod;
    }

    public void setValidperiod(java.sql.Timestamp validPeriod)
    {
        this.validPeriod = validPeriod;
    }

    public int getFrameno()
    {
        return frameNo;
    }

    public void setFrameno(int frameNo)
    {
        this.frameNo = frameNo;
    }

    public OnSale(String medicineNo, String storeNo, int count, BigDecimal price, BigDecimal cost, java.sql.Timestamp validPeriod, int frameNo)
    {

        this.medicineNo = medicineNo;
        this.storeNo = storeNo;
        this.count = count;
        this.price = price;
        this.cost = cost;
        this.validPeriod = validPeriod;
        this.frameNo = frameNo;
    }
    public OnSale()
    {
    	
    }
}
