package com.yh.task;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.ibatis.javassist.tools.framedump;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 测试定时任务
* <p>Title: TestTask</p>  
* <p>Description: </p>  
* @author heng  
* @date 2018年9月4日
 */

@Component
public class TestTask {
	
	private static final SimpleDateFormat framedump = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	/**
	 * 
	 * <p>Title: printDate</p>  
	 * <p>Description: </p>
	 */
	
	@Scheduled(fixedRate=3000)
	public void  printDate() {
		//System.out.println("每隔三秒打印时间:"+framedump.format(new Date()));
	}
	/**
	 * 从6秒开始  每隔7秒打印
	 * <p>Title: dtfmt</p>  
	 * <p>Description: </p>
	 */
	@Scheduled(cron="6/7 * * * * ? ")
	public void  dtfmt() {
	//	System.out.println("从6秒开始  每隔7秒打印:"+framedump.format(new Date()));
	}
	

}
