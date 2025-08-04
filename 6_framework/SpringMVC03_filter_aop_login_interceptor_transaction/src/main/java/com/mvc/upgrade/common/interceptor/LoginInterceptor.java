package com.mvc.upgrade.common.interceptor;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor{
	//HandlerInterceptor : dispatcherservlet에서 controller로 넘기기 전에 가로챔
	//interceptor이런거 다 이해하고 과정 자체를 이해하고 넘어가야 나중에 기능구현을 할 수가 있음.
	
	private Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);
	
	//Controller 실행 전 수행되는 메소드
	//요청을 가로채 처리 중단 가능하다. 
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
		logger.info("[interceptor] preHandle");
		//로그인 안했으면 컨트롤러 가기전에 막기
		if(request.getRequestURI().contains("/loginform.do")||
		   request.getRequestURI().contains("/ajaxlogin.do")||
		   request.getSession().getAttribute("login")!=null ||
		   request.getRequestURI().contains("/test.do")) {
			return true;
		}
		//return 값이 true: controller 실행
		//return 값이 false : controller 실행 시키지 않고 요청 종료
		if(request.getSession().getAttribute("login")==null) {
			response.sendRedirect("loginform.do");
			return false;
		}
		return false;
	}
	
	//Controller 실행 후, view 렌더링 전
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,ModelAndView modelAndView) {
		logger.info("[interceptor] postHandle");
	}
	
	//view 렌더링 완료 후 
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
		logger.info("[interceptor] afterCompletion");
	}
}
