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
			

			//ͨ���ļ���һ��������
			InputStream input = filename.getInputStream();
			//ָ���ļ���ŵ�·�����ļ�����
		    String name="D:/"+System.currentTimeMillis()+filename.getOriginalFilename();
			//�����ļ���Ҫ��ŵ�·�����һ�������
		    OutputStream output = new FileOutputStream(name);
		    //ʹ��io���� ����������������������Զ������ļ�copy����
		    IOUtils.copy(input, output);
		    
		    System.out.println("��Ҫ��ŵ����ݿ�����ļ����ƺ��ļ�·��");
	        input.close();
	        output.close();
			return name;
		}
	}
	

