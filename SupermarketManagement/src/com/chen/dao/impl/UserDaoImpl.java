package com.chen.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.chen.bean.User;
import com.chen.dao.UserDao;
import com.chen.utils.JDBCUtils;

public class UserDaoImpl implements UserDao {


	public void save(User u) {
		//�������
		Connection conn=JDBCUtils.getConnection();
		//׼��sql
		String sql="INSERT INTO `t_user`  (`name`, `password`,`email`,`sex`,`idtype`,`idcard`,`selectp`,`selectc`,`birthday`,`postal`) VALUES (?,?,?,?,?,?,?,?,?,?);";
		//���preparestatement����
		PreparedStatement pStatement=null;
		try {
			 pStatement=conn.prepareStatement(sql);
		//���ò���
			pStatement.setString(1, u.getName());
			pStatement.setString(2, u.getPassword());
			pStatement.setString(3, u.getEmail());
			pStatement.setString(4, u.getSex());
			pStatement.setString(5, u.getIdtype());
			pStatement.setInt(6, u.getIdcard());
			pStatement.setString(7, u.getSelectp());
			pStatement.setString(8, u.getSelectc());
			pStatement.setString(9, u.getBirthday());
			pStatement.setString(10, u.getPostal());
			//ִ��sql
			int result=pStatement.executeUpdate();
			if(result !=1){
				throw new RuntimeException("�����û�ʧ��");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("�����û�ʧ��");
		}finally {
			//�ر�����
			JDBCUtils.close(conn, pStatement, null);
		}
	
	}


	public User getUserByName(String name) {
		User u=null;
	//�������
		Connection conn=JDBCUtils.getConnection();
		//��дsql
		String sql="select * from `t_user`  where name=?";
		//���preparestatement����
	
				PreparedStatement pStatement=null;
				ResultSet rSet=null;
				try {
					 pStatement=conn.prepareStatement(sql);
				//���ò���
					pStatement.setString(1,name);

					//ִ��sql
					rSet=pStatement.executeQuery();
					//���������װ��user����
					if(rSet.next()){
						//������
						u=new User();
						u.setName(rSet.getString("name"));
						u.setPassword(rSet.getString("password"));
						u.setEmail(rSet.getString("email"));
						u.setSex(rSet.getString("sex"));
						u.setIdtype(rSet.getString("idtype"));
						u.setIdcard(rSet.getInt("idcard"));
						u.setSelectp(rSet.getString("selectp"));
						u.setSelectc(rSet.getString("selectc"));
						u.setBirthday(rSet.getString("birthday"));
						u.setPostal(rSet.getString("postal"));
						u.setStatus(rSet.getString("status"));
						u.setId(rSet.getInt("id"));
						
					}
					return u;
				} catch (Exception e) {
					e.printStackTrace();
					throw new RuntimeException("��ѯ�û�ʧ��");
				}finally {
					//�ر�����
					JDBCUtils.close(conn, pStatement, rSet);
				}
		
	}

}
