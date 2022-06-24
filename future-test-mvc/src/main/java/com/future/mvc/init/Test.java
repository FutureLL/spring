package com.future.mvc.init;

import org.apache.catalina.LifecycleException;

import javax.servlet.ServletException;

/**
 * @Description:
 * @Author: lilei58
 * @Date: Created in 2021/9/30 下午1:44
 */
public class Test {

	public static void main(String[] args) {

		try {
			SpringApplicationFuture.run();
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (LifecycleException e) {
			e.printStackTrace();
		}
	}
}
