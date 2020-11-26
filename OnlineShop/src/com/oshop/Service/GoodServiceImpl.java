/**
 * GoodServiceImpl.java
 */
package com.oshop.Service;

import java.util.List;

import com.oshop.Model.Goods;
import com.oshop.Dao.GoodDao;
import com.oshop.Dao.GoodDaoImpl;

/**
 * @author Hao
 *
 */
public class GoodServiceImpl implements GoodService {

	GoodDao dao = new GoodDaoImpl();
	
	@Override
	public List<Goods> findAllGoods() {
		// TODO Auto-generated method stub
		return dao.finaAllGoods();
	}

	@Override
	public Goods findByName(String name) {
		// TODO Auto-generated method stub
		return dao.findByName(name);
	}
	
}
