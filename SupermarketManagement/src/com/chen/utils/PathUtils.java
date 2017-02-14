package com.chen.utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PathUtils {
	//    /2015/08/25/
	public static String getDatePath(String prefix){
		
		SimpleDateFormat sdf  = new SimpleDateFormat("/yyyy/MM/dd/");
		
		String datePath = sdf.format(new Date());
		//拼装日期完整路径
		String wholePath = prefix+datePath;
		//判断日期文件夹结构是否存在
		File f = new File(wholePath);
		if(!f.exists()){
			// 不存在=>创建文件夹结构
			f.mkdirs();
		}
		
		return datePath;
	}
}
