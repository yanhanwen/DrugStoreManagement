package com.dsm.model.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;

/*
药品出库信息，用于记录每条出库信息
*/
public class LeaveWare
{
    private String leaveNo;                 //出库号，主键
    private String medicineNo;              //药品编号，外键
    private String warehouseNo;             //仓库编号，外键
    private String storeNo;                 //店面编号，外键
    private BigDecimal cost;                //单个进价
    private String enterNo;                 //入库编号
    private int leaveCount;                 //出库数量
    private java.sql.Timestamp leaveTime;   //出库时间
    private String wareManNo;               //执行操作的仓库管理员编号

    public String getLeaveNo()
    {
        return leaveNo;
    }

    public void setLeaveNo(String leaveNo)
    {
        this.leaveNo = leaveNo;
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

    public String getStoreNo()
    {
        return storeNo;
    }

    public void setStoreNo(String storeNo)
    {
        this.storeNo = storeNo;
    }

    public BigDecimal getCost()
    {
        return cost;
    }

    public void setCost(BigDecimal cost)
    {
        this.cost = cost;
    }

    public String getEnterNo()
    {
        return enterNo;
    }

    public void setEnterNo(String enterNo)
    {
        this.enterNo = enterNo;
    }

    public int getLeaveCount()
    {
        return leaveCount;
    }

    public void setLeaveCount(int leaveCount)
    {
        this.leaveCount = leaveCount;
    }

    public Timestamp getLeaveTime()
    {
        return leaveTime;
    }

    public void setLeaveTime(Timestamp leaveTime)
    {
        this.leaveTime = leaveTime;
    }

    public String getWareManNo()
    {
        return wareManNo;
    }

    public void setWareManNo(String wareManNo)
    {
        this.wareManNo = wareManNo;
    }

    public LeaveWare(String leaveNo, String medicineNo, String warehouseNo, String storeNo, BigDecimal cost, String enterNo, int leaveCount, Timestamp leaveTime, String wareManNo)
    {

        this.leaveNo = leaveNo;
        this.medicineNo = medicineNo;
        this.warehouseNo = warehouseNo;
        this.storeNo = storeNo;
        this.cost = cost;
        this.enterNo = enterNo;
        this.leaveCount = leaveCount;
        this.leaveTime = leaveTime;
        this.wareManNo = wareManNo;
    }
}
