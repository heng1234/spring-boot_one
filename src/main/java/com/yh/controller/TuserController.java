package com.yh.controller;

import java.util.List;

import org.n3r.idworker.Id;
import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yh.pojo.TUser;
import com.yh.service.TuserService;

@Controller
@RequestMapping("tuser")
public class TuserController {
	
	@Autowired
	private TuserService tuserService;
	
	
	/**
	 * 生成id类似腾讯企鹅号id
	 */
	@Autowired
	private Sid sid;
	
	/**
	 * 测试增加
	 * <p>Title: saveTuser</p>  
	 * <p>Description: </p>
	 */
	@RequestMapping("saveTuser")
	@ResponseBody
	public String saveTuser() {
		System.out.println(sid.nextShort()+"------this sid"); 
		TUser tUser = new TUser( "heng", "666666", "1111");
		tuserService.saveTuser(tUser);
		
		return "true";
	}
	/**
	 * 测试查询
	 * <p>Title: saveTuser</p>  
	 * <p>Description: </p>
	 */
	@RequestMapping("findListTuser")
	@ResponseBody
	public List<TUser> findListTuser() {
		List<TUser> list = tuserService.findTusers();
		System.out.println(list.size());
	return	list;
	}
	/**
	 * 测试mapper查询
	 * <p>Title: saveTuser</p>  
	 * <p>Description: </p>
	 */
	@RequestMapping("findTusers")
	@ResponseBody
	public List<TUser> findTusers() {
		List<TUser> list = tuserService.findTusers();
		return	list;
	}
	
	/**
	 * 分页查询
	 */
	@RequestMapping("findPageListTuser")
	@ResponseBody
	public List<TUser> findPageListTuser(Integer page) {
		if(page == null) {
			page = 1; //页面
		}
		Integer pageSize = 6;//每页显示数量
		List<TUser> list = tuserService.findPageListTuser(page, pageSize);
		System.out.println(list.size());
	return	list;
	}
}
