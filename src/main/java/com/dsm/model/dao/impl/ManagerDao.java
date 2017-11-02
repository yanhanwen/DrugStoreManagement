package com.dsm.model.dao.impl;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.dsm.model.entity.Manager;
import com.dsm.model.utils.JDBCTools;

public class ManagerDao extends BaseDao<Manager>
{
	public BigDecimal getOutNum()
	{
		Connection connection;
		try {
			connection = JDBCTools.getConnection();
			String sql = "select sum(Salary) from Manager where OnDuty = 1";
			PreparedStatement pstmt = connection.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			BigDecimal a = rs.getBigDecimal(1);
			JDBCTools.releaseConnection(connection, pstmt, rs);
			return a;
		} catch (SQLException e) {
			return new BigDecimal(-1);
		}
	}
	public void addObject(Object obj) 
	{
		Manager Manager = (Manager) obj;
		String sql = "insert into Manager(ManagerNo,ManagerName,Sex,Birthday,Telephone,HireDate,Salary,Passwd,OnDuty) values(?,?,?,?,?,?,?,?,?)";
		update(sql,Manager.getManagerno(),Manager.getManagername(),Manager.getSex(),Manager.getBirthday(),
				Manager.getTelephone(),Manager.getHiredate(),Manager.getSalary(),Manager.getPasswd(),Manager.getOnduty());
	}

	public void deleteObjectByKey(Object key) 
	{
		String ManagerNo = (String)key;
		String sql = "delete from Manager where ManagerNo=?";
		update(sql, ManagerNo);
	}
}
