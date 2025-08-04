package com.test02.AOP;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class MyAspect implements MethodInterceptor{ //MethodInterceptor : 스프링 AOP(또는 AspectJ)의 인터페이스

	//invoke 메소드 : 타겟 메소드(=원래 실행하려던 비즈니스 메서드)가 호출될때
	//그걸 가로채서, 그 실행 전후로 원하는 코드를 넣을 수 있게 해주는 메소드
	
	//invoke 메소드 자체가 타겟 메소드를 감싸는 함수.
	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable { 
		//MethodInvocation은 타겟 메서드에 대한 정보를 담고 있고,
		//invocation.proceed()가 실제로 타겟을 실행.
		
		//리턴해주는 object
		Object target = null;
		//target실행 전에 실행
		System.out.println("컴퓨터를 켠다");
		
		//target 실행
		try{
			target = invocation.proceed(); //타겟 메서드 실행
		}catch(Exception e) {
			System.out.println("쉬는 날이었다.");
		}finally{
			//target실행 후에 실행
			System.out.println("집에간다.");
		}
		
		
		return target;
	}
	
}
