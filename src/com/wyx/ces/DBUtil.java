package com.wyx.ces;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * 
 * @魏宇轩 Administrator
 * QQ：181833441
 * 描述：
 */
public class DBUtil
{
	/**
	 * 连接数据库
	 * @return
	 */
	public static Connection getConn()
	{
		//获得Classpath下的资源文件流
		InputStream in = DBUtil.class.getClassLoader().getResourceAsStream("db.properties");
		//Properties类表示一组持久的属性，实例化Properties类
		Properties prop = new Properties();
		//Connection为与特定数据库的连接
		Connection conn = null;
		try
		{
			//从输入字节流读取属性列表（键和元素对）。
			prop.load(in);
			//获得数据库连接信息
			String driverClass = prop.getProperty("driverClass");
			String url = prop.getProperty("url");
			String username = prop.getProperty("username");
			String password = prop.getProperty("password");
			//注册数据库驱动(Class类的类表示正在运行的Java应用程序中的类和接口)
			Class.forName(driverClass);
			//DriverManager用于管理一组JDBC驱动程序的基本服务。
			conn = DriverManager.getConnection(url, username, password);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return conn;
	}

	/**
	 * 预编译
	 * @param sql
	 * @return
	 */
	public static PreparedStatement getPstmt(String sql)
	{
		Connection conn = getConn();
		PreparedStatement pstmt = null;
		try
		{
			pstmt = conn.prepareStatement(sql);
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return pstmt;
	}

	/**
	 * 关闭资源
	 * @param pstmt
	 */
	public static void closeResUpdate(PreparedStatement pstmt)
	{
		try
		{
			if (pstmt != null)
			{
				Connection conn = pstmt.getConnection();
				pstmt.close();
				if (conn != null)
				{
					conn.close();
				}
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * 关闭资源
	 * @param rs
	 */
	public static void closeResQuery(ResultSet rs)
	{
		try
		{
			if (rs != null)
			{
				Statement pstmt = rs.getStatement();
				// 关闭ResultSet一定要在获得Statement之后
				rs.close();
				if (pstmt != null)
				{
					Connection conn = pstmt.getConnection();
					pstmt.close();
					if (conn != null)
					{
						conn.close();
					}
				}
			}

		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
}