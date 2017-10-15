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
			String sql = "select sum(Salary) from Manager";
			PreparedStatement pstmt = connection.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			return rs.getBigDecimal(1);
		} catch (SQLException e) {
			return new BigDecimal(-1);
		}
	}
	public void addObject(Object obj) 
	{
		Manager Manager = (Manager) obj;
		String sql = "insert into Manager(ManagerNo,ManagerName,Sex,Birthday,Age,Telephone,HireDate,Salary,Passwd,OnDuty,Icon) values(?,?,?,?,?,?,?,?,?,?,?)";
		update(sql,Manager.getManagerNo(),Manager.getManagerName(),Manager.getSex(),Manager.getBirthday(),Manager.getAge(),
				Manager.getTelephone(),Manager.getHireDate(),Manager.getSalary(),Manager.getPasswd(),Manager.getOnDuty(),Manager.getIcon());
	}

	public void deleteObjectByKey(Object key) 
	{
		String ManagerNo = (String)key;
		String sql = "delete from Manager where ManagerNo=?";
		update(sql, ManagerNo);
	}
}
