package com.test04.AOP_anno;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class MyAspect {
	//advise들을 다 모아놓는 클래스
	//어디에 언제넣을지 -> pointcut
	
	@Before("execution(public * com.test04.AOP_anno.*.*(..))") //public * *(..)이 실행되면 타켓 이전에 실행하겠다.
	public void before(JoinPoint join) { //joinpoint : 타겟에 대한 정보 있다.
		System.out.println(join.getTarget().getClass().getSimpleName());
		System.out.println(join.getSignature().getName()); //호출되는 타켓 메소드 이름 출력
		System.out.println(Arrays.toString(join.getArgs()));
		
		System.out.println("컴퓨터를 켠다.");
	}
	
	@After("execution(public * *(..))") //public * *(..)이 실행되면 타켓 이후에 실행하겠다. @After : 모든 실행 다 끝난 후에(try-catch의 finally처럼 예외발생했건 상관없이 항상 실행) 
	public void after(JoinPoint join) {
		System.out.println("집에 간다.");
	}
	
	@AfterReturning(pointcut="execution(public * *(..))", returning="returnVal") //@AfterReturning :타겟 return하고난 이후에 , return이라는 값을 returnVal이름으로 받아오겠다.
	public void returning(Object returnVal) {
		System.out.println(returnVal+" 공부 하는 날입니다!");
	}
	
	@AfterThrowing(pointcut="execution(public * *(..))")//@AfterThrowing : 타겟 실행 도중 예외발생 이후에 실행
	public void throwing() {
		System.out.println("쉬는 날이었다.");
	}
}
