package com.dsm.model.entity;

import java.math.BigDecimal;
import java.sql.Date;

/*
在售信息，用于保存在售架上的药品的信息
*/

public class OnSale
{
	private String OnSaleNo;		//在售编号
	private String medicineNo;      //药品编号，外键
    private String storeNo;         //店面编号，外键
    private int count;              //在售数量
    private BigDecimal price;       //售价
    private BigDecimal cost;        //进价
    private Date validPeriod;       //有效期
    private int frameNo;            //售架号
    
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
}
