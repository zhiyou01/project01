package com.zhiyou.util;

import java.io.IOException;
import java.io.InputStream;
import java.net.SocketException;
import java.util.UUID;

import org.apache.commons.net.ftp.FTPClient;

public class FtpUtil {
	
	public static String upload(InputStream input,String filename) {
		UUID randomUUID = UUID.randomUUID();
		filename=randomUUID.toString().replace("-","")+filename;
		//filename=System.currentTimeMillis()+filename;
		String url="ftp://192.168.124.81/";
		FTPClient ftp = new FTPClient();
		try {
			ftp.connect("192.168.124.81");//∑˛ŒÒ∆˜µÿ÷∑
			ftp.login("admin", "123");//’À∫≈√‹¬Î
			ftp.enterLocalPassiveMode();
			ftp.changeWorkingDirectory("/");
			ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
			ftp.storeFile(filename, input);//
			return url+filename;//
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				ftp.logout();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
	
}
