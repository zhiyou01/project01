package com.zhiyou.dao;

import com.zhiyou.pojo.User;

public interface UserDao {
	
//  1.通过用户名查找
	User selectByAccounts(String accounts);
//  2.通过id查找用户
	User selectById(int id);
//  3.用户添加
	void  addUser(User user);
//  4.用户修改
	void updateUser(User user);
}
