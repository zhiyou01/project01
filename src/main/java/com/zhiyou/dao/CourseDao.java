package com.zhiyou.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zhiyou.pojo.Course;

public interface CourseDao {
	//ͨ��id����������Ϣ
	Course selectById(@Param("id")int id);
	//ͨ��ѧ��id��ѯ
	List<Course> selectBySubjectid(int id);
}
