package com.wyx.ces.model;

import java.math.BigDecimal;
import java.util.Date;

public class CSUsr
{
	// ���ݿ��е��ֶζ������ʹ��"_"���ָ�����java������ʹ���շ�ģʽ
	private Integer userId;

	private String username;

	private String password;

	private Integer gender;

	private String birthday;

	private String email;

	private String sal;
	
	private String pic;

	public Integer getUserId()
	{
		return userId;
	}

	public void setUserId(Integer userId)
	{
		this.userId = userId;
	}

	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public Integer getGender()
	{
		return gender;
	}

	public void setGender(Integer gender)
	{
		this.gender = gender;
	}

	public String getBirthday()
	{
		return birthday;
	}

	public void setBirthday(String birthday)
	{
		this.birthday = birthday;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getSal()
	{
		return sal;
	}

	public void setSal(String sal)
	{
		this.sal = sal;
	}

	public String getPic()
	{
		return pic;
	}

	public void setPic(String pic)
	{
		this.pic = pic;
	}	
}