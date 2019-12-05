package com.zhiyou.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.zhiyou.pojo.User;

public interface UserService {
//	1.通过用户名查找是否存在
	//boolean selectByAccounts(String accounts);
	
//	2.登录验证
	User loginSelect(HttpServletRequest req,String accounts,String password);
	
	User selectByAccounts(String accounts);
	
	User selectById(int id);
	
	void  addUser(User user);
	
//  4.用户修改
	void updateUser(User user);
	
//	5.查找用户
	boolean selectUser(User user);
}
