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
    private int leaveCount;                 //鍑哄簱鏁伴噺
    private java.sql.Timestamp leaveTime;   //鍑哄簱鏃堕棿
    private String wareManNo;               //鎵ц鎿嶄綔鐨勪粨搴撶鐞嗗憳缂栧彿

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

    public LeaveWare(String leaveNo, String medicineNo, String warehouseNo, String storeNo, BigDecimal cost, int leaveCount, Timestamp leaveTime, String wareManNo)
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
