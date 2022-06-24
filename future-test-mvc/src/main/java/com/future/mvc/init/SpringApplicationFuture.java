package com.future.mvc.init;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletException;
import java.io.File;
import java.io.InputStream;

/**
 * @Description:
 * @Author: lilei58
 * @Date: Created in 2021/10/11 上午6:35
 */
public class SpringApplicationFuture {

	public static void run() throws ServletException, LifecycleException {

		// Spring IOC 环境
		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
		context.register(AppConfig.class);
		context.refresh();

		File base = new File(System.getProperty("java.io.tmpdir"));

		Tomcat tomcat = new Tomcat();
		// 配置端口
		tomcat.setPort(9090);

		/**
		 * addWebapp(): 表示这是一个 web 项目
		 * contextPath: tomcat 的访问路径
		 * docBase: 项目的 web 目录
		 * 所以这里不能用 addWebapp() & SpringBoot 当中也没有这么做
		 *
		 * SpringBoot 中默认依赖 [tomcat-embed-core & tomcat-embed-websocket] 不依赖 [tomcat-embed-jasper]
		 * 如果使用 addWebapp(),那么 tomcat 会认为这是一个 web 项目,执行一些初始化操作,需要用到 tomcat-embed-jasper
		 * 如果使用 addContext(),则项目不需要初始化一些操作,也就不会初始化 Spring 环境和 SpringWeb 环境
		 */
		Context rootCtx = tomcat.addWebapp("/", base.getAbsolutePath());
		//Context rootCtx = tomcat.addContext("/", base.getAbsolutePath());

		// ** 重要的对象 **
		DispatcherServlet dispatcher = new DispatcherServlet(context);

		// 表明 tomcat 在启动过程当中会调用 DispatcherServlet#init()
		// 最终调用: org.springframework.web.servlet.HttpServletBean#init()
		// 初始化 Controller 和请求映射
		Tomcat.addServlet(rootCtx, "future", dispatcher).setLoadOnStartup(0);

		// Spring Web 环境
		rootCtx.addServletMapping("/", "future");

		tomcat.start();
		tomcat.getServer().await();

	}
}
