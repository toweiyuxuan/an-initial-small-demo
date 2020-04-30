package com.wyx.ces.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wyx.ces.model.CSUsr;

public class LoginFilter implements Filter
{

	public void destroy()
	{

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException
	{
		// 把ServletRequest转换成HttpServletRequest
		HttpServletRequest req = (HttpServletRequest) request;
		// 获得session
		HttpSession session = req.getSession();
		// 从session中来获取user
		CSUsr user = (CSUsr) session.getAttribute("user");
		if (user == null)
		{
			HttpServletResponse resp = (HttpServletResponse) response;
			// 获得项目的跟目录
			String rpath = req.getContextPath();
			resp.sendRedirect(rpath + "/login.jsp");
		} else
		{
			chain.doFilter(request, response);
		}
	}

	public void init(FilterConfig filterConfig) throws ServletException
	{

	}
}
