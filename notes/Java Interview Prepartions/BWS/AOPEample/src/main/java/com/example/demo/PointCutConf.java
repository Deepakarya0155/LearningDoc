package com.example.demo;

import org.aspectj.lang.annotation.Pointcut;

public class PointCutConf {

	@Pointcut("execution(* com.example.demo.business.*.*(..))")
	public void ff() {}
	
	
	@Pointcut("@annotation(com.example.demo.TrackTime)")
	public void f2anno() {
		
	}
}
