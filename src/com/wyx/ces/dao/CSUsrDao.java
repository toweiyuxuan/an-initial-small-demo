package com.wyx.ces.dao;

import java.util.List;

import com.wyx.ces.model.CSUsr;

public interface CSUsrDao
{
	public void saveUser(CSUsr user);

	public void updateUser(CSUsr user);

	public CSUsr getUserById(Integer userId);

	public List<CSUsr> listUser(int start, int limt);

	public void deleteUser(Integer userId);

	public CSUsr getUserByNameAndPass(String username, String password);
}
