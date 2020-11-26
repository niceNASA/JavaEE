/**
 * 
 */
package com.oshop.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.oshop.Model.Goods;
//import com.oshop.Model.Users;
import com.oshop.Util.DBUtil;

/**
 * @author Hao
 *
 */
public class GoodDaoImpl implements GoodDao{

	//@SuppressWarnings("null")
	@Override
	public List<Goods> finaAllGoods() {
		
		DBUtil db = new DBUtil();
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		List<Goods> goodslist = new ArrayList<Goods>();
		try {
			conn = db.getConnection();
			conn.setAutoCommit(true);
			st = conn.createStatement();
			rs = st.executeQuery("SELECT * FROM goods");
			
			
			while(rs.next()) {
				Goods singlegood = new Goods();
				singlegood.setId(rs.getInt("id"));
				singlegood.setName(rs.getString("name"));
				//System.out.println(rs.getString("price"));
				singlegood.setPrice(rs.getDouble("price"));
				goodslist.add(singlegood);
				//System.out.println(goodslist.size());
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
		return goodslist;
	}

	@Override
	public Goods findByName(String name) {
		
		DBUtil db = new DBUtil();
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		Goods good = null;
		try {
			conn = db.getConnection();
			conn.setAutoCommit(true);
			st = conn.prepareStatement("SELECT * FROM goods where name=?");
			st.setString(1, name);
			rs = st.executeQuery();
			
			boolean flag = false;
			try {
				flag = rs.isBeforeFirst();	//判断游标当前是否在第一行之前，以此来判断rs是否为空
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			if(flag)	{//在第一行之前,说明不为空
				rs.next();
				System.out.println("Get goods");
				good = new Goods();
				good.setName(name);
				good.setId(rs.getInt("id"));
				good.setPrice(rs.getDouble("price"));
				System.out.println(rs.getDouble("price"));
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
		
		return good;
	}
	
}
