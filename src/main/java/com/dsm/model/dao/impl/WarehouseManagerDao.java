package com.dsm.model.dao.impl;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.dsm.model.entity.Salesman;
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
			return rs.getBigDecimal(1);
		} catch (SQLException e) {
			return new BigDecimal(-1);
		}
	}
	public void addObject(Object obj)
	{
		WarehouseManager WarehouseManager = (WarehouseManager) obj;
		String sql = "insert into WarehouseManager(WareManNo,WareManName,Sex,Birthday,Age,Telephone,HireDate,WarehouseNo,Salary,Passwd,ManagerNo,OnDuty,Icon) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		update(sql, WarehouseManager.getWarehouseNo(),WarehouseManager.getWareManName(),WarehouseManager.getSex(),
				WarehouseManager.getBirthday(),WarehouseManager.getAge(),WarehouseManager.getTelephone(),WarehouseManager.getHireDate(),
				WarehouseManager.getWarehouseNo(),WarehouseManager.getSalary(),WarehouseManager.getPasswd(),WarehouseManager.getManagerNo(),
				WarehouseManager.getOnDuty(),WarehouseManager.getIcon());
	}

	public void deleteObjectByKey(Object key)
	{
		String WarehouseNo = (String)key;
		String sql = "delete from Warehouse where WarehouseNo=?";
		update(sql, WarehouseNo);
	}

}
