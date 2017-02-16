package com.chen.web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.chen.bean.User;
import com.chen.service.UserService;
import com.chen.service.impl.UserServiceImpl;
import com.chen.utils.CheckUtils;


public class RegisterServlet extends HttpServlet {
	private UserService uService= new UserServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//��װ����uer����
		User u=new User();
		try {
			request.setCharacterEncoding("UTF-8");
			BeanUtils.populate(u, request.getParameterMap());
		} catch (IllegalAccessException e) {	
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		//У��
		Map<String, String> errors=CheckUtils.checkUser(u);
		if(errors.size()>0){
			//��������Ϣ�ŵ�request���У�ת����ע��ҳ��ʾ
			request.setAttribute("errors", errors);
			request.getRequestDispatcher("/register.jsp").forward(request, response);
			return;
		}
		//����service����
		try {
			uService.regist(u);
		} catch (Exception e) {
			//��������Ϣ�ŵ�request���У�ת����ע��ҳ��ʾ
			request.setAttribute("error", e.getMessage());
			request.getRequestDispatcher("/register.jsp").forward(request, response);
			return;
		}
		//���ݽ������ת��ҳ��
		response.sendRedirect(request.getContextPath()+"/login.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
