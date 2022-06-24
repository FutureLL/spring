package com.future.imports;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @description:
 * @author: Mr.Li
 * @date: Created in 2020/7/30 6:42
 * @version: 1.0
 * @modified By:
 */
public class MyInvocationHandler implements InvocationHandler {

	Object target;

	public MyInvocationHandler(Object target) {
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("I am Proxy method");
		return method.invoke(target, args);
	}
}
