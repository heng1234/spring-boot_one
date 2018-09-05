package com.yh.controller;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yh.entity.User;

@Controller
@RequestMapping("thymeleaf")
public class ThymeleafController {

	@RequestMapping("finduser")
	public String finduser(ModelMap map) {
		User u = new User();
		u.setName("heng");
		u.setAge(21);
		u.setUrl("https://blog.csdn.net/qq_39313596");
		u.setDesc("<a href='https://blog.csdn.net/qq_39313596'>博客地址</a>");
		map.addAttribute("u",u);
		
		java.util.List<User> list = new ArrayList<User>();
		User u2 = new User();
		u2.setName("heng");
		u2.setAge(17);
		u2.setUrl("https://blog.csdn.net/qq_39313596");
		u2.setDesc("<a href='https://blog.csdn.net/qq_39313596'>博客地址</a>");
		User u3 = new User();
		u3.setName("heng");
		u3.setAge(19);
		u3.setUrl("https://blog.csdn.net/qq_39313596");
		u3.setDesc("<a href='https://blog.csdn.net/qq_39313596'>博客地址</a>");
		User u4 = new User();
		u4.setName("heng");
		u4.setAge(21);
		u4.setUrl("https://blog.csdn.net/qq_39313596");
		u4.setDesc("<a href='https://blog.csdn.net/qq_39313596'>博客地址</a>");
		list.add(u2);
		list.add(u3);
		list.add(u4);
		map.addAttribute("list", list);
		return "/thymeleaf/index";
	}
	@PostMapping("saveUser")
	
	public String saveUser(User u) {
		System.out.println(u);
		
		return "redirect:../thymeleaf/finduser";
	}
}
