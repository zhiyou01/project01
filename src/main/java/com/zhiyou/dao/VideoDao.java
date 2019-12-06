package com.zhiyou.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zhiyou.pojo.Course;
import com.zhiyou.pojo.Speaker;
import com.zhiyou.pojo.Subject;
import com.zhiyou.pojo.Video;

public interface VideoDao {
	Video selectByVideoid(int video_id);
void add(Video video);
	
	void update(Video video);
	
	int delete(Integer id);
	
	List<Video> selectAll(int page, int number, String title);
	
	Video selectByID(Integer video_id);

	List<Subject> selectSubject();

	List<Speaker> selectSpeaker();

	Subject selectSubjectByName(String subject_name);

	Speaker selectSpeakerByName(String speaker_name);

	int selectCount(String title);
	
	int removeCourse(@Param("userIdList")List<Integer> userIdList);
		
	//��ȡ��Ƶ��ַ�ͽ�ʦ��Ϣ
	List<Video> selectVideoUrl(Integer video_id);
		
	//��ѯ�γ���Ϣ�ͽ�ʦ��Ϣ
	List<Video> selectAlls(Integer id);
}
