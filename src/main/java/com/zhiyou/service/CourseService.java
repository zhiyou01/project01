package com.zhiyou.service;

import java.util.List;

import com.zhiyou.pojo.Course;

public interface CourseService {
	//ͨ��id����������Ϣ
	Course selectById(int id);
	//ͨ��ѧ��id��ѯ
	List<Course> selectBySubjectid(int id);
}
