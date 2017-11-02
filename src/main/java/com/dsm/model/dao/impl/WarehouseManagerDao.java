package com.dsm.model.dao.impl;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.dsm.model.entity.WarehouseManager;
import com.dsm.model.utils.JDBCTools;

public class WarehouseManagerDao extends BaseDao<WarehouseManager>
{
	public BigDecimal getOutNum()
	{
		Connection connection;
		try {
			connection = JDBCTools.getConnection();
			String sql = "select sum(Salary) from WarehouseManager where OnDuty = 1";
			PreparedStatement pstmt = connection.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			BigDecimal a = rs.getBigDecimal(1);
			JDBCTools.releaseConnection(connection, pstmt, rs);
			return a;
		} catch (SQLException e) {
			return new BigDecimal(0);
		}
	}
	public void addObject(Object obj)
	{
		WarehouseManager WarehouseManager = (WarehouseManager) obj;
		String sql = "insert into WarehouseManager(WareManNo,WareManName,Sex,Birthday,Telephone,HireDate,WarehouseNo,Salary,Passwd,ManagerNo,OnDuty) values(?,?,?,?,?,?,?,?,?,?,?)";
		update(sql, WarehouseManager.getWarehouseno(),WarehouseManager.getWaremanname(),WarehouseManager.getSex(),
				WarehouseManager.getBirthday(),WarehouseManager.getTelephone(),WarehouseManager.getHiredate(),
				WarehouseManager.getWarehouseno(),WarehouseManager.getSalary(),WarehouseManager.getPasswd(),WarehouseManager.getManagerno(),
				WarehouseManager.getOnduty());
	}

	public void deleteObjectByKey(Object key)
	{
		String WarehouseNo = (String)key;
		String sql = "delete from Warehouse where WarehouseNo=?";
		update(sql, WarehouseNo);
	}

}
