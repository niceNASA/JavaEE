/**
 * 
 */
package com.oshop.Dao;

import java.util.List;

//import com.oshop.Model.Goods;
import com.oshop.Model.Users;

/**
 * @author Hao
 *
 */
public interface UserDao {
	/**
     * 把客户信息保存到数据库中
     * @param c
     */
    void addUser(Users c);
    /**
     * 修改数据库中客户的信息
     * @param c
     * @throws IdIsNullException 如果c的id为null,抛出此异常
     */
    void updateUser(Users c) ;
    /**
     * 删除客户信息
     * @param CustomerId 主键
     */
    void deleteUser(String Id);
    /**
     * 查询所有客户信息
     * @return
     */
    List<Users> findAllUsers();
    
    Users findByNameAndPass(String name,String password);
}
