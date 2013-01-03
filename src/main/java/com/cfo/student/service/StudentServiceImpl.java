package com.cfo.student.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cfo.common.exception.BaseException;
import com.cfo.common.service.MyBatisServiceSupport;
import com.cfo.student.bean.StudentEntity;
import com.cfo.student.service.spi.IStudentService;

/**
 * Student Service业务逻辑实现
 * @author xuyl
 * @date 2012-12-13
 */
@Service
@Transactional
public class StudentServiceImpl extends MyBatisServiceSupport implements IStudentService {
	
	public void saveStudent(StudentEntity entity) {
		super.save(entity);
		throw new BaseException("saveStudent Error");
	}
	
}
