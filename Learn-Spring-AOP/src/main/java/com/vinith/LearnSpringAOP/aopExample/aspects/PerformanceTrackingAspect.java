package com.vinith.LearnSpringAOP.aopExample.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class PerformanceTrackingAspect {
	
	private Logger logger=LoggerFactory.getLogger(getClass());
	
//	@Around("com.vinith.LearnSpringAOP.aopExample.aspects.CommonPointCutConfig.businessAndDataPackageConfig()")
	@Around("com.vinith.LearnSpringAOP.aopExample.aspects.CommonPointCutConfig.trackTimeAnnotation()")
	public Object findExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable
	{
		//start the timer
		long startTimeMillis = System.currentTimeMillis();
		//execute the method
		Object returnValue = proceedingJoinPoint.proceed();
		//stop the timer
		long stopTimeMillis = System.currentTimeMillis();
		long executionDuration= stopTimeMillis-startTimeMillis;
		
		logger.info("Around Aspect - {} method is executed in {} ms",proceedingJoinPoint,executionDuration);
		
		return returnValue;
		
	
	}

}
