package com.future.mvc.init;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;

import java.util.List;

/**
 * @Description:
 * @Author: lilei58
 * @Date: Created in 2021/10/11 上午6:38
 */
@Configuration
@ComponentScan("com.future.mvc")
public class AppConfig {

	public void configMessageConverters(List<HttpMessageConverter<?>> converters) {
		System.out.println("configMessageConverters");
	}

}
