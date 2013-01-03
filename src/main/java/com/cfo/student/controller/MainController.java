package com.cfo.student.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 主页控制器
 * @author xuyl
 * @date 2013-1-23
 */
@Controller
@RequestMapping("/")
public class MainController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String list(){
		return "index";
	}
}
