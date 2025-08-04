package com.test05.pointcut_method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class MyAspect {

	@Pointcut("execution(public void *(..))") //pointcut 재사용, 메소드 방식
	public void myClass() { //기준점이 된다.
		
	}
	@Pointcut("execution(public String *(..))")
	public void yourClass() {
		
	}
	
	@Before("myClass()") //두 poincut 둘다 만족하는 경우에만 :  myClass() && yourClass()로도 작성가능
	public void before(JoinPoint join) {
		System.out.println("컴퓨터를 켠다.");
	}
	
	@After("myClass()")
	public void after(JoinPoint join) {
		System.out.println("집에 간다.");
	}
	
	@Before("yourClass()")
	public void before2() {
		System.out.println("ttt");
	}
}
