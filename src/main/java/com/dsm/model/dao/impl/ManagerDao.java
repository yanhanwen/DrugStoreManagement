package com.dsm.model.dao.impl;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.dsm.model.entity.Manager;
import com.dsm.model.entity.Salesman;
import com.dsm.model.utils.JDBCTools;

public class ManagerDao extends BaseDao<Salesman>
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
		Manager activitySignin = (Manager) obj;
		String sql = "insert into Manager values(?,?,?)";
		update(sql, activitySignin.getUserId(), activitySignin.getActivityId(), 
				activitySignin.getSigninTime());
	}

	public void deleteObjectByKey(Object key) 
	{
		
	}

}
