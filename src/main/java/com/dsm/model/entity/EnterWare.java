package com.dsm.model.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.sql.Date;

/*
鑽搧鍏ュ簱淇℃伅锛岀敤浜庤褰曟瘡鏉″叆搴撲俊鎭�
*/
public class EnterWare
{
    private String enterNo;                     //鍏ュ簱缂栧彿锛屼富閿�
    private String medicineNo;                  //鑽搧缂栧彿锛屽閿�
    private String warehouseNo;                 //浠撳簱缂栧彿锛屽閿�
    private String supplierNo;                  //渚涘簲鍟嗙紪鍙凤紝澶栭敭
    private int enterCount;                     //鍏ュ簱鏁伴噺锛屽ぇ浜�0
    private java.sql.Timestamp enterTime;       //鍏ュ簱鏃堕棿
    private java.sql.Date productDate;          //鐢熶骇鏃ユ湡
    private BigDecimal cost;                    //鍗曚釜杩涗环
    private String wareManNo;                   //鎵ц鎿嶄綔鐨勪粨搴撶鐞嗗憳缂栧彿锛屽閿�

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
    public EnterWare()
    {
    	
    }
}
