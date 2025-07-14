package com.mvc.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mvc.rest.model.service.RestService;

@RestController
public class RestControllerTest {
	@Autowired
	private RestService service;
	
	@RequestMapping(value="/restdto",method=RequestMethod.GET)
	public String getRest() {
		System.out.println("selectList");
		return null;
	}
	
	@RequestMapping(value="/restdto/{restno}",method=RequestMethod.GET) //파라미터와 다름. 경로상에 들어있는 값을 꺼내온다.
	public String getRestOne(@PathVariable int restno) {
		System.out.println("selectoOne: "+restno);
		return null;
	}
}
