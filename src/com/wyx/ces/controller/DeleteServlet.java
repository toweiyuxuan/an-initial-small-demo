package com.wyx.ces.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wyx.ces.service.CSUsrService;
import com.wyx.ces.service.impl.CSUsrServiceImpl;

public class DeleteServlet extends HttpServlet
{
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		String userIdStr = request.getParameter("userId");
		Integer userId = null;
		if (userIdStr != null)
		{
			userId = new Integer(userIdStr);
		}
		CSUsrService userService = new CSUsrServiceImpl();
		userService.deleteUser(userId);
		response.sendRedirect(request.getContextPath() + "/QueryServlet");
	}
}
