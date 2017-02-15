package com.chen.dao;

import com.chen.bean.User;


public interface UserDao {
	//保存用户对象
	void save(User u );
	//根据用户名查询用户
	User getUserByName(String name);
}
