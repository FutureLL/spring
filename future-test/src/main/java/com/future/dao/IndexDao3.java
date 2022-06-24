package com.future.dao;

import com.future.imports.MyInvocationHandler;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.reflect.Proxy;

/**
 * @description:
 * @author: Mr.Li
 * @date: Created in 2020/7/30 6:23
 * @version: 1.0
 * @modified By:
 */

public class IndexDao3 implements BeanPostProcessor {

	// public void query() {
	// 	System.out.println("index3");
	// }

	// @Override
	// public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
	// 	if (beanName.equals("indexDao")){
	// 		bean = Proxy.newProxyInstance(this.getClass().getClassLoader(),
	// 				new Class[]{Dao.class}, new MyInvocationHandler(bean));
	//
	// 	}
	// 	return bean;
	// }
	//
	// @Override
	// public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
	// 	return null;
	// }
}
