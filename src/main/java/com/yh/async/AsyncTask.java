package com.yh.async;

import java.util.concurrent.Future;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

/**
 * 异步方法
* <p>Title: AsyncTask</p>  
* <p>Description: </p>  
* @author heng  
* @date 2018年9月4日
 */
@Component
public class AsyncTask {

	@Async	
	public Future<Boolean> task1() throws Exception{
		long start = System.currentTimeMillis();
		
		Thread.sleep(1000);
		
		long end = System.currentTimeMillis();
        System.out.println("任务1耗时:" + (end - start) + "毫秒");
        
        return new AsyncResult<Boolean>(true);
	}
	@Async
	public Future<Boolean> task2() throws Exception{
		long start = System.currentTimeMillis();
		
		Thread.sleep(700);
		
		long end = System.currentTimeMillis();
		System.out.println("任务1耗时:" + (end - start) + "毫秒");
		
		return new AsyncResult<Boolean>(true);
	}
	@Async
	public Future<Boolean> task3() throws Exception{
		long start = System.currentTimeMillis();
		
		Thread.sleep(900);
		
		long end = System.currentTimeMillis();
		System.out.println("任务1耗时:" + (end - start) + "毫秒");
		
		return new AsyncResult<Boolean>(true);
	}
}
