package com.dsm.model.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.sql.Date;

/*
药品入库信息，用于记录每条入库信息
*/
public class EnterWare
{
    private String enterNo;                     //入库编号，主键
    private String medicineNo;                  //药品编号，外键
    private String warehouseNo;                 //仓库编号，外键
    private String supplierNo;                  //供应商编号，外键
    private int enterCount;                     //入库数量，大于0
    private java.sql.Timestamp enterTime;       //入库时间
    private java.sql.Date productDate;          //生产日期
    private BigDecimal cost;                    //单个进价
    private String wareManNo;                   //执行操作的仓库管理员编号，外键

    public String getEnterNo()
    {
        return enterNo;
    }

    public void setEnterNo(String enterNo)
    {
        this.enterNo = enterNo;
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

    public String getSupplierNo()
    {
        return supplierNo;
    }

    public void setSupplierNo(String supplierNo)
    {
        this.supplierNo = supplierNo;
    }

    public int getEnterCount()
    {
        return enterCount;
    }

    public void setEnterCount(int enterCount)
    {
        this.enterCount = enterCount;
    }

    public Timestamp getEnterTime()
    {
        return enterTime;
    }

    public void setEnterTime(Timestamp enterTime)
    {
        this.enterTime = enterTime;
    }

    public Date getProductDate()
    {
        return productDate;
    }

    public void setProductDate(Date productDate)
    {
        this.productDate = productDate;
    }

    public BigDecimal getCost()
    {
        return cost;
    }

    public void setCost(BigDecimal cost)
    {
        this.cost = cost;
    }

    public String getWareManNo()
    {
        return wareManNo;
    }

    public void setWareManNo(String wareManNo)
    {
        this.wareManNo = wareManNo;
    }

    public EnterWare(String enterNo, String medicineNo, String warehouseNo, String supplierNo, int enterCount, Timestamp enterTime, Date productDate, BigDecimal cost, String wareManNo)
    {

        this.enterNo = enterNo;
        this.medicineNo = medicineNo;
        this.warehouseNo = warehouseNo;
        this.supplierNo = supplierNo;
        this.enterCount = enterCount;
        this.enterTime = enterTime;
        this.productDate = productDate;
        this.cost = cost;
        this.wareManNo = wareManNo;
    }
}
