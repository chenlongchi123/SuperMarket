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
	//创建配置工厂
		DiskFileItemFactory factory=new DiskFileItemFactory();
		//创建解析器
		ServletFileUpload upload=new ServletFileUpload(factory);
		//解析request
		List<FileItem> list=null;
		try {
			list =  upload.parseRequest(request);
		} catch (FileUploadException e) {
			throw new RuntimeException("您操作有误");
		}
		//遍历fileitem
		if(list!=null){
			for(FileItem item :list){
				if (!item.isFormField()) {
					//文件上传
					//将文件保存到项目根目录下的upload文件夹下
					//获得upload文件夹路径
					String uploadPath=getServletContext().getRealPath("/upload");
					//生成日期目录
					String datePath=PathUtils.getDatePath(uploadPath);
					//生成图片名称
					String filename=UUID.randomUUID().toString();
					//保存图片
					InputStream iStream=item.getInputStream();
					FileOutputStream oStream=new FileOutputStream(uploadPath+datePath+filename);
					IOUtils.copy(iStream,oStream);
					//保存访问路径到product对象中
					goods.setImgurl("/upload"+datePath+filename);
					iStream.close();
					oStream.close();
					item.delete();	
				}else {
					//是普通表单
					//将每个普通表单项的键值对都获取到
					String key=item.getFieldName();
					String value = item.getString("UTF-8");
					//将他们封装到Map中
					parameterMap.put(key, new String[]{value});
				}
			}
		}
		//调用beanutils将参数封装到goods对象中
		try {
			BeanUtils.populate(goods, parameterMap);
		}  catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		//校验=> 非空校验
		
				//调用service保存
		gs.addGoods(goods);
		//重定向到列表Servlet
				response.sendRedirect(request.getContextPath()+"/ListServlet");
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
