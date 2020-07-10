package com.future.beanPostProcessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.PriorityOrdered;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: Mr.Li
 * @date: Created in 2020/7/10 18:52
 * @version: 1.0
 * @modified By:
 */
@Component
public class TestBeanProcessor implements BeanPostProcessor, PriorityOrdered {

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		if (beanName.equals("indexDao")) {
			System.out.println("BeforeInitialization");
		}
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		if (beanName.equals("indexDao")) {
			System.out.println("AfterInitialization");
		}
		return bean;
	}

	@Override
	public int getOrder() {
		return 102;
	}
}
