package com.dsm.model.entity;

import java.sql.Date;

/*
药品信息，用于保存所有药品的基本信息
*/
public class Medicine
{
    private String medicineNo;          //药品编号，主键，非空
    private String medicineName;        //药品名称，非空
    private String category;            //药品类别，非空
    private String factory;             //生产厂商
    private String indication;          //适应症
    private String storageCond;         //储存条件
    private java.sql.Date lifeTime;     //保质期，非空

    public String getMedicineNo()
    {
        return medicineNo;
    }

    public void setMedicineNo(String medicineNo)
    {
        this.medicineNo = medicineNo;
    }

    public String getMedicineName()
    {
        return medicineName;
    }

    public void setMedicineName(String medicineName)
    {
        this.medicineName = medicineName;
    }

    public String getCategory()
    {
        return category;
    }

    public void setCategory(String category)
    {
        this.category = category;
    }

    public String getFactory()
    {
        return factory;
    }

    public void setFactory(String factory)
    {
        this.factory = factory;
    }

    public String getIndication()
    {
        return indication;
    }

    public void setIndication(String indication)
    {
        this.indication = indication;
    }

    public String getStorageCond()
    {
        return storageCond;
    }

    public void setStorageCond(String storageCond)
    {
        this.storageCond = storageCond;
    }

    public Date getLifeTime()
    {
        return lifeTime;
    }

    public void setLifeTime(Date lifeTime)
    {
        this.lifeTime = lifeTime;
    }

    public Medicine(String medicineNo, String medicineName, String category, String factory, String indication, String storageCond, Date lifeTime)
    {

        this.medicineNo = medicineNo;
        this.medicineName = medicineName;
        this.category = category;
        this.factory = factory;
        this.indication = indication;
        this.storageCond = storageCond;
        this.lifeTime = lifeTime;
    }
}
