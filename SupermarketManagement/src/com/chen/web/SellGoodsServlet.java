package com.chen.web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.chen.bean.Goods;
import com.chen.service.GoodsService;
import com.chen.service.impl.GoodsServiceImpl;


public class SellGoodsServlet extends HttpServlet {
		GoodsService gs=new GoodsServiceImpl();
		protected void doGet(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			Goods goods=new Goods();
			request.setCharacterEncoding("UTF-8");
			String format=request.getParameter("format");
			Map<String, String[]> parameterMap=new HashMap<String,String[]>();
			if("json".equals(format)){
		
			/*
			//调用beanutils将参数封装到goods对象中
			try {
				BeanUtils.populate(goods, parameterMap);
			}  catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}*/
				String id1 =request.getParameter("id");
				int id = Integer.parseInt(id1);
				String odate =request.getParameter("odate");
				goods.setId(id);
				
			//校验=> 非空校验
			
					//调用service保存
			gs.sellGoods(id, odate);
			//重定向到列表Servlet
					
					request.getRequestDispatcher("/WEB-INF/page/sellHistory.jsp?format=json").forward(request, response);
			}else {
				request.setCharacterEncoding("UTF-8");
				try {
					BeanUtils.populate(goods, request.getParameterMap());
					int id=goods.getId();
					String odate=goods.getOdate();
					gs.sellGoods(id, odate);
					request.getRequestDispatcher("/WEB-INF/page/sellHistory.jsp?format=json").forward(request, response);
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
							
		}

		
		protected void doPost(HttpServletRequest request, HttpServletResponse response) 
				throws ServletException, IOException {
			
			doGet(request, response);
		}

	}

