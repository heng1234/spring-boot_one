package com.yh.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.yh.pojo.HlvyJSONResult;

@ControllerAdvice
public class HlvyExceptionHandler {
	
	 static final  String TO_URL = "/thymeleaf/error/error";

	 /**
	  * 捕获不是ajax请求
	  * @param request
	  * @param response
	  * @param e
	  * @return
	  * @throws Exception
	  */
/*	 @ExceptionHandler(value= Exception.class)
	 public Object errExceyion(HttpServletRequest request,HttpServletResponse response,Exception e) throws Exception {
		e.printStackTrace();
		 ModelAndView view = new ModelAndView();
		 System.out.println("this HlvyExceptionHandler");
		 view.addObject("e", e);
		 view.addObject("url", request.getRequestURI());
		 view.setViewName(TO_URL);
		 return view;
		 
	 }*/
	 /**
	  * 捕获ajax请求
	  * @param request
	  * @param response
	  * @param e
	  * @return
	  * @throws Exception
	  */
	/* @ExceptionHandler(value= Exception.class)
	 public  HlvyJSONResult errExceyion(HttpServletRequest request,HttpServletResponse response,Exception e) throws Exception {
		e.printStackTrace();
		 return HlvyJSONResult.errorException(e.getMessage());
		 
	 }*/
	 /**
	  * ajax与uil访问异常都可以被拦截
	  * <p>Title: errExceyion</p>  
	  * <p>Description: </p>  
	  * @param request
	  * @param response
	  * @param e
	  * @return
	  * @throws Exception
	  */
	 @ExceptionHandler(value= Exception.class)
	 public  Object errExceyion(HttpServletRequest request,HttpServletResponse response,Exception e) throws Exception {
		e.printStackTrace();
		if (isAjax(request)) {
    		return HlvyJSONResult.errorException(e.getMessage());
    	} else {
    		ModelAndView mav = new ModelAndView();
            mav.addObject("e", e);
            mav.addObject("url", request.getRequestURI());
            mav.setViewName(TO_URL);
            return mav;
    	}
    }
	
/**
 * 判断是否是ajax请求
 * <p>Title: isAjax</p>  
 * <p>Description: </p>  
 * @param httpRequest
 * @return
 */
	public static boolean isAjax(HttpServletRequest httpRequest){
		return  (httpRequest.getHeader("X-Requested-With") != null  
					&& "XMLHttpRequest"
						.equals( httpRequest.getHeader("X-Requested-With").toString()) );
	}

}
