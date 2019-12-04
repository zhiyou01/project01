package com.zhiyou.service.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou.dao.UserDao;
import com.zhiyou.pojo.User;
import com.zhiyou.service.UserService;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
	UserDao dao;
    
    
//	public boolean selectByAccounts(String accounts) {
//		User user = dao.selectByAccounts(accounts);
//		if (user!=null) {
//			return true;
//		}else {
//			return false;
//		}
//		
//	}

	public User selectByAccounts(String accounts) {
		User user = dao.selectByAccounts(accounts);
		if (user!=null) {
			return user;
		}else {
			return null;
		}
		
	}

	public User loginSelect(HttpServletRequest req,String accounts, String password) {
		User user = dao.selectByAccounts(accounts);
		if (user!=null) {
			if (user.getPassword().equals(password)) {
			}else {
				req.setAttribute("msg", "√‹¬Î¥ÌŒÛ,«Î÷ÿ–¬ ‰»Î");
			}
		}else {
			req.setAttribute("msg", "’À∫≈≤ª¥Ê‘⁄£¨«Î◊¢≤·");
		}
		return user;
	}

	public User selectById(int id) {
		
		return dao.selectById(id);
	}

	public void addUser(User user) {
		dao.addUser(user);
	}

	public void updateUser(User user) {
		dao.updateUser(user);
	}

}
