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
			String sql = "select sum(Salary) from StoreManager";
			PreparedStatement pstmt = connection.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			return rs.getBigDecimal(1);
		} catch (SQLException e) {
			return new BigDecimal(-1);
		}
	}
	public void addObject(Object obj) {
		// TODO Auto-generated method stub
		
	}

	public void deleteObjectByKey(Object key) {
		// TODO Auto-generated method stub
		
	}

}
