package com.example.demo;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class AopConfig {

	@Before(value="execution(* com.example.demo.business.*.*(..))")
	public void before(JoinPoint point) {
		System.out.println(point);
		for(Object o:point.getArgs()) {
			System.out.println(o);
		}
	}
}
