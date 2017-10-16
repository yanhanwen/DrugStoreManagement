package com.dsm.model.dao.impl;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.dsm.model.entity.Salesman;
import com.dsm.model.utils.JDBCTools;

public class SalesmanDao extends BaseDao<Salesman>
{
	public BigDecimal getOutNum()
	{
		Connection connection;
		try {
			connection = JDBCTools.getConnection();
			String sql = "select sum(Salary) from Salesman where OnDuty = 1";
			PreparedStatement pstmt = connection.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			return rs.getBigDecimal(1);
		} catch (SQLException e) {
			return new BigDecimal(-1);
		}
	}
	public void addObject(Object obj)
	{
		Salesman Salesman = (Salesman) obj;
		String sql = "insert into Salesman(SalesmanNo,SalesmanName,Sex,Birthday,Age,Telephone,HireDate,StoreNo,Salary,Passwd,OnDuty,Icon) values(?,?,?,?,?,?,?,?,?,?,?,?)";
		update(sql,Salesman.getSalesmanNo(),Salesman.getSalesmanName(),Salesman.getSex(),Salesman.getBirthday(),
				Salesman.getAge(),Salesman.getTelephone(),Salesman.getHireDate(),Salesman.getStoreNo(),Salesman.getSalary(),
				Salesman.getPasswd(),Salesman.getOnDuty(),Salesman.getIcon());
	}
	public void deleteObjectByKey(Object key)
	{
		String SalesmanNo = (String)key;
		String sql = "delete from Salesman where SalesmanNo=?";
		update(sql, SalesmanNo);
	}

}
