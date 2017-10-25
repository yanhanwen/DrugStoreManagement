package com.dsm.model.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;

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
    private java.sql.Timestamp productDate;          //鐢熶骇鏃ユ湡
    private BigDecimal cost;                    //鍗曚釜杩涗环
    private String wareManNo;                   //鎵ц鎿嶄綔鐨勪粨搴撶鐞嗗憳缂栧彿锛屽閿�

    public String getEnterno()
    {
        return enterNo;
    }

    public void setEnterno(String enterNo)
    {
        this.enterNo = enterNo;
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

    public String getSupplierno()
    {
        return supplierNo;
    }

    public void setSupplierno(String supplierNo)
    {
        this.supplierNo = supplierNo;
    }

    public int getEntercount()
    {
        return enterCount;
    }

    public void setEntercount(int enterCount)
    {
        this.enterCount = enterCount;
    }

    public Timestamp getEntertime()
    {
        return enterTime;
    }

    public void setEntertime(Timestamp enterTime)
    {
        this.enterTime = enterTime;
    }

    public java.sql.Timestamp getProductdate()
    {
        return productDate;
    }

    public void setProductdate(java.sql.Timestamp productDate)
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

    public String getWaremanno()
    {
        return wareManNo;
    }

    public void setWaremanno(String wareManNo)
    {
        this.wareManNo = wareManNo;
    }

    public EnterWare(String enterNo, String medicineNo, String warehouseNo, String supplierNo, int enterCount, Timestamp enterTime, java.sql.Timestamp productDate, BigDecimal cost, String wareManNo)
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
