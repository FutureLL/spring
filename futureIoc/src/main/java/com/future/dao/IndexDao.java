package com.future.dao;

import org.springframework.context.annotation.Description;
import org.springframework.stereotype.Repository;

/**
 * @description:
 * @author: Mr.Li
 * @date: Created in 2020/7/7 12:26
 * @version: 1.0
 * @modified By:
 */
@Repository("indexDaoImpl")
@Description("描述 IndexDaoImpl")
public class IndexDao {

	public void query(String str) {
		System.out.println(str);
	}
}
