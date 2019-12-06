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
	//��ѯȫ�����ݵ�Subject
	List<Subject> selectSubject();
	//��Ѱȫ��Speaker
	List<Speaker> selectSpeaker();
	//���ݴ�������nameȥ����Subject�е�id
	Subject selectSubjectByName(String subject_name);
	//���ݴ�������nameȥ����Speaker�е�id
	Speaker selectSpeakerByName(String speaker_name);

	int selectCount(String title);

	void removeCourse(List<Integer> userIdList, HttpServletResponse resp);

	//��ȡ��Ƶ��ַ�ͽ�ʦ��Ϣ
	List<Video> selectVideoUrl(Integer video_id);
		
	//��ѯ�γ���Ϣ�ͽ�ʦ��Ϣ
	List<Video> selectAlls(Integer id);
}
