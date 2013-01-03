package com.cfo.common.dao;

import java.util.List;

/**
 * 操作数据库统一DAO接口
 * @author xuyl
 * @date 2012-12-12
 */
public interface DAO {
	
	void save(String key, Object obj);
	
	void update(String key, Object obj);

	void delete(String key, Object obj);
	
	/**
	 * 查询一条数据
	 * @param <T>
	 * @param key
	 * @param obj
	 * @return
	 */
	<T> T get(String key, Object obj);
	
	<T> List<T> list(String key);

	<T> List<T> list(String key, Object params);
}
