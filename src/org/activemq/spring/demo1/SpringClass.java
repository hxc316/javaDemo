package org.activemq.spring.demo1;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringClass {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext cpx=new ClassPathXmlApplicationContext("classpath*:org/activemq/spring/demo1/applicationContext.xml");
		Object ob = cpx.getBean("123");
	}
}
