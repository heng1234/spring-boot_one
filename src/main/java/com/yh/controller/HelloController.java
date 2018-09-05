package com.yh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yh.entity.Student;

@RestController
@RequestMapping("/hello")
public class HelloController {

	@Autowired
	private Student student;
	@RequestMapping("hl")
	public String hello() {
		return student.toString();
	}
}
