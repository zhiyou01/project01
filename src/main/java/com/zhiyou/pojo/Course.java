package com.zhiyou.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {

	Integer	id;
	String	course_title;
	String	course_desc;
	Integer	subject_id;
}
