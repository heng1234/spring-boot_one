package com.yh.controller;

import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yh.async.AsyncTask;

@Controller
@RequestMapping("async")
public class AsyncController {

	@Autowired
	private AsyncTask asyncTask;
	
	
	@RequestMapping("asyncMs")
	@ResponseBody
	public String asyncMs() throws Exception{
		long start = System.currentTimeMillis();
		Future<Boolean> bol1 = asyncTask.task1();
		Future<Boolean> bol2 = asyncTask.task2();
		Future<Boolean> bol3 = asyncTask.task3();
		while(!bol1.isDone() || !bol2.isDone() || !bol3.isDone()) {
			if(bol1.isDone() && bol2.isDone() && bol3.isDone()) {
				
				break;
			}
		}
		
		long end = System.currentTimeMillis();
		String times = "任务全部完成，总耗时：" + (end - start) + "毫秒";
    	System.out.println(times);
		return times;
	}
}
