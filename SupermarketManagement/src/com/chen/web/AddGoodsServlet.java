package com.chen.web;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;

import com.chen.bean.Goods;
import com.chen.service.GoodsService;
import com.chen.service.impl.GoodsServiceImpl;
import com.chen.utils.PathUtils;



public class AddGoodsServlet extends HttpServlet {
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
			String name =request.getParameter("name");
			String price =request.getParameter("price");
			String pnum =request.getParameter("pnum");
			String type =request.getParameter("type");
			String img =request.getParameter("img");
			String description =request.getParameter("description");
			String price2 =request.getParameter("price2");
			Double price1=Double.parseDouble(price);
			Double price3=Double.parseDouble(price2);
			int pnum1 = Integer.parseInt(pnum);
			goods.setName(name);
			goods.setPrice(price1);
			goods.setPrice2(price3);
			goods.setPnum(pnum1);
			goods.setType(type);
			goods.setImgurl(img);
			goods.setDescription(description);
		//校验=> 非空校验
		
				//调用service保存
		gs.addGoods(goods);
		//重定向到列表Servlet
				response.sendRedirect(request.getContextPath()+"/ListServlet?format=json");
		}else {
			request.setCharacterEncoding("UTF-8");
			try {
				BeanUtils.populate(goods, request.getParameterMap());
				gs.addGoods(goods);
				response.sendRedirect(request.getContextPath()+"/ListServlet");
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
