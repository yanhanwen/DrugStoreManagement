package com.dsm.model.dao.impl;

import com.dsm.model.entity.WarehouseEnvir;

public class WarehouseEnvirDao extends BaseDao<WarehouseEnvir>
{
	public void addObject(Object obj)
	{
		WarehouseEnvir WarehouseEnvir = (WarehouseEnvir) obj;
		String sql = "insert into WarehouseEnvir(WarehouseNo,Condition,Area) values(?,?,?)";
		update(sql,WarehouseEnvir.getWarehouseno(),WarehouseEnvir.getCondition(),WarehouseEnvir.getArea());
	}
	public void deleteObjectByKey(Object key)
	{
		String EnvirNo = (String)key;
		String sql = "delete from Warehouse where EnvirNo=?";
		update(sql, EnvirNo);
	}
}
