package com.dsm.model.dao.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;
import com.dsm.model.dao.IDao;
import com.dsm.model.utils.JDBCTools;
import com.dsm.model.utils.ReflectionTools;

public abstract class BaseDao<T> implements IDao<T> 
{
	protected Class<T> c;
	public String update(String sql, Object... args)
	{
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		String primaryKey = "noneof";
		
		try
		{
			connection = JDBCTools.getConnection();
			preparedStatement = connection.prepareStatement(sql);

			for (int i = 0; i < args.length; i++)
			{
				preparedStatement.setObject(i + 1, args[i]);
			}

			preparedStatement.executeUpdate();
			
			resultSet = preparedStatement.getGeneratedKeys();
			if (resultSet.next())
				primaryKey = resultSet.getString(1);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			JDBCTools.releaseConnection(connection,preparedStatement,resultSet);
		}
		return primaryKey;
	}

	public T getSingleObject(String sql, Object... args)
	{
		List<T> result = getForList(sql, args);
		if (result.size() > 0)
			return result.get(0);
		return null;
	}

	public List<T> getForList(String sql, Object... args)
	{
		List<T> entities = new ArrayList<T>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try
		{
			connection = JDBCTools.getConnection();
			preparedStatement = connection.prepareStatement(sql);

			for (int i = 0; i < args.length; i++)
			{
				preparedStatement.setObject(i + 1, args[i]);
			}

			resultSet = preparedStatement.executeQuery();

			List<String> columnLabel = new ArrayList<String>();
			ResultSetMetaData rsmd = resultSet.getMetaData();
			int columnCount = rsmd.getColumnCount();
			for (int j = 0; j < columnCount; j++)
			{
				String attr = rsmd.getColumnLabel(j + 1);
				columnLabel.add(attr);
			}

			T entity = null;
			while (resultSet.next())
			{
				try
				{
					entity = c.newInstance();
					for (int k = 0; k < columnCount; k++)
					{
						Object value = resultSet.getObject(k + 1);
						ReflectionTools.setter(entity, columnLabel.get(k), value);
					}
				} catch (Exception e)
				{
					e.printStackTrace();
				}
				entities.add(entity);
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		} finally
		{
			JDBCTools.releaseConnection(connection,preparedStatement,resultSet);
		}

		return entities;
	}

	public Object getSingleValue(String sql, Object... args)
	{
		Object value = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try
		{
			connection = JDBCTools.getConnection();
			preparedStatement = connection.prepareStatement(sql);

			for (int i = 0; i < args.length; i++)
			{
				preparedStatement.setObject(i + 1, args[i]);
			}

			resultSet = preparedStatement.executeQuery();
			if (resultSet.next())
			{
				value = resultSet.getObject(1);
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		} finally
		{
			JDBCTools.releaseConnection(connection,preparedStatement,resultSet);
		}

		return value;
	}
}
