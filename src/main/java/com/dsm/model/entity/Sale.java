package com.dsm.model.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;

/*
閿�鍞俊鎭紝鐢ㄤ簬淇濆瓨鑽搧鐨勯攢鍞褰曚俊鎭�
*/

public class Sale
{
    private String serialNo;        //娴佹按鍙凤紝涓婚敭
    private String medicineNo;      //鑽搧缂栧彿锛屽閿�
    private String salesmanNo;      //鍞揣鍛樼紪鍙凤紝澶栭敭
    private int count;              //鏁伴噺
    private BigDecimal total;       //鎬讳环
    private Timestamp saleTime;     //閿�鍞椂闂�

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
    public Sale()
    {
    	
    }
}
