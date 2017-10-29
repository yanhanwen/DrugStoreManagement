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
			rs.next();
			return rs.getBigDecimal(1);
		} catch (SQLException e) {
			return new BigDecimal(-1);
		}
	}
	public void addObject(Object obj)
	{
		Salesman Salesman = (Salesman) obj;
		String sql = "insert into Salesman(SalesmanNo,SalesmanName,Sex,Birthday,Telephone,HireDate,StoreNo,Salary,Passwd,OnDuty) values(?,?,?,?,?,?,?,?,?,?)";
		update(sql,Salesman.getSalesmanno(),Salesman.getSalesmanname(),Salesman.getSex(),Salesman.getBirthday(),
				Salesman.getTelephone(),Salesman.getHiredate(),Salesman.getStoreno(),Salesman.getSalary(),
				Salesman.getPasswd(),Salesman.getOnduty());
	}
	public void deleteObjectByKey(Object key)
	{
		String SalesmanNo = (String)key;
		String sql = "delete from Salesman where SalesmanNo=?";
		update(sql, SalesmanNo);
	}

}
