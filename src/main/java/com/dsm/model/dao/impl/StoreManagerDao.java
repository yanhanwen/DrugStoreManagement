package com.dsm.model.dao.impl;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.dsm.model.entity.StoreManager;
import com.dsm.model.utils.JDBCTools;

public class StoreManagerDao extends BaseDao<StoreManager>
{
	public BigDecimal getOutNum()
	{
		Connection connection;
		try {
			connection = JDBCTools.getConnection();
			String sql = "select sum(Salary) from StoreManager where OnDuty = 1";
			PreparedStatement pstmt = connection.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			return rs.getBigDecimal(1);
		} catch (SQLException e) {
			return new BigDecimal(-1);
		}
	}
	public void addObject(Object obj)
	{
		StoreManager StoreManager = (StoreManager) obj;
		String sql = "insert into StoreManager(StoreManNo,StoreManName,Sex,Birthday,Age,Telephone,HireDate,StoreNo,Salary,Passwd,ManagerNo,OnDuty,Icon) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		update(sql,StoreManager.getManagerNo(),StoreManager.getStoreManName(),StoreManager.getSex(),StoreManager.getBirthday(),
				StoreManager.getAge(),StoreManager.getTelephone(),StoreManager.getHireDate(),StoreManager.getStoreNo(),StoreManager.getSalary(),
				StoreManager.getPasswd(),StoreManager.getManagerNo(),StoreManager.getOnDuty(),StoreManager.getIcon());
	}
	public void deleteObjectByKey(Object key)
	{
		String StoreManagerNo = (String)key;
		String sql = "delete from StoreManager where StoreManagerNo=?";
		update(sql, StoreManagerNo);
	}
}
