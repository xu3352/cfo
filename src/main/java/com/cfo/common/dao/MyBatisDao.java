package com.cfo.common.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;


/**
 * MyBatis Dao实现
 * @author xuyl
 * @date 2012-12-12
 */
@Repository
public class MyBatisDao extends SqlSessionDaoSupport implements DAO {
	
	@Override
	public void save(String key, Object obj) {
		getSqlSession().insert(key, obj);
	}
	
	@Override
	public void update(String key, Object obj) {
		getSqlSession().update(key, obj);
	}

	@Override
	public void delete(String key, Object obj) {
		getSqlSession().delete(key, obj);
	}
	
	@Override
	public <T> T get(String key, Object obj) {
		return getSqlSession().selectOne(key, obj);
	}

	@Override
	public <T> List<T> list(String key, Object params) {
		return getSqlSession().selectList(key, params);
	}

	@Override
	public <T> List<T> list(String key) {
		return getSqlSession().selectList(key);
	}
}
