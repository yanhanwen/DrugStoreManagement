package com.dsm.model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.dsm.model.entity.Salesman;
import com.dsm.model.utils.JDBCTools;

public class ManagerDao extends BaseDao<Salesman>
{
	public int getOutNum()
	{
		Connection connection;
		try {
			connection = JDBCTools.getConnection();
			String sql = "select sum(Salary) from Manager";
			PreparedStatement pstmt = connection.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			return rs.getInt(1);
		} catch (SQLException e) {
			return -1;
		}
	}
	public void addObject(Object obj) {
		// TODO Auto-generated
		jdjfdsalfk;
	}

	public void deleteObjectByKey(Object key) {
		// TODO Auto-generated method stub
		
	}

}
