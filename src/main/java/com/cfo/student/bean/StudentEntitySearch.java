package com.cfo.student.bean;

import java.util.Date;

import org.apache.ibatis.type.Alias;

import com.cfo.common.beans.PageModel;

/**
 * StudentSearch
 * @author xuyl
 * @date 2012-12-13
 */
@SuppressWarnings("unchecked")
@Alias("StudentEntitySearch")
public class StudentEntitySearch extends PageModel {
	
	private Integer id;
	private String name;
	private String sex;
	private Date birthday;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
}

