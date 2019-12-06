package com.zhiyou.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zhiyou.pojo.Admin;
import com.zhiyou.pojo.Course;
import com.zhiyou.pojo.Subject;

public interface AdminDao {
	Admin select(String accounts);

	List<Course> selectAll(int page, int number, String course_title);

	Course selectByID(Integer id);
	
	Course selectCourseByID(int id);

	void update(Course course);

	void add(Course course);

	List<Subject> selectSubject();

	Subject selectName(String subject_name);

	int delCourse(Integer id);

	int selectCount(String course_title);

	int removeCourse(@Param("userIdList")List<Integer> userIdList);
}
