package com.wyx.ces.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.wyx.ces.model.CSUsr;
import com.wyx.ces.service.CSUsrService;
import com.wyx.ces.service.impl.CSUsrServiceImpl;

public class UpdateServlet extends HttpServlet
{
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		List<String> suffixList = new ArrayList<String>();
		suffixList.add(".jpg");
		suffixList.add(".png");
		suffixList.add(".gif");
		CSUsrService userService = new CSUsrServiceImpl();
		// ��ñ��ύ�����Ĳ���
		String username = null;
		String password = null;
		String gender = null;
		String birthday = null;
		String email = null;
		String sal = null;
		String StartPic = null;
		String pic = null;	
		String userIdStr = null;

		PrintWriter out = response.getWriter();
		
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload sfu = new ServletFileUpload(factory);
		sfu.setFileSizeMax(1024 * 1024);
		try
		{
			List<FileItem> fiList = sfu.parseRequest(request);
			for (FileItem fi : fiList)
			{
				// ��ñ����ı��������
				String fieldName = fi.getFieldName();
				// �Ƿ������ļ�����
				boolean isComm = fi.isFormField();
				// ���ԭʼ�ļ���
				String oriFileName = fi.getName();
				if (isComm && fieldName != null && !"".equals(fieldName))
				{
					String content = fi.getString();
					content = new String(content.getBytes("ISO-8859-1"),"UTF-8");
					if (fieldName.equals("StartPic"))
					{						
						StartPic = content;
					} else if (fieldName.equals("username"))
					{
						username = content;
					} else if (fieldName.equals("password"))
					{
						password = content;
					} else if (fieldName.equals("gender"))
					{
						gender = content;
					} else if (fieldName.equals("birthday"))
					{
						birthday = content;
					} else if (fieldName.equals("email"))
					{
						email = content;
					} else if (fieldName.equals("sal"))
					{
						sal = content;
					} else if (fieldName.equals("userId"))
					{
						userIdStr = content;
					}
				}
				if (!isComm && fieldName != null && !"".equals(fieldName))
				{
					// ���Ҫ�ϴ��ľ���·��
					String realPath = request.getSession().getServletContext().getRealPath("/upload/");
					if (oriFileName != null && !"".equals(oriFileName))
					{
						String suffix = oriFileName.substring(oriFileName.lastIndexOf("."));
						if (suffixList.contains(suffix))
						{
							String tFileName = UUID.randomUUID().toString();
							String relativePath = "/upload/" + tFileName + suffix;
							pic = relativePath;
							File file = new File(realPath, tFileName + suffix);
							fi.write(file);
						} else
						{
							out.print("<script>alert('ͼƬ��ʽ����,���ϴ�.jpg, .png,.gif��ͼƬ��');window.history.back();</script>");
							out.flush();
							out.close();
							return;
						}
					}
				}
			}
			/*// �Ѳ���ת������Ӧ����������
			Integer genderInt = null;
			java.util.Date birthdayDate = null;
			BigDecimal salBD = null;
			Integer userId = null;
			if (gender != null)
			{
				genderInt = new Integer(gender);
			}
			if (birthday != null)
			{
				try
				{
					birthdayDate = new SimpleDateFormat("yyyy-MM-dd")
							.parse(birthday);
				} catch (ParseException e)
				{
					e.printStackTrace();
				}
			}
			if (sal != null)
			{
				salBD = new BigDecimal(sal);
			}
			if (userIdStr != null)
			{
				userId = new Integer(userIdStr);
			}*/
			Integer userId = null;
			Integer genderInt = null;			
			if (gender != null)
			{
				genderInt = new Integer(gender);
			}			
			if (pic == null)
			{
				pic = StartPic;
			}
			if (userIdStr != null)
			{
				userId = new Integer(userIdStr);
			}
			CSUsr user = new CSUsr();
			user.setEmail(email);
			user.setBirthday(birthday);
			user.setGender(genderInt);
			user.setPassword(password);
			user.setUsername(username);
			user.setSal(sal);
			if(pic==null)
			{
				user.setPic(StartPic);
			}
			else
			{
				user.setPic(pic);
			}
			user.setUserId(userId);
			userService.updateUser(user);
			
			response.sendRedirect(request.getContextPath() + "/QueryServlet");
			out.flush();
			out.close();

		} catch (Exception e1)
		{
			if (e1 instanceof FileUploadBase.FileSizeLimitExceededException)
			{				
				out.print("<script>alert('�ļ��������ϴ�С�� 1M ��ͼƬ��');window.history.back();</script>");
				out.flush();
				out.close();
			}
		}
	}
}
