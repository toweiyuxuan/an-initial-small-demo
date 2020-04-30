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
		// ����post����ʱ��������
		request.setCharacterEncoding(this.encoder);
		// post��ʽ��Ӧҳ�����봦��
		response.setCharacterEncoding(this.encoder);
		response.setContentType("text/html;charset=" + this.encoder);

		// ǿ��ת��ServletRequestΪHttpServletRequest
		HttpServletRequest req = (HttpServletRequest) request;
		// �������ʽ
		String method = req.getMethod();
		//System.out.println(request.getClass());
		if (method.equalsIgnoreCase("get"))
		{
			// ����װ��������
			req = new MyHttpServletRequestWrapper(req, this.encoder);
		}
		chain.doFilter(req, response);
	}

	public void init(FilterConfig filterConfig) throws ServletException
	{
		// ��õ�ǰ�������ı���
		String paramEncoder = filterConfig.getInitParameter("encoder").trim();
		if (paramEncoder != null && !"".equals(paramEncoder))
		{
			this.encoder = paramEncoder;
		}
	}
}
