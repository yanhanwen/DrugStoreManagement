package com.dsm.model.dao.impl;

import java.math.BigDecimal;

import com.dsm.model.entity.OnSale;

public class OnSaleDao extends BaseDao<OnSale> {
	String key;

	public void addOnSaleNum(Object onSaleNo, Object saleNum) {
		String OnSaleNo = (String) onSaleNo;
		String OnSaleNum = (String) saleNum;
		String sql = "update OnSale set count=count+? where OnSaleNo=?";
		String key = update(sql, OnSaleNum, OnSaleNo);
		this.key = key;
	}

	public void reduceOnSaleNum(Object onSaleNo, Object saleNum) {
		String OnSaleNo = (String) onSaleNo;
		BigDecimal OnSaleNum = (BigDecimal) saleNum;
		String sql = "update ONSALE set count=count-" + saleNum + "WHERE ONSALENO=?";
		update(sql, OnSaleNo);
	}

	public void addObject(Object obj) {
		OnSale OnSale = (OnSale) obj;
		String sql = "insert into OnSale(OnSaleNo,MedicineNo,StoreNo,Count,Price,Cost,ValidPeriod,FrameNo) values(?,?,?,?,?,?,?,?)";
		update(sql, OnSale.getOnsaleno(), OnSale.getMedicineno(), OnSale.getStoreno(), OnSale.getCount(),
				OnSale.getPrice(), OnSale.getCost(), OnSale.getValidperiod(), OnSale.getFrameno());
		this.key = key;
	}

	public void deleteObjectByKey(Object key) {
		String OnSaleNo = (String) key;
		String sql = "delete from OnSale where OnSaleNo=?";
		update(sql, OnSaleNo);
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
	
	
}
