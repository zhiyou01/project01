package com.zhiyou.service;

import java.util.List;

import com.zhiyou.pojo.Course;

public interface CourseService {
	//通过id查找所有信息
	Course selectById(int id);
	//通过学科id查询
	List<Course> selectBySubjectid(int id);
}
