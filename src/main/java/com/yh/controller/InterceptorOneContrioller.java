package com.yh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/lznone")
public class InterceptorOneContrioller {
	
	@RequestMapping("findOne")
	@ResponseBody
	public String  findOne() {
		
		
		return "one";
	}

}
