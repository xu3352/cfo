package com.cfo.student.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cfo.common.beans.ExtParam;
import com.cfo.student.bean.StudentEntity;
import com.cfo.student.bean.StudentEntitySearch;
import com.cfo.student.service.spi.IStudentService;

/**
 * Student 控制器
 * @author xuyl
 * @date 2012-12-13
 */
@Controller
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private IStudentService studentServiceImpl;
	
	@RequestMapping(method = RequestMethod.GET)
	public String list(Model model, StudentEntitySearch search){
		if (search == null) {
			search = new StudentEntitySearch();
			// search.setPageSize(20);
		}
		model.addAttribute("list", studentServiceImpl.page(StudentEntity.class, search));
		return "student/list";
	}
	
	@ResponseBody
	@RequestMapping(value="/list/json", method = RequestMethod.GET)
	public StudentEntitySearch listJson(ExtParam param, StudentEntitySearch search){
		System.out.println(param);
		System.out.println(search);
		if (search == null) {
			search = new StudentEntitySearch();
		}
		search.setPageNo(param.getPage());
		search.setPageSize(param.getLimit());
		search.setSort(" order by "+param.getSort()+" "+param.getDir());
		search.setResult(studentServiceImpl.page(StudentEntity.class, search));
		return search;
	}
	
	@RequestMapping(value="/add", method = RequestMethod.POST)
	public String add(StudentEntity student) {
		studentServiceImpl.save(student);
		return "redirect:/student";
	}
	
	@RequestMapping(value="/update", method = RequestMethod.POST)
	public String update(StudentEntity student) {
		studentServiceImpl.update(student);
		return "redirect:/student";
	}
	
	@RequestMapping(value="/del/{id}", method = RequestMethod.GET)
	public String del(Model model, @PathVariable Integer id) {
		studentServiceImpl.delete(StudentEntity.class, id);
		return "redirect:/student";
	}
	
	@ResponseBody
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public StudentEntity getJson(Model model, @PathVariable Integer id){
		return studentServiceImpl.find(StudentEntity.class, id);
	}
	
	/**
	 * 后台接收Date转换
	 */
	@InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }
}
