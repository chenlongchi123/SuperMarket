package com.chen.utils;

import java.util.HashMap;
import java.util.Map;

import com.chen.bean.User;

public class CheckUtils {
	public static Map<String, String > checkUser(User u){
		Map<String, String > map=new HashMap<String,String>();
		//��֤�û�����Ϊ��
		if(u.getName()==null || "".equals(u.getName().trim())){
			map.put("name", "�û�������Ϊ��");
		}
		//��֤���벻Ϊ��
		if(u.getPassword()==null || "".equals(u.getPassword().trim())){
			map.put("password", "���벻��Ϊ��");
		}
		return map;
	}
}
