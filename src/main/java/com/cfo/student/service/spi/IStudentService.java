package com.cfo.student.service.spi;

import com.cfo.common.service.spi.IService;
import com.cfo.student.bean.StudentEntity;

/**
 * StudentService接口
 * @author xuyl
 * @date 2012-12-13
 */
public interface IStudentService extends IService {

	/**
	 * 添加
	 * @param entity
	 */
	void saveStudent(StudentEntity entity);
	
}
