package com.test02.AOP;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class MyAspect implements MethodInterceptor{

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		//리턴해주는 object
		Object target = null;
		//target실행 전에 실행
		System.out.println("컴퓨터를 켠다");
		
		//target 실행
		try{
			target = invocation.proceed();
		}catch(Exception e) {
			System.out.println("쉬는 날이었다.");
		}finally{
			//target실행 후에 실행
			System.out.println("집에간다.");
		}
		
		
		return target;
	}
	
}
