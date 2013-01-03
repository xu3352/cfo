package com.cfo.common.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cfo.common.beans.PageModel;
import com.cfo.common.dao.MyBatisDao;
import com.cfo.common.exception.BaseException;
import com.cfo.common.service.spi.IService;

/**
 * Service实现类<br/>
 * 实现常用的业务逻辑,扩展的可以通过getSqlSession()来实现.
 * @author xuyl
 * @date 2012-12-12
 */
@Service
@Transactional
public class MyBatisServiceSupport implements IService {
	private static final String _FIND_BY_ID = 	"findById";
	private static final String _SAVE = 		"save";
	private static final String _UPDATE = 		"update";
	private static final String _DELETE_BY_IDS ="deleteByIds";
	private static final String _QUERY_ALL = 	"queryAll";
	private static final String _PAGE 	= 		"page";
	private static final String _PAGE_COUNT = 	"pageCount";
	
	@Autowired
	protected MyBatisDao myBatisDao;
	
	/**
	 * 获取MyBatis的SqlSession,可实现更多的功能
	 * @return SqlSession
	 */
	protected SqlSession getSqlSession() {
		return myBatisDao.getSqlSession();
	}
	
	/**
	 * 获取Mybaits配置文件的ID
	 * @param clazz
	 * @param xmlId
	 * @return clazz.getName() + "." + xmlId
	 */
	@SuppressWarnings("unchecked")
	private static String getXmlKey(Class clazz, String xmlId) {
		return clazz.getName() + "." + xmlId;
	}
	
	/**
	 * 根据xmlId查询
	 * @param <T>
	 * @param xmlId
	 * @param param
	 * @return
	 */
	public <T> T getEntity(String xmlId, Object param) {
		return myBatisDao.get(xmlId, param);
	}

	@Override
	public <T> T find(Class<T> clazz, Object id) {
		return getEntity(getXmlKey(clazz, _FIND_BY_ID), id);
	}
	
	@Override
	public <T> void save(T t) {
		myBatisDao.save(getXmlKey(t.getClass(), _SAVE), t);
	}

	@Override
	public <T> boolean saveBatch(List<T> list) {
		for (T t : list) {
			save(t);
		}
		return true;
	}

	@Override
	public <T> void update(T t) {
		myBatisDao.update(getXmlKey(t.getClass(), _UPDATE), t);
	}
	
	@Override
	public <T> void delete(Class<T> clazz, Object id) {
		deleteByIds(clazz, new Object[]{id});
		
	}

	@Override
	public <T> void deleteByIds(Class<T> clazz, Object[] ids) {
		myBatisDao.delete(getXmlKey(clazz, _DELETE_BY_IDS), ids);
	}

	@Override
	public <T> List<T> queryAll(Class<T> clazz) {
		return myBatisDao.list(getXmlKey(clazz, _QUERY_ALL));
	}

	@Override
	public <T> List<T> page(Class<T> clazz, Object param) {
		if (param instanceof PageModel) {
			PageModel model = (PageModel) param;
			int totalRecords = getEntity(getXmlKey(clazz, _PAGE_COUNT), param);
			model.setTotalRecords(totalRecords);
			return myBatisDao.list(getXmlKey(clazz, _PAGE), param);
		} else {
			throw new BaseException("分页Search请继承PageModel类!");
		}
	}
}
