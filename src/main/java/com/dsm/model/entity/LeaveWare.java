package com.dsm.model.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;

/*
鑽搧鍑哄簱淇℃伅锛岀敤浜庤褰曟瘡鏉″嚭搴撲俊鎭�
*/
public class LeaveWare
{
    private String leaveNo;                 //鍑哄簱鍙凤紝涓婚敭
    private String medicineNo;              //鑽搧缂栧彿锛屽閿�
    private String warehouseNo;             //浠撳簱缂栧彿锛屽閿�
    private String storeNo;                 //搴楅潰缂栧彿锛屽閿�
    private BigDecimal cost;                //鍗曚釜杩涗环
    private BigDecimal leaveCount;                 //鍑哄簱鏁伴噺
    private java.sql.Timestamp leaveTime;   //鍑哄簱鏃堕棿
    private String wareManNo;               //鎵ц鎿嶄綔鐨勪粨搴撶鐞嗗憳缂栧彿

    public String getLeaveno()
    {
        return leaveNo;
    }

    public void setLeaveno(String leaveNo)
    {
        this.leaveNo = leaveNo;
    }

    public String getMedicineno()
    {
        return medicineNo;
    }

    public void setMedicineno(String medicineNo)
    {
        this.medicineNo = medicineNo;
    }

    public String getWarehouseno()
    {
        return warehouseNo;
    }

    public void setWarehouseno(String warehouseNo)
    {
        this.warehouseNo = warehouseNo;
    }

    public String getStoreno()
    {
        return storeNo;
    }

    public void setStoreno(String storeNo)
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

    public BigDecimal getLeavecount()
    {
        return leaveCount;
    }

    public void setLeavecount(BigDecimal leaveCount)
    {
        this.leaveCount = leaveCount;
    }

    public Timestamp getLeavetime()
    {
        return leaveTime;
    }

    public void setLeavetime(Timestamp leaveTime)
    {
        this.leaveTime = leaveTime;
    }

    public String getWaremanno()
    {
        return wareManNo;
    }

    public void setWaremanno(String wareManNo)
    {
        this.wareManNo = wareManNo;
    }

    public LeaveWare(String leaveNo, String medicineNo, String warehouseNo, String storeNo, BigDecimal cost, BigDecimal leaveCount, Timestamp leaveTime, String wareManNo)
    {

        this.leaveNo = leaveNo;
        this.medicineNo = medicineNo;
        this.warehouseNo = warehouseNo;
        this.storeNo = storeNo;
        this.cost = cost;
        this.leaveCount = leaveCount;
        this.leaveTime = leaveTime;
        this.wareManNo = wareManNo;
    }
    public LeaveWare()
    {
    }
}
