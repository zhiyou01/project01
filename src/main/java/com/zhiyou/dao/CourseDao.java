package com.zhiyou.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zhiyou.pojo.Course;

public interface CourseDao {
	//通过id查找所有信息
	Course selectById(@Param("id")int id);
	//通过学科id查询
	List<Course> selectBySubjectid(int id);
}
