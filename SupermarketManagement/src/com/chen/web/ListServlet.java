package com.chen.web;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.chen.bean.Goods;
import com.chen.bean.User;
import com.chen.service.GoodsService;
import com.chen.service.impl.GoodsServiceImpl;

import net.sf.json.JSONArray;


public class ListServlet extends HttpServlet {
	private GoodsService gService=new GoodsServiceImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User u=(User)request.getSession().getAttribute("user");
		request.setCharacterEncoding("UTF-8");
//		if(u==null){
//			response.sendRedirect("/login.jsp");
//			return;
//		}
		String format=request.getParameter("format");
		//1根据service获得商品列表
		List<Goods> list=gService.getAll();
		if("json".equals(format)){
		
		//2将商品列表放入request域
		String json=JSONArray.fromObject(list).toString();
		request.setAttribute("json", json);
		
		//3转发到list.jsp
		request.getRequestDispatcher("/WEB-INF/page/list.jsp").forward(request, response);
		}else {
            request.setAttribute("list", list);
            request.getRequestDispatcher("/list2.jsp").forward(request, response);
        }

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
