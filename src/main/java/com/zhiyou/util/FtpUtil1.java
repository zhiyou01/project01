package com.zhiyou.util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.SocketException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.apache.commons.net.ftp.FTPClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

public class FtpUtil1 {
	
public static String upload(MultipartFile filename,HttpServletRequest req,HttpServletResponse resp) throws IOException {
			

			//通过文件打开一个输入流
			InputStream input = filename.getInputStream();
			//指定文件存放的路径及文件名称
		    String name="D:/"+System.currentTimeMillis()+filename.getOriginalFilename();
			//根据文件需要存放的路径获得一个输出流
		    OutputStream output = new FileOutputStream(name);
		    //使用io工具 放入输入流、输出流让其自动进行文件copy操作
		    IOUtils.copy(input, output);
		    
		    System.out.println("需要存放到数据库的是文件名称和文件路径");
	        input.close();
	        output.close();
			return name;
		}
	}
	

