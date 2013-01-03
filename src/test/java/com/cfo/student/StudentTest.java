package com.cfo.student;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.cfo.common.exception.BaseException;
import com.cfo.student.bean.StudentEntity;
import com.cfo.student.bean.StudentEntitySearch;
import com.cfo.student.service.spi.IStudentService;

/**
 * Student JUnit Test<br/>
 * 带事务处理,默认为回滚(MySQL的InnoDB引擎)
 * @author xuyl
 * @date 2012-12-17
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/applicationContext.xml"})
@Transactional  
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public class StudentTest {
	@Autowired
	private IStudentService studentService;
	
	@Test
	public void find() {
		StudentEntity s = studentService.find(StudentEntity.class, 1);
		System.out.println( s );
	}
	
	@Test
	public void queryAll() {
		List<StudentEntity> list = studentService.queryAll(StudentEntity.class);
		System.out.println( list.size() );
	}
	
	@Test(expected = BaseException.class)
	//@Rollback(false)	//引擎:InnoDB
	public void add() {
		try {
			StudentEntity entity = new StudentEntity();
			// entity.setId(11);
			entity.setName("Insertxxx");
			entity.setSex("男");
			entity.setBirthday(new Date()); 
			studentService.saveStudent(entity);
			System.out.println( entity );
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void update() {
		StudentEntity entity = new StudentEntity();
		entity.setId(7);
		entity.setName("How Are You");
		studentService.update(entity);
	}
	
	@Test
	public void page() {
		StudentEntitySearch search = new StudentEntitySearch();
		// search.setPageSize(5);
		search.setPageNo(1);
		// search.setName("s");
		List<StudentEntity> list = studentService.page(StudentEntity.class, search);
		System.out.println(
				"第:"+search.getPageNo()+"页, " +
				"总页数:"+search.getTotalPages()+", " +
				"总记录:"+search.getTotalRecords());
		for (StudentEntity s : list) {
			System.out.println(s);
		}
	}
	
	@Test 
	public void delete() {
		studentService.delete(StudentEntity.class, 30);
		// studentService.deleteByIds(StudentEntity.class, new Object[]{3,5,9});
	}
	
}
