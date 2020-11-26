/**
 * UserDaoImplement
 */
package com.oshop.Dao;

import java.util.List;
import java.sql.*;

import com.oshop.Model.Users;
import com.oshop.Util.DBUtil;

/**
 * @author Hao
 *
 */
public class UserDaoImpl implements UserDao{

	@Override
	public void addUser(Users u) {
		// TODO Auto-generated method stub
		DBUtil db = new DBUtil();
		Connection conn = null;
		PreparedStatement st = null;
		try {
			conn = db.getConnection();
			conn.setAutoCommit(true);
			st = conn.prepareStatement("INSERT into users(user,password) values(?,?)");
			st.setString(1, u.getUser());
			st.setString(2, u.getPassword());
			System.out.println(u.getUser());
			System.out.println(u.getPassword());
			st.executeUpdate();
		}catch(Exception e) {
			System.out.println("error"+e.toString());
		}finally {
			if(st!=null) {
				try {
					st.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public void updateUser(Users c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUser(String Id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Users> findAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Users findByNameAndPass(String name, String password) {
		// TODO Auto-generated method stub
		DBUtil db = new DBUtil();
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		Users user = null;
		try {
			conn = db.getConnection();
			conn.setAutoCommit(true);
			st = conn.prepareStatement("SELECT * FROM users where user=? AND password=?");
			st.setString(1, name);
			st.setString(2, password);
			rs = st.executeQuery();
			
			boolean flag = false;
			try {
				flag = rs.isBeforeFirst();	//判断游标当前是否在第一行之前，以此来判断rs是否为空
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			if(flag)	{//在第一行之前,说明不为空
				System.out.println("Get User");
				user = new Users();
				user.setUser(name);
				user.setPassword(password);
				//user.setId(rs.getInt("id"));
			}
		}catch(Exception e) {
			System.out.println("error"+e.toString());
		}finally {
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(st!=null) {
				try {
					st.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		
		
		return user;
	}

}
