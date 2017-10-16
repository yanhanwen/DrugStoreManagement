package com.dsm.model.entity;

import java.math.BigDecimal;
import java.sql.Date;

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
    private Date validPeriod;       //鏈夋晥鏈�
    private int frameNo;            //鍞灦鍙�
    
    public String getOnSaleNo() {
		return OnSaleNo;
	}
	public void setOnSaleNo(String onSaleNo) {
		OnSaleNo = onSaleNo;
	}
    public String getMedicineNo()
    {
        return medicineNo;
    }

    public void setMedicineNo(String medicineNo)
    {
        this.medicineNo = medicineNo;
    }

    public String getStoreNo()
    {
        return storeNo;
    }

    public void setStoreNo(String storeNo)
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

    public Date getValidPeriod()
    {
        return validPeriod;
    }

    public void setValidPeriod(Date validPeriod)
    {
        this.validPeriod = validPeriod;
    }

    public int getFrameNo()
    {
        return frameNo;
    }

    public void setFrameNo(int frameNo)
    {
        this.frameNo = frameNo;
    }

    public OnSale(String medicineNo, String storeNo, int count, BigDecimal price, BigDecimal cost, Date validPeriod, int frameNo)
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
