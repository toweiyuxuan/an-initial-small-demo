package com.wyx.ces.controller;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wyx.ces.DBUtil;
import com.wyx.ces.model.CSUsr;
import com.wyx.ces.service.CSUsrService;
import com.wyx.ces.service.impl.CSUsrServiceImpl;

public class QueryServlet extends HttpServlet
{
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		// 1.数据库里面数据的总条数；        
		int count = 0;        
		String sql = "select * from cs_user";             
		PreparedStatement ps = null;        
		ResultSet rs = null;        
		try 
		{                      
			ps = DBUtil.getPstmt(sql);;           
			rs = ps.executeQuery();            
			while (rs.next()) 
			{                
				count++;            
			}        
		} 
		catch (SQLException e1) 
		{                  
			e1.printStackTrace();        
		} 
		finally 
		{ 
			DBUtil.closeResQuery(rs); 
		} 
		// 每页显示多少行      
		int limt = 10;        
		// 2.最后一页不足3条也算一页      
		int all = (int) Math.ceil((double)count/(double)limt); 

		int cpage = 1;        
		// 这个是上一页还是下一页的数据        
		String currentpage = request.getParameter("currentpage");       
		if (currentpage == null || currentpage == "") 
		{           
			cpage = 1;        
		} 
		else 
		{            
			cpage = Integer.parseInt(currentpage);            
			// 到最后一页
			if (cpage == all+1) 
			{                
				cpage = all;
			} 
			// 到第一页
			else if (cpage == 0) 
			{                
				cpage = 1;  
			} 
			// 为了保持代码完整
			else
			{
				cpage = cpage;
			}
		}
		
		// 3.开始查询的数据       
		int start = limt * (cpage-1);        
		// 4.结束查询的数据    
		int end = start+(limt-1);
		if(end > count)
		{
			limt=count-start;
		}		
		CSUsrService userService = new CSUsrServiceImpl();
		List<CSUsr> userList = userService.listUser(start,limt);		
		request.setAttribute("count", count);
		request.setAttribute("cpage", cpage);   
		request.setAttribute("all", all);   
		request.setAttribute("userList", userList);
		request.setAttribute("address", "/wyx_demo1/QueryServlet");  
		request.getRequestDispatcher("/wyx/center.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		doGet(request, response);
	}
}
