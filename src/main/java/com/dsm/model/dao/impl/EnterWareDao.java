package com.dsm.model.dao.impl;

import com.dsm.model.entity.EnterWare;
public class EnterWareDao extends BaseDao<EnterWare>
{
	public void addObject(Object obj)
	{
		EnterWare EnterWare = (EnterWare) obj;
		String sql = "insert into EnterWare(EnterNo,MedicineNo,WarehouseNo,SupplierNo,EnterCount,EnterTime,ProductDate,Cost,WareManNo) values(?,?,?,?,?,?,?,?,?)";
		update(sql,EnterWare.getEnterNo(),EnterWare.getMedicineNo(),EnterWare.getWarehouseNo(),EnterWare.getSupplierNo(),
				EnterWare.getEnterCount(),EnterWare.getEnterTime(),EnterWare.getProductDate(),EnterWare.getCost(),EnterWare.getWareManNo());
	}
	public void deleteObjectByKey(Object key)
	{
		String EnterNo = (String)key;
		String sql = "delete from EnterWare where EnterNo=?";
		update(sql, EnterNo);
	}
}
