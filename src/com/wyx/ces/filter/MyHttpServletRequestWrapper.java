package com.wyx.ces.filter;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class MyHttpServletRequestWrapper extends HttpServletRequestWrapper
{

	private String encoder;

	public MyHttpServletRequestWrapper(HttpServletRequest request)
	{
		super(request);
	}

	/**
	 * 定义带有编码的构造器
	 * 
	 * @param request
	 * @param charset
	 */
	public MyHttpServletRequestWrapper(HttpServletRequest request,
			String charset)
	{
		super(request);
		this.encoder = charset;
	}

	/**
	 * 重写getParameter
	 */
	@Override
	public String getParameter(String name)
	{
		// 获得默认编码的值
		String value = super.getParameter(name);
		try
		{
			value = value == null ? null : new String(
					value.getBytes("ISO-8859-1"), this.encoder);
		} catch (UnsupportedEncodingException e)
		{
			e.printStackTrace();
		}
		return value;
	}
}
