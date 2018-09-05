package com.yh.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yh.pojo.TUser;
import com.yh.utils.JsonUtils;
import com.yh.utils.RedisOperator;

@Controller
@RequestMapping(value="redis")
public class RedisController {

	  @Autowired
	   private StringRedisTemplate stringRedisTemplate;
	
	  @Autowired
	  private RedisOperator reactor;
	  
	  /**
	   * redis
	   * <p>Title: getRedis</p>  
	   * <p>Description: </p>  
	   * @return
	   */
	@RequestMapping("getRedis")
	@ResponseBody
	public TUser getRedis() {
		/*
		stringRedisTemplate.opsForValue().set("hlv-y", "hello yy");
		*/
		
		/*String redisRet =stringRedisTemplate.opsForValue().get("hlv-y");*/
		TUser tUser = new TUser( "heng", "666666", "1111");
		stringRedisTemplate.opsForValue().set("json:tuser:list",JsonUtils.objectToJson(tUser));
		
		
		TUser tu =JsonUtils.jsonToPojo(stringRedisTemplate.opsForValue().get("json:tuser:list"), TUser.class);
		return tu;
		
	} 
	
	/**
	 * 使用redis工具类
	 * <p>Title: findRedis</p>  
	 * <p>Description: </p>  
	 * @return
	 */
	@RequestMapping("findRedis")
	@ResponseBody
	public List<TUser> findRedis() {
		List<TUser> list = new ArrayList<TUser>();
		TUser tUser = new TUser( "heng", "666666", "1111");
		TUser tUser1 = new TUser( "yanyan", "666666", "1111");
		TUser tUser2 = new TUser( "honghong", "666666", "1111");
		list.add(tUser);
		list.add(tUser1);
		list.add(tUser2);
		
		reactor.set("tuser:list:json", JsonUtils.objectToJson(list), 1000);
		
		
		
		return JsonUtils.jsonToList(reactor.get("tuser:list:json"), TUser.class);
		
	} 
}
