package com.zhiyou.dao;

import java.util.List;

import com.zhiyou.pojo.Admin;
import com.zhiyou.pojo.Course;

public interface AdminDao {
	Admin select(String accounts);

	List<Course> selectAll();
}
