package com.mvc.rest.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mvc.rest.model.dto.RestDto;
import com.mvc.rest.model.service.RestService;

@RestController
public class RestControllerTest {
	@Autowired
	private RestService service;
	
	@RequestMapping(value="/restdto",method=RequestMethod.GET)
	public List<RestDto> getRest() {
		System.out.println("selectList");
		List<RestDto> list = service.selectList();
		//rest controller : 필요한 데이터를 보낸다. 
		return list; //list라는 데이터를 전달한다. 만약 화면 전환이 필요하면 rest가 아닌 그냥 controller로 작성
	}
	
	@RequestMapping(value="/restdto/{restno}",method=RequestMethod.GET) //파라미터와 다름. 경로상에 들어있는 값을 꺼내온다.
	public RestDto getRestOne(@PathVariable int restno) {
		System.out.println("selectoOne: "+restno);
		RestDto res = service.selectOne(restno);
		
		return res;
	}
	
	@RequestMapping(value="/restdto", method=RequestMethod.POST)
	public Map<String,Integer> postRest(RestDto dto) {
		
		int res = service.insert(dto);
		Map<String, Integer> map = new HashMap<>();
		if(res>0) {
			map.put("code", 200);//통신 성공했다는 의미의 200
		}else {
			map.put("code",500);
		}
		return map;
	}
	
	@RequestMapping(value="/restdto/{restno}", method=RequestMethod.DELETE)
	public Map<String,Integer> deleteRest(@PathVariable int restno) {
		System.out.println("delete method: "+restno);
		int res = service.delete(restno);
		Map<String, Integer> map = new HashMap<>();
		
		if(res>0) {
			map.put("code", 200);
		}else {
			map.put("code", 500);
		}
		return map;
	}
	
	@RequestMapping(value="/restdto", method=RequestMethod.PUT)
	//@RequestMapping(value="/restdto{restno}", method=RequestMethod.PUT)
	public Map<String, Integer> updateRest(RestDto dto) {
	//public Map<String, Integer> updateRest(@PathVariable int restno, String restpw) {
		int res = service.update(dto);
		//int res = service.update(new RestDto(restno,null,restpw,null));
		Map<String, Integer> map = new HashMap<>();
		if(res>0) {
			map.put("code",200);
		}else {
			map.put("code",500);
		}
		return map;
	}
}
