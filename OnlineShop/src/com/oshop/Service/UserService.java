/**
 * 
 */
package com.oshop.Service;

import java.util.List;

import com.oshop.Model.Users;

/**
 * @author Hao
 *
 */
public interface UserService {
	 /**
     * 添加客户信息
     * @param c
     */
    void addUsers(Users c);
    /**
     * 修改客户的信息
     * @param c
     * @throws IdIsNullException 如果c的id为null,抛出此异常
     */
    void updateUsers(Users c);
    /**
     * 删除客户信息
     * @param CustomerId 主键
     */
    void deleteUsers(String CustomerId);
    /**
     * 根据主键查询客户信息
     * @param CustomerId
     * @return 如果没有,返回null
     */
    Users findUsersById(String CustomerId);
    /**
     * 查询所有客户信息
     * @return
     */
    List<Users> findAllUsers();
    
    Users findByNameAndPass(String name,String password);
	
}
