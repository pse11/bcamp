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

public class LogFilter implements Filter{
	//필터는 주로 요청에 대한 인증, 권한 체크 등을 하는데에 쓰인다. 
	private Logger logger = LoggerFactory.getLogger(LogFilter.class); //logger 객체 만들어서 메시지 전달하고 그 메시지를 통해 콘솔에 메시지를 띄운다.

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		//필터 객체 초기화시 실행
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//해당 필터의 처리 결과를 다음 처리로 넘겨주는 역할.
		//다음 필터가 있으면 다음 필터로, 없으면 서블릿으로...
		
		//http요청이 들어오기때문에 HttpServletRequest로 타입 변경
		HttpServletRequest req = (HttpServletRequest)request;
		
		String remoteAddr = "remotAddr: "+ req.getRemoteAddr()+"\n";
		String uri = "uri: "+req.getRequestURI()+"\n";
		String url = "url: "+req.getRequestURL()+"\n"; //프로토콜부터 시작하는 전체 경로
		String queryString = "queryString: "+req.getQueryString()+"\n";
		String referer = "referer: "+req.getHeader("referer")+"\n";
		String agent = "agent: "+ req.getHeader("User-Agent")+"\n";
		
		logger.info("LOG FILTER\n"+remoteAddr+uri+url+queryString+referer+agent+"\n");
		
		//다음으로 넘겨줘야한다.
		chain.doFilter(req, response);
	}

	@Override
	public void destroy() {
		//필터 객체 종료
	}
}
