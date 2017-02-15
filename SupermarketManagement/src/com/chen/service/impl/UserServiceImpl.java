package com.chen.service.impl;

import com.chen.bean.User;
import com.chen.dao.UserDao;
import com.chen.dao.impl.UserDaoImpl;
import com.chen.service.UserService;

public class UserServiceImpl implements UserService{

	private UserDao uDao=new UserDaoImpl();
	public void regist(User u) {
	
		//校验用户名不重复
		User existU=uDao.getUserByName(u.getName());
		if(existU!=null){
			//用户名存在
			throw new RuntimeException("用户名存在");
		}
		//调用dao，执行保存
		uDao.save(u);
	}

	public User login(User u) {
		//
		User existU=uDao.getUserByName(u.getName());
		if(existU==null){
			//用户名存在
			throw new RuntimeException("用户名不存在");
		}
		if(!existU.getPassword().equals(u.getPassword())){
			throw new RuntimeException("密码不正确");
		}
		return existU;
	}

}
