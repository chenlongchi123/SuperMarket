package com.chen.web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.chen.bean.User;
import com.chen.service.UserService;
import com.chen.service.impl.UserServiceImpl;
import com.chen.utils.CheckUtils;

public class LoginServlet extends HttpServlet {
	private UserService uService=new UserServiceImpl();
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User u=new User();
		try {
			request.setCharacterEncoding("UTF-8");
			BeanUtils.populate(u, request.getParameterMap());
		} catch (IllegalAccessException | InvocationTargetException e) {
			
			e.printStackTrace();
		}
		Map<String, String> errors=CheckUtils.checkUser(u);
		if(errors.size()>0){
			//将错误信息放到request域中，转发到注册页显示
			request.setAttribute("errors", errors);
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return;
		}
		//调用service保存
		User existU=null;
		try {
			existU=uService.login(u);
		} catch (Exception e) {
			//将错误信息放到request域中，转发到注册页显示
			request.setAttribute("error", e.getMessage());
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return;
		}
		request.getSession().setAttribute("user", existU);
		//根据结果，跳转到页面
		response.setCharacterEncoding("UTF-8");
		response.sendRedirect(request.getContextPath()+"/Main.html");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
