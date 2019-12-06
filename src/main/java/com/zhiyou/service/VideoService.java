package com.zhiyou.service;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.zhiyou.pojo.Speaker;
import com.zhiyou.pojo.Subject;
import com.zhiyou.pojo.Video;

public interface VideoService {
	Video selectByVideoid(int video_id);

void add(Video video);
	
	void update(Video video);
	
	void delete(Integer id, HttpServletResponse resp);
	
	List<Video> selectAll( int page, int number, String title);
	
	Video selectByID(Integer video_id);
	//查询全部内容的Subject
	List<Subject> selectSubject();
	//查寻全部Speaker
	List<Speaker> selectSpeaker();
	//根据传过来的name去查找Subject中的id
	Subject selectSubjectByName(String subject_name);
	//根据传过来的name去查找Speaker中的id
	Speaker selectSpeakerByName(String speaker_name);

	int selectCount(String title);

	void removeCourse(List<Integer> userIdList, HttpServletResponse resp);

	//获取视频地址和教师信息
	List<Video> selectVideoUrl(Integer video_id);
		
	//查询课程信息和教师信息
	List<Video> selectAlls(Integer id);
}
