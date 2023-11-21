package com.vinith.LearnSpringAOP.aopExample.aspects;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class LoggingAspect {
	
	private Logger logger=LoggerFactory.getLogger(getClass());
	
	//Syntax for executing or calling all beans from package-> execution(* packagename.*.*(..))
	//JoinPoint used to execute the specific method
	@Before("com.vinith.LearnSpringAOP.aopExample.aspects.CommonPointCutConfig.allPackageConfigUsingBean()")
	public void logMethodCallBeforeExecution(JoinPoint joinPoint) {
		logger.info("Before Aspect - {} is called with arguments : {}",joinPoint,joinPoint.getArgs());	
	}
	
	@After("com.vinith.LearnSpringAOP.aopExample.aspects.CommonPointCutConfig.businessPackageConfig()")
	public void afterlogMethodCallAfterExecution(JoinPoint joinPoint) {
		logger.info("After Aspect - {} has executed ",joinPoint);	
	}
	
	@AfterThrowing(
			pointcut = "com.vinith.LearnSpringAOP.aopExample.aspects.CommonPointCutConfig.businessAndDataPackageConfig()",
			throwing="exception"
			)
	public void afterlogMethodCallAfterException(JoinPoint joinPoint,Exception exception) {
		logger.info("After Throwing  Aspect - {} has thrown an exception {} ",joinPoint,exception);	
	}
	
	@AfterReturning(
			pointcut = "com.vinith.LearnSpringAOP.aopExample.aspects.CommonPointCutConfig.dataPackageConfig()",
			returning="resultValue"
			)
	public void afterlogMethodCallAfterSuccessfulExecution(JoinPoint joinPoint,Object resultValue) {
		logger.info("After Returning  Aspect - {} has returned {} ",joinPoint,resultValue);	
	}

}
