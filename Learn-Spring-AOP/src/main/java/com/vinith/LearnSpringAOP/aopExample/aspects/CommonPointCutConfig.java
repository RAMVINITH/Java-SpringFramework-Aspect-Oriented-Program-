package com.vinith.LearnSpringAOP.aopExample.aspects;

import org.aspectj.lang.annotation.Pointcut;

public class CommonPointCutConfig {
	
	@Pointcut("execution(* com.vinith.LearnSpringAOP.aopExample.*.*.*(..))")
	public void businessAndDataPackageConfig() {}
	
	@Pointcut("execution(* com.vinith.LearnSpringAOP.aopExample.business.*.*(..))")
	public void businessPackageConfig() {}
	
	@Pointcut("execution(* com.vinith.LearnSpringAOP.aopExample.data.*.*(..))")
	public void dataPackageConfig() {}
	
	@Pointcut("bean(*Service*)")
	public void allPackageConfigUsingBean() {}
	
	@Pointcut("@annotation(com.vinith.LearnSpringAOP.aopExample.annotation.TrackTime)")
	public void trackTimeAnnotation() {}
}
