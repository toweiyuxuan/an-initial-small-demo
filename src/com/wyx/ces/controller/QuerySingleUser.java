package com.wyx.ces.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wyx.ces.model.CSUsr;
import com.wyx.ces.service.CSUsrService;
import com.wyx.ces.service.impl.CSUsrServiceImpl;

public class QuerySingleUser extends HttpServlet
{

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		String uesrIdStr = request.getParameter("userId");
		Integer userId = null;
		if (uesrIdStr != null)
		{
			userId = new Integer(uesrIdStr);
		}
		CSUsrService userService = new CSUsrServiceImpl();
		CSUsr user = userService.getUserById(userId);
		request.setAttribute("user", user);
		request.getRequestDispatcher("/wyx/toUpdate.jsp").forward(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{

	}
}
