package com.future.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @description:
 * @author: Mr.Li
 * @date: Created in 2020/7/7 12:18
 * @version: 1.0
 * @modified By:
 *
 * 问题: 如果不加 @Configuration 也可以正常操作,也就是说 @Configuration 注解没什么用,那我们写 @Configuration 注解为了什么?
 * 原因: 在源码中会有一个 checkConfigurationClassCandidate() 方法,这个方法中会进行 if 判断,如果有 @Configuration 注解,那么
 * 		 会给 CONFIGURATION_CLASS_ATTRIBUTE 属性设置为 full,如果没有 @Configuration 注解,那么还会进入 else-if 判断有没有
 * 		 Component、ComponentScan、Import、ImportResource 这四个注解,如果有的话,那么对其调用 add() 方法
 * 		 configCandidates.add(new BeanDefinitionHolder(beanDef, beanName));
 * 		 所以说不管加不加 @Configuration,只要包含上述的几个注解,那么就会将这个类进行注入
 *
 * 当某些功能需要 Spring 动态加载,那么就可以使用这种方式 MyImportSelector、EnableFuture、Appconfig
 *
 * 类的注册:
 * 	 普通类: 						  扫描完成之后注册
 * 	 ImportSelector:				  先把类放到 configurationClasses 的 Map 集合中,
 * 	 								  	然后在 ConfigurationClassBeanDefinitionReader 类中的 loadBeanDefinitions() 方法中进行注册
 * 	 ImportBeanDefinitionRegistrar:	  先放到 importBeanDefinitionRegistrars 的 Map 集合中,
 * 	 								  	然后在 ConfigurationClassBeanDefinitionReader 类中的 loadBeanDefinitionsForConfigurationClass()
 * 	 								  	方法中的 loadBeanDefinitionsFromRegistrars() 方法,使用 forEach 的方式进行注册
 * 	 Import普通类:					  先存放在变量名为 configurationClasses 的 Map 集合中,
 * 	 									然后在 ConfigurationClassBeanDefinitionReader 类中的 loadBeanDefinitions() 方法中
 * 	 									方法中的 loadBeanDefinitionsForConfigurationClass() 方法,中的
 * 	 									if (configClass.isImported()) {
 * 											registerBeanDefinitionForImportedConfigurationClass(configClass);
 *                						}
 *
 *
 * 加了 @EnableAspectJAutoProxy 注解,Spring 就会加入一个后置处理器,专门用来处理 AOP,增强代理
 */

@ComponentScan("com.future")
@Configuration
// @EnableAspectJAutoProxy
// @ImportResource("classpath:spring.xml")
public class Appconfig {

	// @Bean
	// public IndexDao1 indexDao1() {
	// 	return new IndexDao1();
	// }

	// @Bean
	// public IndexDao indexDao() {
	/**
	 * 如果没有 @Configuration 注解,那么会调用两次 IndexDao1 的构造方法,
	 * 如果有 @Configuration 注解,那么会调用一次 IndexDao1 的构造方法
	 *
	 * 第一次还是调用 indexDao1() 方法,到了第二次就直接从容器中去拿
	 *
	 * 如果 indexDao1 被 static 修饰,那么也会调用两次
	 * 原因在 org.springframework.context.annotation.ConfigurationClassBeanDefinitionReader#loadBeanDefinitionsForBeanMethod
	 * 方法中,会在里边进行一个判断
	 * if (metadata.isStatic()) {
	 * 	  // static @Bean method
	 * 	  beanDef.setBeanClassName(configClass.getMetadata().getClassName());
	 * 	  beanDef.setFactoryMethodName(methodName);
	 * }
	 */
	// indexDao1();
	// return new IndexDao();
	// }
}
