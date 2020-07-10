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
 *
 * 这里的执行顺序是先 TestBeanProcessor 再 TestBeanProcessor1,
 * 如果想让他们的执行顺序颠倒,那么让 TestBeanProcessor1、TestBeanProcessor1 实现 PriorityOrdered 给这两个类分配权重,调整优先级
 * 实现 PriorityOrdered 接口中的方法 getOrder(),其中返回的值越小,优先级越高
 */
@Component
public class TestBeanProcessor1 implements BeanPostProcessor, PriorityOrdered {

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		if (beanName.equals("indexDao")) {
			System.out.println("BeforeInitialization1");
		}
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		if (beanName.equals("indexDao")) {
			System.out.println("AfterInitialization1");
		}
		return bean;
	}

	@Override
	public int getOrder() {
		return 101;
	}
}
