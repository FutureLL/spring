package com.future.anno;

import com.future.imports.MyImportSelector;
import org.springframework.context.annotation.Import;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @description:
 * @author: Mr.Li
 * @date: Created in 2020/7/30 6:30
 * @version: 1.0
 * @modified By:
 */
@Retention(RetentionPolicy.RUNTIME)
@Import(MyImportSelector.class)
public @interface EnableFuture {
}
