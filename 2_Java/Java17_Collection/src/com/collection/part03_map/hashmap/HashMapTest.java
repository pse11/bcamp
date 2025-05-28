package com.collection.part03_map.hashmap;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapTest {
	public void test() {
		//HashMap Test
		HashMap hmap = new HashMap();
		
		//put(key, value), key, value
		hmap.put("one", new Date());
		hmap.put(12, "red apple"); //12=> Integer 객체
		hmap.put(32, 123);
		//key, value 모두 반드시 객체여야한다.
		
		System.out.println("hmap: "+hmap);
		
		//키는 중복 허용 x 동일한 키를 갖고 있을 땐 덮어씌운다.
		hmap.put(12, "yellow banana");
		System.out.println("hmap: "+hmap);
		
		//value는 중복 허용
		hmap.put(11,"yellow banana");
		hmap.put(19, "yellow banana");
		System.out.println("hmap: "+hmap);
		
		//value 가져오기
		System.out.println(hmap.get(19));
		
		//삭제하기 ( 엔트리(키,value 묶음)자체가 삭제된다.)
		hmap.remove(19);
		System.out.println(hmap);
		
		//갯수확인
		System.out.println("hamp에 저장된 객체 수: "+hmap.size());
	}
	
	public void test2() {
		//map에 저장된 객체 연속 처리
		
		HashMap map = new HashMap();
		
		map.put("one", "비타500");
		map.put("two", "더벤티");
		map.put("three", "핸드크림");
		map.put("four", "에어팟");
		map.put("five", "칫솔");
		
		//1.keySet() - key만 set으로 만든다.
		Set keys = map.keySet(); //->key값들이 set으로 들어간다.
		Iterator keyIt = keys.iterator(); //set이기 때문에 iterator 사용한다. 줄세우기 순서는 뒤죽박죽
		while(keyIt.hasNext()) {
			String key = (String)keyIt.next();
			String val = (String)map.get(key);
			System.out.println(key+"="+val);
		}
		
		
		//2.entrySet() - Map의 내부클래스 Map.Entry를 set으로 만든다.
		//Entry = key+value를 묶어 놓은 객체
		Set set = map.entrySet();//엔트리를 set으로
		Iterator entryIt = set.iterator();
		while(entryIt.hasNext()) {
			Map.Entry entry = (Map.Entry)entryIt.next(); //entry를 가지고 온다.
			
			//System.out.println(entry.getKey()+"="+entry.getValue());
			String key = (String)entry.getKey();
			String val = (String)entry.getValue();
			System.out.println(key+"="+val);
		}
		
		//3.values() - 저장된 value값들만 Collection으로 만든다.
		Collection values = map.values();
		//iterator(), toArray()
		Object[] arr = values.toArray();
		for(int i=0;i<arr.length;i++) {
			String val = (String)arr[i];
			System.out.println(val);
		}
	}
	public void test3() {
		//Score 클래스 객체 생성하여 map에 저장
		HashMap map = new HashMap();
		//hashmap은 저장할 수 있는 객체 타입은 정해져있지 않아서 노란줄로 경고하지만 properties는 string으로 정해져있어서 노란줄 없다.
		map.put("1", new Score("박상은",100));
		map.put("2", new Score("이상은",90));
		map.put("3", new Score("최상은",80));
		
		System.out.println(map);
		
		map.clear();//초기화
		map.put(new Score(), "one");
		map.put(new Score("박상은",100), "one");
		map.put(new Score("이상은",90), "one");
		map.put(new Score("최상은",80), "one");
		
		System.out.println(map);
		
		map.put(new Score("박상은",100), "one");
		
		System.out.println(map);
		
		map.put("key", new Score());
	}
}

























