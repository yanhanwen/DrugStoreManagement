package com.dsm.model.dao.impl;

import com.dsm.model.entity.Sale;

public class SaleDao extends BaseDao<Sale>
{
	public void addObject(Object obj)
	{
		Sale Sale= (Sale) obj;
		String sql = "insert into Sale(SerialNo,MedicineNo,SalesmanNo,Count,Total,SaleTime) values(?,?,?,?,?,?)";
		update(sql,Sale.getSerialno(),Sale.getMedicineno(),Sale.getSalesmanno(),Sale.getCount(),Sale.getTotal(),Sale.getSaletime());
	}
	public void deleteObjectByKey(Object key)
	{
		String SerialNo = (String)key;
		String sql = "delete from Sale where SerialNo=?";
		update(sql, SerialNo);
	}
}
