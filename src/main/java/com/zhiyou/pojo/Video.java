package com.zhiyou.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Video {
    Integer	video_id;
	String	title;
	String	detail;
	Integer	time;
	Integer	speaker_id;
	Integer	course_id;
	String	video_url;
	String	image_url;
	Integer	play_num;
}
