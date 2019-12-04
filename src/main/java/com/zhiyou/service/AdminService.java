package com.zhiyou.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.zhiyou.pojo.Course;

public interface AdminService {
	int select(String accounts,String password,HttpServletRequest req);

	List<Course> selectAll();
}
