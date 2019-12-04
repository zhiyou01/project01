package com.zhiyou.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou.dao.AdminDao;
import com.zhiyou.pojo.Admin;
import com.zhiyou.pojo.Course;
import com.zhiyou.service.AdminService;
import com.zhiyou.util.MD5Utils;
@Service
public class AdminServiceImpl implements AdminService{
	@Autowired
	AdminDao aDao;
	public int select(String accounts, String password,HttpServletRequest req ) {
		Admin admin = aDao.select(accounts);
		
		if (admin!=null) {
				if (admin.getPassword().equals(password)) {
					return 1;
				}else{
					return 2;
				}
		}
		return 3;
	}
	public List<Course> selectAll() {
		return aDao.selectAll();
	}

}
