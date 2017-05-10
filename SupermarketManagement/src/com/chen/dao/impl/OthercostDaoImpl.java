package com.chen.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.chen.bean.Othercost;
import com.chen.dao.OthercostDao;
import com.chen.utils.JDBCUtils;

public class OthercostDaoImpl implements OthercostDao {

	public void addOthercost(Othercost othercost) {
		//1�������
				Connection conn=JDBCUtils.getConnection();
				//2׼��sql
				String sql= "INSERT INTO `t_othercost` VALUES (NULL,?,?,?);";
				PreparedStatement ps=null;
				try {
					//3���prepareStatemetnt
					ps=conn.prepareStatement(sql);
					//4���ò���
					ps.setString(1, othercost.getOname());
					ps.setDouble(2, othercost.getMoney());
					ps.setString(3, othercost.getOdate());
					//ִ��sql
					int rowcount=ps.executeUpdate();
					if(rowcount!=1){
						throw new RuntimeException("���֧��ʧ�ܣ�");
					}
					} catch (SQLException e) {
						e.printStackTrace();
					}finally{
					//�ر���Դ
					JDBCUtils.close(conn, ps, null);
					}
	}
}
