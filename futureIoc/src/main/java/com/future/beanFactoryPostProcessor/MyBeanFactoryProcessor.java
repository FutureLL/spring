package com.future.beanFactoryPostProcessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: Mr.Li
 * @date: Created in 2020/7/11 15:28
 * @version: 1.0
 * @modified By:
 */
@Component
public class MyBeanFactoryProcessor implements BeanFactoryPostProcessor {

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		BeanDefinition indexDao = beanFactory.getBeanDefinition("indexDao");
		indexDao.setScope(BeanDefinition.SCOPE_PROTOTYPE);
	}
}
