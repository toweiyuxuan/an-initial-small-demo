package com.wyx.ces.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wyx.ces.model.CSUsr;
import com.wyx.ces.service.CSUsrService;
import com.wyx.ces.service.impl.CSUsrServiceImpl;

public class LoginServlet extends HttpServlet
{

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		doPost(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		// 获得登录的传参数
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		// 创建Service的接口对象
		CSUsrService userService = new CSUsrServiceImpl();
		// 调用Service的获取用户的方法
		CSUsr user = userService.getUserByNameAndPass(username, password);
		if (user != null)
		{
			// 获得session对象
			HttpSession session = request.getSession();
			// 把user对象放入session的域中
			session.setAttribute("user", user);
			// 获得项目的根路径
			String rpath = request.getContextPath();
			if(username.equals("juan"))
			{
				response.sendRedirect(rpath + "/wyx/love.jsp");
			}
			else
			{
				response.sendRedirect(rpath + "/wyx/main.jsp");
			}
			
		} else
		{
			response.setCharacterEncoding("utf-8");
			PrintWriter out = response.getWriter();
			out.print("<script>alert('用户名或密码错误！');window.history.back(); </script>");
			out.flush();
			out.close();
		}
	}
}
