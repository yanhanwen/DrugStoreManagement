package com.dsm.model.utils;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import javax.sql.DataSource;

public class JDBCTools
{
    private static DataSource dataSource = null;
    static
    {
        dataSource = new ComboPooledDataSource("dsmc3p0");
    }

    /*获取链接*/
    public static Connection getConnection() throws SQLException
    {
        return dataSource.getConnection();
    }

    /*释放链接*/
    public static void releaseConnection(Connection connection, Statement statement, ResultSet resultSet)
    {
        if (resultSet != null)
        {
            try
            {
                resultSet.close();
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
        if (statement != null)
        {
            try
            {
                statement.close();
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
        if (resultSet != null)
        {
            try
            {
                connection.close();
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
    }
}
