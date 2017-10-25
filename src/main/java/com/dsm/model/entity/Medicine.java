package com.dsm.model.entity;


/*
鑽搧淇℃伅锛岀敤浜庝繚瀛樻墍鏈夎嵂鍝佺殑鍩烘湰淇℃伅
*/
public class Medicine
{
    private String medicineNo;          //鑽搧缂栧彿锛屼富閿紝闈炵┖
    private String medicineName;        //鑽搧鍚嶇О锛岄潪绌�
    private String category;            //鑽搧绫诲埆锛岄潪绌�
    private String factory;             //鐢熶骇鍘傚晢
    private String indication;          //閫傚簲鐥�
    private String storageCond;         //鍌ㄥ瓨鏉′欢
    private java.sql.Timestamp lifeTime;     //淇濊川鏈燂紝闈炵┖

    public String getMedicineno()
    {
        return medicineNo;
    }

    public void setMedicineno(String medicineNo)
    {
        this.medicineNo = medicineNo;
    }

    public String getMedicinename()
    {
        return medicineName;
    }

    public void setMedicinename(String medicineName)
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

    public String getStoragecond()
    {
        return storageCond;
    }

    public void setStoragecond(String storageCond)
    {
        this.storageCond = storageCond;
    }

    public java.sql.Timestamp getLifetime()
    {
        return lifeTime;
    }

    public void setLifetime(java.sql.Timestamp lifeTime)
    {
        this.lifeTime = lifeTime;
    }

    public Medicine(String medicineNo, String medicineName, String category, String factory, String indication, String storageCond, java.sql.Timestamp lifeTime)
    {

        this.medicineNo = medicineNo;
        this.medicineName = medicineName;
        this.category = category;
        this.factory = factory;
        this.indication = indication;
        this.storageCond = storageCond;
        this.lifeTime = lifeTime;
    }
    public Medicine()
    {
    	
    }
}
