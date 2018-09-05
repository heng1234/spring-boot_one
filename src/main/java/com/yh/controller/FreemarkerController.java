package com.yh.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yh.entity.Student;
/**
 * Freemarker 测试
 * @author heng
 *
 */
@Controller
@RequestMapping("freemarker")
public class FreemarkerController {
	
	@Autowired
	private Student student;
	
	@RequestMapping("toIndex")
	public String toIndex(ModelMap mode) {
		
		System.out.println(student);
		mode.addAttribute("student", student);
		return "freemarker/index";
	}
	

}
