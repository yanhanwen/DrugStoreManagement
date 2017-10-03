package com.dsm.model.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;

/*
销售信息，用于保存药品的销售记录信息
*/

public class Sale
{
    private String serialNo;        //流水号，主键
    private String medicineNo;      //药品编号，外键
    private String salesmanNo;      //售货员编号，外键
    private int count;              //数量
    private BigDecimal total;       //总价
    private Timestamp saleTime;     //销售时间

    public String getSerialNo()
    {
        return serialNo;
    }

    public void setSerialNo(String serialNo)
    {
        this.serialNo = serialNo;
    }

    public String getMedicineNo()
    {
        return medicineNo;
    }

    public void setMedicineNo(String medicineNo)
    {
        this.medicineNo = medicineNo;
    }

    public String getSalesmanNo()
    {
        return salesmanNo;
    }

    public void setSalesmanNo(String salesmanNo)
    {
        this.salesmanNo = salesmanNo;
    }

    public int getCount()
    {
        return count;
    }

    public void setCount(int count)
    {
        this.count = count;
    }

    public BigDecimal getTotal()
    {
        return total;
    }

    public void setTotal(BigDecimal total)
    {
        this.total = total;
    }

    public Timestamp getSaleTime()
    {
        return saleTime;
    }

    public void setSaleTime(Timestamp saleTime)
    {
        this.saleTime = saleTime;
    }

    public Sale(String serialNo, String medicineNo, String salesmanNo, int count, BigDecimal total, Timestamp saleTime)
    {

        this.serialNo = serialNo;
        this.medicineNo = medicineNo;
        this.salesmanNo = salesmanNo;
        this.count = count;
        this.total = total;
        this.saleTime = saleTime;
    }
}
