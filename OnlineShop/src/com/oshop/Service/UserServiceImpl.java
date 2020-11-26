/**
 * 
 */
package com.oshop.Service;

import java.util.List;

import com.oshop.Model.Users;
import com.oshop.Dao.UserDao;
import com.oshop.Dao.UserDaoImpl;

/**
 * @author Hao
 *
 */
public class UserServiceImpl implements UserService{

	private UserDao dao = new UserDaoImpl();	//定义一个dao实例
	
	@Override
	public void addUsers(Users c) {
		// TODO Auto-generated method stub
		dao.addUser(c);
	}

	@Override
	public void updateUsers(Users c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUsers(String CustomerId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Users findUsersById(String CustomerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Users> findAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Users findByNameAndPass(String name, String password) {
		// TODO Auto-generated method stub
		Users user = null;
		user = dao.findByNameAndPass(name,password);
		return user;
	}

}
