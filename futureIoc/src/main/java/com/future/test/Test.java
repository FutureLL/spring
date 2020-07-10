package com.future.test;

import com.future.app.Appconfig;
import com.future.dao.IndexDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @description:
 * @author: Mr.Li
 * @date: Created in 2020/7/7 12:15
 * @version: 1.0
 * @modified By:
 *
 * 我们定义了一个类 Test,在 Java 中使用 Class 来表示这个类
 * Spring 中的 bean,使用 BeanDefinition 来描述
 */
public class Test {

	public static void main(String[] args) {
		// 把 Spring 所有的前提环境都准备好
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

		// register(): Register one or more component classes to be processed.
		context.register(Appconfig.class);
		// refresh(): 初始化 Spring 的环境
		context.refresh();
		/**
		 * 当调用 register(Appconfig.class) 方法时,这里会报如下所示的错误,因为这里没有调用 refresh()
		 * NoSuchBeanDefinitionException: No qualifying bean of type 'com.future.dao.IndexDao' available
		 *
		 * 但是当换成 register(IndexDao.class) 就不会报错,因为在后边我们需要得到 IndexDao 对象时,需要先调用 getBean()
		 * 在 getBean() 里边会调用 refresh()
		 */

		// scan(): Perform a scan within the specified base packages.
		// 可以代替 @ComponentScan("com.future.dao") 注解
		// context.scan("com.future.dao");

		IndexDao dao = context.getBean(IndexDao.class);

		dao.query();
	}
}
