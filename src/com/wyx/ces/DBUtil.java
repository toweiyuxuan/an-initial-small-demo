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
 * @κ���� Administrator
 * QQ��181833441
 * ������
 */
public class DBUtil
{
	/**
	 * �������ݿ�
	 * @return
	 */
	public static Connection getConn()
	{
		//���Classpath�µ���Դ�ļ���
		InputStream in = DBUtil.class.getClassLoader().getResourceAsStream("db.properties");
		//Properties���ʾһ��־õ����ԣ�ʵ����Properties��
		Properties prop = new Properties();
		//ConnectionΪ���ض����ݿ������
		Connection conn = null;
		try
		{
			//�������ֽ�����ȡ�����б�����Ԫ�ضԣ���
			prop.load(in);
			//������ݿ�������Ϣ
			String driverClass = prop.getProperty("driverClass");
			String url = prop.getProperty("url");
			String username = prop.getProperty("username");
			String password = prop.getProperty("password");
			//ע�����ݿ�����(Class������ʾ�������е�JavaӦ�ó����е���ͽӿ�)
			Class.forName(driverClass);
			//DriverManager���ڹ���һ��JDBC��������Ļ�������
			conn = DriverManager.getConnection(url, username, password);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return conn;
	}

	/**
	 * Ԥ����
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
	 * �ر���Դ
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
	 * �ر���Դ
	 * @param rs
	 */
	public static void closeResQuery(ResultSet rs)
	{
		try
		{
			if (rs != null)
			{
				Statement pstmt = rs.getStatement();
				// �ر�ResultSetһ��Ҫ�ڻ��Statement֮��
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