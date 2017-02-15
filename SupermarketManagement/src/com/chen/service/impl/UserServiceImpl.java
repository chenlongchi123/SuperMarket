package com.chen.service.impl;

import com.chen.bean.User;
import com.chen.dao.UserDao;
import com.chen.dao.impl.UserDaoImpl;
import com.chen.service.UserService;

public class UserServiceImpl implements UserService{

	private UserDao uDao=new UserDaoImpl();
	public void regist(User u) {
	
		//У���û������ظ�
		User existU=uDao.getUserByName(u.getName());
		if(existU!=null){
			//�û�������
			throw new RuntimeException("�û�������");
		}
		//����dao��ִ�б���
		uDao.save(u);
	}

	public User login(User u) {
		//
		User existU=uDao.getUserByName(u.getName());
		if(existU==null){
			//�û�������
			throw new RuntimeException("�û���������");
		}
		if(!existU.getPassword().equals(u.getPassword())){
			throw new RuntimeException("���벻��ȷ");
		}
		return existU;
	}

}
