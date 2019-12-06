package com.zhiyou.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhiyou.pojo.Admin;
import com.zhiyou.pojo.Course;
import com.zhiyou.pojo.Subject;
import com.zhiyou.pojo.User;

public interface AdminService {

	boolean select(String accounts, String pwd, HttpServletRequest req);
	
	boolean selectaccounts(String accounts);

	Course selectByID(Integer id);
	
	Course selectCourseByID( Integer id);

	void update(Course course);

	void add(Course course);

	List<Subject> selectSubject();

	Subject selectName(String subject_name);

	void delCourse(Integer id, HttpServletResponse resp);

	int selectCount(String course_title);

	List<Course> SelectAll(int page,int number, String course_title);


	void removeCourse(List<Integer> userIdList,HttpServletResponse resp);
}
