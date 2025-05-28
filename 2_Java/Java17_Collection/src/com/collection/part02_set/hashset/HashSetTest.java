package com.collection.part02_set.hashset;

import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetTest {
	public void test() {
		HashSet hset = new HashSet();
		//Set hset2 = new HashSet();
		
		//데이터 추가 (add)
		//컬렉션안에는 객체만 저장 가능하다. 
		hset.add("Java"); //스트링 객체
		hset.add(123);    //wrapper클래스로 객체화 되어 Integer객체 되어 저장
		hset.add(45.67);
		hset.add(new Date());
		
		//순서 유지 안된다.
		System.out.println("hset: "+hset);
		
		//중복 허용 안한다.
		hset.add("Java");
		hset.add(123);
		System.out.println("hset: "+hset);
		System.out.println("저장된 객체 수: "+hset.size());
		System.out.println("포함 확인 : "+hset.contains(123));
		
		//저장된 객체에 하나씩 접근 (Iterator, toArray)
		//Iterator 사용
		//iterator() 메소드 : 저장된 객체를 목록으로 만들어 준다. 줄을 세운다.
		Iterator it = hset.iterator();
		while(it.hasNext()) { //일회용이다. 커서를 맨마지막으로 옮겼으니.
			System.out.println(it.next());
		}
		
		System.out.println("한번더"); 
		it= hset.iterator();//한번더 출력하고 싶을 땐 iterator다시 생성
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		//toArray()사용
		Object[] ar = hset.toArray();
		for(int i=0;i<ar.length;i++) {
			System.out.println(i+":"+ar[i]);
		}
		//삭제 (remove)
		hset.remove(123);
		System.out.println(hset);
		hset.clear(); //전체 지움
		System.out.println("비었나?:"+hset.isEmpty());
	}
	public void test2() {
		//데이터 중복 저장
		Set<Member> set = new HashSet<Member>();
		//<Member> => 제너릭 
		set.add(new Member("고윤정",20,"010-1234-1234"));
		set.add(new Member("제니",30,"010-2222-3333"));
		set.add(new Member("고민시",40,"010-4444-6666"));
		
		//set.add(set); 에러 발생. 지금 set에는 Member클래스 객체만 저장 가능
		System.out.println(set);
		
		set.add(new Member("고윤정",20,"010-1234-1234"));
		set.add(new Member("제니",30,"010-2222-3333"));
		
		System.out.println(set);
		
		//hashcode, equals를 오버라이딩하면 중복이 안된다. Member클래스에서 hashcode,equals오버라이딩
		//위 test()에서 따로 hashcode, equals 작성안한 이유는 String, Integer 타입이기 때문에 자동으로 hashcode, equals에 대해 오버라이딩 되어있다.
	}
}

