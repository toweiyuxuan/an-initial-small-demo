package com.wyx.ces.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.wyx.ces.DBUtil;
import com.wyx.ces.dao.CSUsrDao;
import com.wyx.ces.model.CSUsr;

public class CSUsrDaoImpl implements CSUsrDao
{

	public CSUsr getUserById(Integer userId)
	{
		PreparedStatement pstmt = null;
		String sql = "select * from cs_user where user_id = ?";
		ResultSet rs = null;
		CSUsr user = new CSUsr();
		try
		{
			pstmt = DBUtil.getPstmt(sql);
			pstmt.setInt(1, userId);
			rs = pstmt.executeQuery();
			rs.next();
			String username = rs.getString("username");
			String password = rs.getString("password");
			Integer gender = rs.getInt("gender");
			String birthday = rs.getString("birthday");
			String email = rs.getString("email");
			String pic = rs.getString("pic");
			String sal = rs.getString("sal");

			user.setUserId(userId);
			user.setUsername(username);
			user.setPic(pic);
			user.setPassword(password);
			user.setBirthday(birthday);
			user.setEmail(email);
			user.setGender(gender);
			user.setSal(sal);
		} catch (Exception ex)
		{
			ex.printStackTrace();
		} finally
		{
			DBUtil.closeResQuery(rs);
		}
		return user;
	}

	public List<CSUsr> listUser(int start,int limt)
	{		
		String sql = "select * from cs_user limit ?,?";
		PreparedStatement pstmt = DBUtil.getPstmt(sql);
		List<CSUsr> userList = new ArrayList<CSUsr>();
		ResultSet rs = null;
		try
		{
			pstmt = DBUtil.getPstmt(sql);;
			pstmt.setLong(1, start);     
			pstmt.setLong(2, limt);            
			rs = pstmt.executeQuery(); 
			// 定义存储user的集合
			while (rs.next())
			{
				// 获得查询上来的每一条数据
				Integer userId = rs.getInt("user_id");
				String username = rs.getString("username");
				String password = rs.getString("password");
				Integer gender = rs.getInt("gender");
				String birthday = rs.getString("birthday");
				String email = rs.getString("email");
				String sal = rs.getString("sal");
				String pic = rs.getString("pic");
				// 封装成user对象
				CSUsr user = new CSUsr();
				user.setUserId(userId);
				user.setPic(pic);
				user.setUsername(username);
				user.setPassword(password);
				user.setGender(gender);
				user.setBirthday(birthday);
				user.setEmail(email);
				user.setSal(sal);
				userList.add(user);
			}
		} catch (Exception ex)
		{
			ex.printStackTrace();
		} finally
		{
			DBUtil.closeResQuery(rs);
		}
		return userList;
	}

	public void saveUser(CSUsr user)
	{
		String sql = "insert into cs_user(username, password ,gender, birthday, email, sal, pic)values(?,?,?,?,?,?,?)";
		PreparedStatement pstmt = null;
		try
		{
			pstmt = DBUtil.getPstmt(sql);
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getPassword());
			pstmt.setInt(3, user.getGender());
			pstmt.setString(4, user.getBirthday());
			pstmt.setString(5, user.getEmail());
			pstmt.setString(6, user.getSal());
			pstmt.setString(7, user.getPic());
			pstmt.executeUpdate();
			//重新编号
			resetSeq();
		} catch (Exception ex)
		{
			ex.printStackTrace();
		} finally
		{
			DBUtil.closeResUpdate(pstmt);
		}
	}

	public void updateUser(CSUsr user)
	{
		String sql = "update cs_user set username = ?, password=?, gender=?, birthday=?, email=?, sal=?, pic=? where user_id = ?";
		PreparedStatement pstmt = null;
		try
		{
			pstmt = DBUtil.getPstmt(sql);
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getPassword());
			pstmt.setInt(3, user.getGender());
			pstmt.setString(4, user.getBirthday());
			pstmt.setString(5, user.getEmail());
			pstmt.setString(6, user.getSal());
			pstmt.setString(7, user.getPic());
			pstmt.setInt(8, user.getUserId());
			pstmt.executeUpdate();
		} catch (Exception ex)
		{
			ex.printStackTrace();
		} finally
		{
			DBUtil.closeResUpdate(pstmt);
		}
	}

	public void resetSeq() throws SQLException
	{
		// 定义重排序sql
		String[] sqls = new String[3];
	    sqls[0] = "SET @i=0";
	    sqls[1] = "UPDATE `cs_user` SET `user_id`=(@i:=@i+1)";
	    sqls[2] = "ALTER TABLE `cs_user` AUTO_INCREMENT=0";
	    Statement sm = null;
	    try
		{
	    	sm = DBUtil.getConn().createStatement();
		    for (int i = 0; i < sqls.length; i++) 
		    {
		    	// 将所有的SQL语句添加到Statement中
		    	sm.addBatch(sqls[i]);
		    }
		    // 一次执行多条SQL语句
		    sm.executeBatch();
		}catch (SQLException e)
		{
			e.printStackTrace();
		}finally
		{
			sm.close();
		}    
	}
	
	
	public void deleteUser(Integer userId)
	{
		// 定义删除用户sql
		String sql = "delete from cs_user where user_id = ?";
		PreparedStatement pstmt = null;
		try
		{
			pstmt = DBUtil.getPstmt(sql);
			pstmt.setInt(1, userId);
			pstmt.executeUpdate();
			//重新编号
			resetSeq();
		} catch (Exception ex)
		{
			ex.printStackTrace();
		} finally
		{
			DBUtil.closeResUpdate(pstmt);			
		}
	}

	public CSUsr getUserByNameAndPass(String username, String password)
	{
		String sql = "select * from cs_user where username = ? and password = ?";
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		CSUsr user = null;
		try
		{
			pstmt = DBUtil.getPstmt(sql);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();

			if (rs.next())
			{
				user = new CSUsr();
				Integer userId = rs.getInt("user_id");
				Integer gender = rs.getInt("gender");
				String birthday = rs.getString("birthday");
				String email = rs.getString("email");
				String sal = rs.getString("sal");
				String pic = rs.getString("pic");

				user.setUserId(userId);
				user.setUsername(username);
				user.setPassword(password);
				user.setBirthday(birthday);
				user.setEmail(email);
				user.setGender(gender);
				user.setSal(sal);
				user.setPic(pic);;
			}
		} catch (Exception ex)
		{
			ex.printStackTrace();
		} finally
		{
			DBUtil.closeResQuery(rs);
		}

		return user;
	}
}
