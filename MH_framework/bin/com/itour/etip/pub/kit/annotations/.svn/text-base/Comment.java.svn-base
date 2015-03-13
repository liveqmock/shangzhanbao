package com.itour.etip.pub.kit.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * dengling 
 * @author Administrator
 * bean类字段说明
 */
//注意这里的@Target与@Description里的不同,参数成员也不同
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Comment {
	//字段名称
	String name();
	//中文名称
    String chinaName();
    //是否隐藏
    boolean isHidden() default false;
    //是否是查询条件
    boolean isSearch() default false;
    //是否是grid中默认显示字段
    boolean isGrid() default true;
    
}