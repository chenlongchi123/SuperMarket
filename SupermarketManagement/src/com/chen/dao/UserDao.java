package com.chen.dao;

import com.chen.bean.User;


public interface UserDao {
	//�����û�����
	void save(User u );
	//�����û�����ѯ�û�
	User getUserByName(String name);
}
