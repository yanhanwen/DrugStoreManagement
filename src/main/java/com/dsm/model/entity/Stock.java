package com.dsm.model.entity;

import java.math.BigDecimal;
import java.sql.Date;

/*
搴撳瓨淇℃伅锛岀敤浜庝繚瀛樿嵂鍝佺殑搴撳瓨淇℃伅
*/

public class Stock
{
    private String stockNo;         //搴撳瓨缂栧彿锛屼富閿紝榛樿涓庡叆搴撶紪鍙风浉鍚�
    private String medicineNo;      //鑽搧缂栧彿锛屽閿�
    private String warehouseNo;     //浠撳簱缂栧彿锛屽閿�
    private String shelfNo;         //璐ф灦鍙�
    private int count;              //鏁伴噺
    private BigDecimal cost;        //鍗曚釜杩涗环
    private Date productDate;       //鐢熶骇鏃ユ湡
    private Date validPeriod;       //鏈夋晥鏈�

    public String getStockno()
    {
        return stockNo;
    }

    public void setStockno(String stockNo)
    {
        this.stockNo = stockNo;
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

    public String getShelfno()
    {
        return shelfNo;
    }

    public void setShelfno(String shelfNo)
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

    public Date getProductdate()
    {
        return productDate;
    }

    public void setProductdate(Date productDate)
    {
        this.productDate = productDate;
    }

    public Date getValidperiod()
    {
        return validPeriod;
    }

    public void setValidperiod(Date validPeriod)
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
    public Stock()
    {
    	
    }
}
