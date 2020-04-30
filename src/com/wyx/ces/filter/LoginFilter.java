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
		// ��ServletRequestת����HttpServletRequest
		HttpServletRequest req = (HttpServletRequest) request;
		// ���session
		HttpSession session = req.getSession();
		// ��session������ȡuser
		CSUsr user = (CSUsr) session.getAttribute("user");
		if (user == null)
		{
			HttpServletResponse resp = (HttpServletResponse) response;
			// �����Ŀ�ĸ�Ŀ¼
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
