package com.dsm.model.dao.impl;

import com.dsm.model.entity.OnSale;

public class OnSaleDao extends BaseDao<OnSale>
{
	public void addOnSaleNum(Object onSaleNo, Object saleNum)
	{
		String OnSaleNo = (String)onSaleNo;
		String OnSaleNum = (String)saleNum;
		String sql = "update OnSale set count=count+? where OnSaleNo=?";
		update(sql,OnSaleNum, OnSaleNo);
	}
	public void reduceOnSaleNum(Object onSaleNo, Object saleNum)
	{
		String OnSaleNo = (String)onSaleNo;
		String OnSaleNum = (String)saleNum;
		String sql = "update OnSale set count=count-? where OnSaleNo=?";
		update(sql,OnSaleNum, OnSaleNo);
	}
	public void addObject(Object obj)
	{
		OnSale OnSale= (OnSale) obj;
		String sql = "insert into OnSale(MedicineNo,StoreNo,Count,Price,Cost,ValidPeriod,FrameNo) values(?,?,?,?,?,?,?)";
		update(sql,OnSale.getMedicineNo(),OnSale.getStoreNo(),OnSale.getCount(),OnSale.getPrice(),OnSale.getCost(),OnSale.getValidPeriod(),
				OnSale.getFrameNo());
	}
	public void deleteObjectByKey(Object key)
	{
		String OnSaleNo = (String)key;
		String sql = "delete from OnSale where OnSaleNo=?";
		update(sql, OnSaleNo);
	}
}
