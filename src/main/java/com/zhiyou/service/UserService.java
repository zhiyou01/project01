package com.zhiyou.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.zhiyou.pojo.User;

public interface UserService {
//	1.ͨ���û��������Ƿ����
	//boolean selectByAccounts(String accounts);
	
//	2.��¼��֤
	User loginSelect(HttpServletRequest req,String accounts,String password);
	
	User selectByAccounts(String accounts);
	
	User selectById(int id);
	
	void  addUser(User user);
	
//  4.�û��޸�
	void updateUser(User user);
	
//	5.�����û�
	boolean selectUser(User user);
}
