package com.future.config;

import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: Mr.Li
 * @date: Created in 2020/8/6 6:26
 * @version: 1.0
 * @modified By:
 *
 * @EnableAspectJAutoProxy: 让我们的 Spring 后置处理器里面添加一个处理器能够去处理 Spring 的 Bean 让它变成一个代理对象
 */

@Component
@EnableAspectJAutoProxy(proxyTargetClass = false)
public class AspectFuture {

}
