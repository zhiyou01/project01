package com.zhiyou.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou.dao.CourseDao;
import com.zhiyou.pojo.Course;
import com.zhiyou.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService {
	@Autowired
	CourseDao dao;
	
	public Course selectById(int id) {
		return dao.selectById(id);
	}

	public List<Course> selectBySubjectid(int id) {
		return dao.selectBySubjectid(id);
	}

}
