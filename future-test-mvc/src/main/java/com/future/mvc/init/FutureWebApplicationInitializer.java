package com.future.mvc.init;

import org.springframework.web.WebApplicationInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;


/**
 * @Description:
 * @Author: lilei58
 * @Date: Created in 2021/9/30 下午1:39
 */
public class FutureWebApplicationInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		// 初始化 Spring 环境和 SpringWeb 环境
		System.out.println("初始化 Spring 环境和 SpringWeb 环境");
	}
}
