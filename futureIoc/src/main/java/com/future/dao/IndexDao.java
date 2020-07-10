package com.future.dao;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Description;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;

/**
 * @description:
 * @author: Mr.Li
 * @date: Created in 2020/7/7 12:26
 * @version: 1.0
 * @modified By:
 *
 * 问题: Singleton Beans with Prototype-bean Dependencies
 * 	 1> 实现 ApplicationContextAware
 * 	 2> @Lookup
 */
@Repository
public class IndexDao implements ApplicationContextAware {

	private ApplicationContext applicationContext;

	public IndexDao() {
		System.out.println("Constructor");
	}

	@PostConstruct
	public void init() {
		System.out.println("init");
	}

	public void query() {
		System.out.println("query");
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
		System.out.println(applicationContext);
	}
}
