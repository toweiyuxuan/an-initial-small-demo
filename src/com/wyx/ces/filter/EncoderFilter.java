package com.wyx.ces.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class EncoderFilter implements Filter
{

	private String encoder;

	public void destroy()
	{

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException
	{
		// 处理post请求时乱码问题
		request.setCharacterEncoding(this.encoder);
		// post方式相应页面乱码处理
		response.setCharacterEncoding(this.encoder);
		response.setContentType("text/html;charset=" + this.encoder);

		// 强制转换ServletRequest为HttpServletRequest
		HttpServletRequest req = (HttpServletRequest) request;
		// 获得请求方式
		String method = req.getMethod();
		//System.out.println(request.getClass());
		if (method.equalsIgnoreCase("get"))
		{
			// 创建装饰器的类
			req = new MyHttpServletRequestWrapper(req, this.encoder);
		}
		chain.doFilter(req, response);
	}

	public void init(FilterConfig filterConfig) throws ServletException
	{
		// 获得当前过滤器的编码
		String paramEncoder = filterConfig.getInitParameter("encoder").trim();
		if (paramEncoder != null && !"".equals(paramEncoder))
		{
			this.encoder = paramEncoder;
		}
	}
}
