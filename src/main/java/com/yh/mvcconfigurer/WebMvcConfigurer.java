package com.yh.mvcconfigurer;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import com.yh.interceptor.InterceptorOne;
import com.yh.interceptor.InterceptorTwo;
/**
 * 拦截器定义

* <p>Title: WebMvcConfigurer</p>  
* <p>Description: </p>  
* @author heng  
* @date 2018年9月5日
 */
@Configuration
public class WebMvcConfigurer extends WebMvcConfigurerAdapter {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new InterceptorOne()).addPathPatterns("/lznone/*");
		registry.addInterceptor(new InterceptorTwo()).addPathPatterns("/lzntwo/*");
		super.addInterceptors(registry);
	}
	
	

}
