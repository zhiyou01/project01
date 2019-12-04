package com.zhiyou.pojo;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	
	Integer id;
	String	accounts;
	String	phone;
	String	password;
	String	nickname;
	String	sex;
	String	birthday;
	String	address;
	String	imgurl;
	Timestamp createtime;
}
