package com.boot.jdbc.common;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer{
	
	@Override
	public void addInterceptors(InterceptorRegistry registry){
		registry.addInterceptor(new CheckInterceptor())
				.addPathPatterns("/myboard/**") // *: 한단계, ** : 하위 전체 다
				.excludePathPatterns("/myboard/test"); //제외할 url 
				//-> /myboard/test2하면 인터셉터 동작하지만 /myboard/test는 exclude로 인해 인터셉터 안된다.
	}
}
