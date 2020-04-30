package com.wyx.ces.service.impl;

import java.util.List;

import com.wyx.ces.dao.CSUsrDao;
import com.wyx.ces.dao.impl.CSUsrDaoImpl;
import com.wyx.ces.model.CSUsr;
import com.wyx.ces.service.CSUsrService;

public class CSUsrServiceImpl implements CSUsrService
{
	private CSUsrDao userDao = new CSUsrDaoImpl();

	public CSUsr getUserById(Integer userId)
	{
		return userDao.getUserById(userId);
	}

	public List<CSUsr> listUser(int start,int limt)
	{
		return userDao.listUser(start,limt);
	}

	public void saveUser(CSUsr user)
	{
		userDao.saveUser(user);
	}

	public void updateUser(CSUsr user)
	{
		userDao.updateUser(user);
	}

	public void deleteUser(Integer userId)
	{
		userDao.deleteUser(userId);
	}

	public CSUsr getUserByNameAndPass(String username, String password)
	{
		return userDao.getUserByNameAndPass(username, password);
	}
}
