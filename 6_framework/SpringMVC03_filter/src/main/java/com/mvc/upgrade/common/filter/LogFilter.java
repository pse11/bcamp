package com.mvc.upgrade.common.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogFilter implements Filter{ //서블릿 필터를 만들기위한 인터페이스 Filter
	//필터는 주로 요청에 대한 인증, 권한 체크 등을 하는데에 쓰인다. 
	private Logger logger = LoggerFactory.getLogger(LogFilter.class); //logger 객체 만들어서 메시지 전달하고 그 메시지를 통해 콘솔에 메시지를 띄운다.

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		//필터 객체 초기화시 실행
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//request : 사용자가 보낸 HTTP요청 데이터(ex.파라미터, 헤더, IP)
		//response : 서버가 사용자에게 보낼 HTTP 응답 데이터
		//chain : 다음 필터나 서블릿(DispatcherServlet)으로 넘어가도록 연결
		
		//필터 핵심 메서드(클라이언트(브라우저)에서 요청시마다 실행)
		//해당 필터의 처리 결과를 다음 처리로 넘겨주는 역할.
		//다음 필터가 있으면 다음 필터로, 없으면 서블릿으로...
		
		//http요청이 들어오기때문에(웹 브라우저가 보내는 건 무조건 Http요청) HttpServletRequest로 타입 변경
		//ServletRequest는 Http프로토콜에 특화되지 않은 범용 인터페이스. 
		//우리는 HTTP 요청 헤더나 URL같은 HTTP 전용 메서드를 써야해서 다운캐스팅
		HttpServletRequest req = (HttpServletRequest)request;
		
		String remoteAddr = "remotAddr: "+ req.getRemoteAddr()+"\n";
		String uri = "uri: "+req.getRequestURI()+"\n";
		String url = "url: "+req.getRequestURL()+"\n"; //프로토콜부터 시작하는 전체 경로
		String queryString = "queryString: "+req.getQueryString()+"\n";
		String referer = "referer: "+req.getHeader("referer")+"\n";
		String agent = "agent: "+ req.getHeader("User-Agent")+"\n";
		
		logger.info("LOG FILTER\n"+remoteAddr+uri+url+queryString+referer+agent+"\n");
		
		//다음으로 필터나 서블릿으로 넘겨야 페이지가 제대로 나옴.
		chain.doFilter(req, response);
	}

	@Override
	public void destroy() {
		//필터 객체 종료시 호출되는 메서드
	}
}
