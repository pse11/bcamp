package com.test06.AOP_all_anno;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAspect {
	@Pointcut("execution(public * *(..))")
	public void myClass() {}
	
	@Before("myClass()")
	public void before(JoinPoint join) {
		System.out.println("컴퓨터를 켠다.");
	}
	
	@After("myClass()")
	public void after(JoinPoint join) {
		System.out.println("집에 간다.");
	}
	
	@AfterReturning(pointcut="myClass()",returning="returnVal")//타겟이 리턴한 값을 returnVal 변수로 받아서
	public void returning(Object returnVal) {   				//after-returning advice에 넣어라 => returnVal 파라미터에 주입
		System.out.println(returnVal+" 공부하는 날입니다! ");
	}
}
