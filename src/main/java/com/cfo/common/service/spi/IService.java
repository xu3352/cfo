package com.cfo.common.service.spi;

import java.util.List;

/**
 * Service接口
 * @author xuyl
 * @date 2012-12-12
 */
public interface IService {

	/**
	 * 查询
	 * @param <T>
	 * @param id
	 * @return
	 */
	<T> T find(Class<T> clazz, Object id);
	
	/**
	 * 查询所有数据
	 * @param <T>
	 * @return
	 */
	<T> List<T> queryAll(Class<T> clazz);
	
	/**
	 * 新增
	 * @param <T>
	 * @param t
	 */
	<T> void save(T t);

	/**
	 * 批量新增
	 * @param <T>
	 * @param list
	 * @return
	 */
	<T> boolean saveBatch(List<T> list);
	
	/**
	 * 删除
	 * @param <T>
	 * @param clazz
	 * @param id
	 */
	<T> void delete(Class<T> clazz, Object id);
	
	/**
	 * 批量删除
	 * @param <T>
	 * @param clazz
	 * @param ids
	 */
	<T> void deleteByIds(Class<T> clazz, Object[] ids);
	
	/**
	 * 修改
	 * @param <T>
	 * @param t
	 */
	<T> void update(T t);
	
	/**
	 * 分页
	 * @param <T>
	 * @param clazz
	 * @param param
	 * @return
	 */
	<T> List<T> page(Class<T> clazz, Object param);
}
