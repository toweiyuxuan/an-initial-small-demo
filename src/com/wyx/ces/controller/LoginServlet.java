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
		// ��õ�¼�Ĵ�����
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		// ����Service�Ľӿڶ���
		CSUsrService userService = new CSUsrServiceImpl();
		// ����Service�Ļ�ȡ�û��ķ���
		CSUsr user = userService.getUserByNameAndPass(username, password);
		if (user != null)
		{
			// ���session����
			HttpSession session = request.getSession();
			// ��user�������session������
			session.setAttribute("user", user);
			// �����Ŀ�ĸ�·��
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
			out.print("<script>alert('�û������������');window.history.back(); </script>");
			out.flush();
			out.close();
		}
	}
}
