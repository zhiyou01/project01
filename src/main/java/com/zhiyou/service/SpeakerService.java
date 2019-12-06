package com.zhiyou.service;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.zhiyou.pojo.Speaker;


public interface SpeakerService {
	Speaker selectBySpeakerid(int id);
	
	
	void add(Speaker speaker);
	
	void update(Speaker speaker);
	
	void delete(Integer id, HttpServletResponse resp);
	
	Speaker selectByID(Integer id);

	int selectCount(String speaker_name);

	List<Speaker> SelectAll(int page,int number,String speaker_name);

	void removeCourse(List<Integer> userIdList, HttpServletResponse resp);
}
