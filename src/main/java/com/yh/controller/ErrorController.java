package com.yh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yh.pojo.HlvyJSONResult;

@RequestMapping("error")
@Controller
public class ErrorController {
	/**
	 * 不是ajax形式访问
	 * @return
	 */
	@RequestMapping("err")
	public String error() {
		
		int res = 1 / 0;
		return "/error/error";
	}
	@RequestMapping("toajaxError")
	public String toajaxError() {
		
		
		return "thymeleaf/error/ajaxError";
	}

	/**
	 * ajax
	 */
	@RequestMapping("ajaxError")
	@ResponseBody
	public HlvyJSONResult ajaxError() {
		
		int res = 1 / 0;
		return HlvyJSONResult.ok();
	}
}
