package com.yh.service;

import java.util.List;

import com.yh.pojo.TUser;

public interface TuserService {
	/**
	 * 增加
	 * <p>Title: saveTuser</p>  
	 * <p>Description: </p>  
	 * @param tUser
	 */
	public void  saveTuser(TUser tUser);
		
	/**
	 * 修改
	 * <p>Title: updateTuser</p>  
	 * <p>Description: </p>  
	 * @param tUser
	 */
	public void updateTuser(TUser tUser);
	
	/**
	 * 根据id查询
	 * <p>Title: findTuser</p>  
	 * <p>Description: </p>  
	 * @param id
	 * @return
	 */
	public TUser findTuser(Integer id);
	
	
	/**
	 * 查询全部
	 * <p>Title: findTusers</p>  
	 * <p>Description: </p>  
	 * @return
	 */
	public List<TUser> findTusers();
		
	/**
	 * 分页查询
	 * <p>Title: findPageListTuser</p>  
	 * <p>Description: </p>  
	 * @param page
	 * @param pageSize
	 * @return
	 */
	public List<TUser> findPageListTuser(int page,int pageSize);
	
	

}
