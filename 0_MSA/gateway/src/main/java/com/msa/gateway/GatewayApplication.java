package com.msa.gateway;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@RefreshScope
@SpringBootApplication
public class GatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}

	@Value("${rest.api.url1}")
	private String url1; //properties에 값을 꺼내와서 url1에 저장. 아래의 uri를 대체

	@Value("${rest.api.url2}")
	private String url2;

	@Bean
	public RouteLocator myRoute(RouteLocatorBuilder builder) {
		System.out.println(url1+":"+url2);
		return builder.routes()
				.route(p -> p
						.path("/posts/**") // /posts/** : /posts로 시작하는 모든 path
						.uri("lb://posts")) //http://localhost:8082 : 알아서 8081로 url, path를 맞춰 전달 , li://posts : posts로 알아서 감
				.route(p -> p
						.path("/comments/**") // /comments/** : /comments 시작하는 모든 path
						.uri("http://localhost:8082"))
				.build();
	}
}
