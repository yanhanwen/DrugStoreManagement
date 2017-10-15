package com.dsm.model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.dsm.model.entity.Store;
import com.dsm.model.utils.JDBCTools;

public class StoreDao extends BaseDao<Store>
{
	public int getOutNum()
	{
		Connection connection;
		try {
			connection = JDBCTools.getConnection();
			String sql = "select sum(MonthlyCost) from Store";
			PreparedStatement pstmt = connection.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			return rs.getInt(1);
		} catch (SQLException e) {
			return -1;
		}
	}
	public void addObject(Object obj) {
		// TODO Auto-generated method stub
		
	}

	public void deleteObjectByKey(Object key) {
		// TODO Auto-generated method stub
		
	}
	
}
