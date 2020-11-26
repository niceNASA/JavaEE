/**
 * GoodService.java
 */
package com.oshop.Service;

import java.util.List;

import com.oshop.Model.Goods;

/**
 * @author Hao
 *
 */
public interface GoodService {
	/**
	 * 查询所有商品
	 * @return
	 */
	List<Goods> findAllGoods();
	
	/**
	 * 查找商品
	 */
	Goods findByName(String name);
}
