package com.chen.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.chen.bean.Othercost;
import com.chen.dao.OthercostDao;
import com.chen.utils.JDBCUtils;

public class OthercostDaoImpl implements OthercostDao {

	public void addOthercost(Othercost othercost) {
		//1获得连接
				Connection conn=JDBCUtils.getConnection();
				//2准备sql
				String sql= "INSERT INTO `t_othercost` VALUES (NULL,?,?,?);";
				PreparedStatement ps=null;
				try {
					//3获得prepareStatemetnt
					ps=conn.prepareStatement(sql);
					//4设置参数
					ps.setString(1, othercost.getOname());
					ps.setDouble(2, othercost.getMoney());
					ps.setString(3, othercost.getOdate());
					//执行sql
					int rowcount=ps.executeUpdate();
					if(rowcount!=1){
						throw new RuntimeException("添加支出失败！");
					}
					} catch (SQLException e) {
						e.printStackTrace();
					}finally{
					//关闭资源
					JDBCUtils.close(conn, ps, null);
					}
	}
}
