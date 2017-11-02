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
			rs.next();
			JDBCTools.releaseConnection(connection, pstmt, rs);
			return rs.getBigDecimal(1);
		} catch (SQLException e) {
			return new BigDecimal(0);
		}
	}
	public void addObject(Object obj)
	{
		StoreManager StoreManager = (StoreManager) obj;
		String sql = "insert into StoreManager(StoreManNo,StoreManName,Sex,Birthday,Telephone,HireDate,StoreNo,Salary,Passwd,ManagerNo,OnDuty) values(?,?,?,?,?,?,?,?,?,?,?)";
		update(sql,StoreManager.getManagerno(),StoreManager.getStoremanname(),StoreManager.getSex(),StoreManager.getBirthday(),
				StoreManager.getTelephone(),StoreManager.getHiredate(),StoreManager.getStoreno(),StoreManager.getSalary(),
				StoreManager.getPasswd(),StoreManager.getManagerno(),StoreManager.getOnduty());
	}
	public void deleteObjectByKey(Object key)
	{
		String StoreManagerNo = (String)key;
		String sql = "delete from StoreManager where StoreManagerNo=?";
		update(sql, StoreManagerNo);
	}
}
