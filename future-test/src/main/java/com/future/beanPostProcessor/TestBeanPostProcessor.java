package com.future.beanPostProcessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.PriorityOrdered;

/**
 * @description:
 * @author: Mr.Li
 * @date: Created in 2021/4/16 7:50
 * @version: 1.0
 * @modified By:
 *
 * BeanPostProcessor Bean的后置处理器 / BeanFactoryPostProcessor Bean工厂的后置处理器
 */
public class TestBeanPostProcessor implements BeanPostProcessor, PriorityOrdered {

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		return bean;
	}

	@Override
	public int getOrder() {
		return 1;
	}
}
