package com.dsm.model.entity;

import java.math.BigDecimal;
import java.sql.Date;

/*
库存信息，用于保存药品的库存信息
*/

public class Stock
{
    private String stockNo;         //库存编号，主键，默认与入库编号相同
    private String medicineNo;      //药品编号，外键
    private String warehouseNo;     //仓库编号，外键
    private String shelfNo;         //货架号
    private int count;              //数量
    private BigDecimal cost;        //单个进价
    private Date productDate;       //生产日期
    private Date validPeriod;       //有效期

    public String getStockNo()
    {
        return stockNo;
    }

    public void setStockNo(String stockNo)
    {
        this.stockNo = stockNo;
    }

    public String getMedicineNo()
    {
        return medicineNo;
    }

    public void setMedicineNo(String medicineNo)
    {
        this.medicineNo = medicineNo;
    }

    public String getWarehouseNo()
    {
        return warehouseNo;
    }

    public void setWarehouseNo(String warehouseNo)
    {
        this.warehouseNo = warehouseNo;
    }

    public String getShelfNo()
    {
        return shelfNo;
    }

    public void setShelfNo(String shelfNo)
    {
        this.shelfNo = shelfNo;
    }

    public int getCount()
    {
        return count;
    }

    public void setCount(int count)
    {
        this.count = count;
    }

    public BigDecimal getCost()
    {
        return cost;
    }

    public void setCost(BigDecimal cost)
    {
        this.cost = cost;
    }

    public Date getProductDate()
    {
        return productDate;
    }

    public void setProductDate(Date productDate)
    {
        this.productDate = productDate;
    }

    public Date getValidPeriod()
    {
        return validPeriod;
    }

    public void setValidPeriod(Date validPeriod)
    {
        this.validPeriod = validPeriod;
    }

    public Stock(String stockNo, String medicineNo, String warehouseNo, String shelfNo, int count, BigDecimal cost, Date productDate, Date validPeriod)
    {

        this.stockNo = stockNo;
        this.medicineNo = medicineNo;
        this.warehouseNo = warehouseNo;
        this.shelfNo = shelfNo;
        this.count = count;
        this.cost = cost;
        this.productDate = productDate;
        this.validPeriod = validPeriod;
    }
}
