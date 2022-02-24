package com.example.demo;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class AopConfig {

	//What kind of method calls I would intercept
	//execution(* PACKAGE.*.*(..))  
	
	
	@Before(value="com.example.demo.PointCutConf.ff()")
	public void logBefore(JoinPoint joinpoint) {
		for(Object obj:joinpoint.getArgs()) {
			System.out.println("param :"+obj);
		}
		System.out.println("Intercept before "+joinpoint);
		
	}
	
	@AfterReturning(value="com.example.demo.PointCutConf.ff()",returning = "result")
	public void logAfterReturn(JoinPoint joinpoint,Object result) {
		System.out.println("after return "+joinpoint+" result "+result);
	}
	
	@Around(value="com.example.demo.PointCutConf.f2anno()")
	public void logBefore(ProceedingJoinPoint joinpoint) throws Throwable {
		Long st=System.currentTimeMillis();
		joinpoint.proceed();
		Long et=System.currentTimeMillis();
		
		System.out.println("Time taken by  "+joinpoint+" is "+(et-st));
	}
	
	
	
	
	
	
}
