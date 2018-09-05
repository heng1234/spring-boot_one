package com.yh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.yh.mapper")
@ComponentScan(basePackages= {"com.yh","org.n3r.idworker"})
/**
 * 开启定时任务
 */
@EnableScheduling
/**
  *开启异步注释
 */
@EnableAsync
public class SpringdemoOneApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringdemoOneApplication.class, args);
	}
}
