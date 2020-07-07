package com.future.test;

import com.future.app.Appconfig;
import com.future.dao.Dao;
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

		Dao dao = (Dao) context.getBean("indexDaoImpl");

		dao.query("query");
	}
}
