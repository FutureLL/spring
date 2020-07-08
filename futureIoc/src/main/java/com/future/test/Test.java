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
 */
public class Test {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Appconfig.class);

		// register(): Register one or more component classes to be processed.
		context.register(IndexDao.class);
		// scan(): Perform a scan within the specified base packages.
		context.scan("com.future");

		IndexDao dao = context.getBean(IndexDao.class);

		dao.query("query");
	}
}
