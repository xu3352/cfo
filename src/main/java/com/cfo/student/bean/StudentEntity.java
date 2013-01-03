package com.cfo.student.bean;

import java.io.Serializable;
import java.util.Date;

import org.apache.ibatis.type.Alias;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.cfo.common.beans.BaseEntity;
import com.cfo.common.util.ShortDateSerializer;

@SuppressWarnings("serial")
@Alias("StudentEntity")
public class StudentEntity extends BaseEntity implements Serializable {

	private String name;
	private String sex;
	private Date birthday;

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

	@JsonSerialize(using = ShortDateSerializer.class)
	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@Override
	public String toString() {
		return "StudentEntity [id="+ getId() +", name=" + name + ", sex=" + sex + ", birthday=" + birthday + "]";
	}
}

