package com.future.test;

import com.future.app.Appconfig;
import com.future.beanFactoryPostProcessor.MyBeanFactoryProcessor;
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
		// 1、准备工厂 == DefaultListableBeanFactory
		// 实例化一个 bdReader 和一个 scanner
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		// 把一个 class 转成 bd,最后 put 到 map
		// map 位置 DefaultListableBeanFactory 的属性 beanDefinitionMap
		// register(): Register one or more component classes to be processed.
		context.register(Appconfig.class);

		// 代替了 @Component
		// context.addBeanFactoryPostProcessor(new MyBeanFactoryProcessor());

		// refresh(): 初始化 Spring 的环境
		context.refresh();

		// 调用完 refresh() 就已经完成了扫描工作,但是完成这个扫描不是 AnnotationConfigApplicationContext 里面的 scanner

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
		IndexDao dao1 = context.getBean(IndexDao.class);

		System.out.println(dao.hashCode());
		System.out.println(dao1.hashCode());

		// dao.query();
	}
}
