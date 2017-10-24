package com.dsm.model.dao.impl;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.dsm.model.entity.Warehouse;
import com.dsm.model.utils.JDBCTools;

public class WarehouseDao extends BaseDao<Warehouse>
{
	public BigDecimal getOutNum()
	{
		Connection connection;
		try {
			connection = JDBCTools.getConnection();
			String sql = "select sum(MonthlyCost) from Warehouse";
			PreparedStatement pstmt = connection.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			return rs.getBigDecimal(1);
		} catch (SQLException e) {
			return new BigDecimal(-1);
		}
	}
	public void addObject(Object obj)
	{
		Warehouse Warehouse = (Warehouse) obj;
		String sql = "insert into Warehouse(WarehouseNo,WarehouseName,Province,City,District,Street,AddrDetail,MonthlyCost) values(?,?,?,?,?,?,?,?)";
		update(sql,Warehouse.getWarehouseno(),Warehouse.getWarehousename(),Warehouse.getProvince(),Warehouse.getCity(),
				Warehouse.getDistrici(),Warehouse.getStreet(),Warehouse.getAddrdetail(),Warehouse.getMonthlycost());
	}
	public void deleteObjectByKey(Object key)
	{
		String WarehouseNo = (String)key;
		String sql = "delete from Warehouse where WarehouseNo=?";
		update(sql, WarehouseNo);
	}
}
