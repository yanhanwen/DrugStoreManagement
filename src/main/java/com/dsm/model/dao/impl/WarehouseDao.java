package com.dsm.model.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;

import com.dsm.model.entity.Warehouse;
import com.dsm.model.utils.JDBCTools;

public class WarehouseDao extends BaseDao<Warehouse>
{
	public int getOutNum() throws SQLException
	{
		Connection connection = JDBCTools.getConnection();
		String sql = "select sum(MonthlyCost) from Warehouse";
		return 0;
	}
	public void addObject(Object obj)
	{
		
	}
	public void deleteObjectByKey(Object key)
	{
		
	}
}
