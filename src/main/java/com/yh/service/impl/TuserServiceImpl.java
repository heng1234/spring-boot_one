package com.yh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.yh.mapper.TUserMapper;
import com.yh.mapper.userMapper;
import com.yh.pojo.TUser;
import com.yh.service.TuserService;

import tk.mybatis.mapper.entity.Example;

@Service("tuserService")
public class TuserServiceImpl implements TuserService {
	
	@Autowired
	private TUserMapper tuserMapper;
	
	@Autowired
	private userMapper userMapper;
	
	/**
	 * 增加
	 * <p>Title: saveTuser</p>  
	 * <p>Description: </p>  
	 * @param tUser
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED)//事务注解 如果有事务用默认事务 没有则创建事务
	public void saveTuser(TUser tUser) {
		tuserMapper.insertSelective(tUser);
		int num = 1 / 0;
		TUser tUser2 = new TUser();
		tUser2.setUserid(1009);
		tUser2.setPassword("123456");
		tuserMapper.updateByPrimaryKeySelective(tUser2);
		

	}
	/**
	 * 修改
	 * <p>Title: updateTuser</p>  
	 * <p>Description: </p>  
	 * @param tUser
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED)//事务注解 如果有事务用默认事务 没有则创建事务
	public void updateTuser(TUser tUser) {
		tuserMapper.updateByPrimaryKeySelective(tUser);

	}
	/**
	 * 根据id查询
	 * <p>Title: findTuser</p>  
	 * <p>Description: </p>  
	 * @param id
	 * @return
	 */
	@Override
	@Transactional(propagation=Propagation.SUPPORTS)//如果有事务则执行 没有不进行创建
	public TUser findTuser(Integer id) {
		
		return tuserMapper.selectByPrimaryKey(id);
	}

	/**
	 * 查询全部
	 * <p>Title: findTusers</p>  
	 * <p>Description: </p>  
	 * @return
	 */
	@Override
	@Transactional(propagation=Propagation.SUPPORTS)
	public List<TUser> findTusers() {
		// TODO Auto-generated method stub
		return userMapper.findListTuser();
	}
	/**
	 * 分页查询
	 */
	@Override
	@Transactional(propagation=Propagation.SUPPORTS)
	public List<TUser> findPageListTuser(int page, int pageSize) {

		PageHelper.startPage(page, pageSize);
		Example example = new Example(TUser.class);
		Example.Criteria criteria =  example.createCriteria();
		
		
		return tuserMapper.selectByExample(example);
	}

}
