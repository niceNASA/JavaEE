/**
 * 
 */
package com.oshop.Dao;
import java.util.List;

import com.oshop.Model.Goods;
/**
 * @author Hao
 *
 */
public interface GoodDao {

	/**
	 * 查询所有商品信息
	 * @return
	 */
	List<Goods> finaAllGoods();
	
	/**
	 * 查找商品
	 */
	Goods findByName(String name);
}
