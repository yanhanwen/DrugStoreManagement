package com.dsm.model.dao.impl;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.dsm.model.entity.Store;
import com.dsm.model.utils.JDBCTools;

public class StoreDao extends BaseDao<Store>
{
	public BigDecimal getOutNum()
	{
		Connection connection;
		try {
			connection = JDBCTools.getConnection();
			String sql = "select sum(MonthlyCost) from Store";
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
		Store Store = (Store) obj;
		String sql = "insert into Store(StoreNo,StoreName,Province,City,District,Street,AddrDetail,Telephone,OpenDate,MonthlyCost,isOpen) values(?,?,?,?,?,?,?,?,?,?,?)";
		update(sql,Store.getStoreno(),Store.getStorename(),Store.getProvince(),Store.getCity(),Store.getDistrict(),
				Store.getStreet(),Store.getAddrdetail(),Store.getTelephone(),Store.getOpendate(),Store.getMonthlycost(),Store.getIsopen());
	}
	public void deleteObjectByKey(Object key)
	{
		String StoreNo = (String)key;
		String sql = "delete from Store where StoreNo=?";
		update(sql, StoreNo);
	}
}
