package com.test04;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MTest_Stream {
	public static void main(String[] args) {
		//스트림(Stream)
		//컬렉션 데이터를 함수형으로 처리하는 API
		//필터링, 매핑, 집계 등의 작업을 for, if등을 생략한채로 가능하다.
		List<Integer> numbers = Arrays.asList(1,2,3,4,5,6); //작성한 값들로 list화 시킨다.
		System.out.println(numbers);
		
		numbers.stream()
				.filter(n->n%2==0)
				.forEach(System.out::println);; //짝수인지 홀수인지 확인 이 경우 짝수이면 남긴다.
		//컬렉션을 forEach를 통해 하나씩 println하겠다.
				
		//filter() : 스트림에서 뽑아져 나오는 데이터에서 특정 데이터만 골라내는 역할
		//			매개변수로 boolean 값을 리턴하는 람다식을 넣어준다.
		//collect() : 처리 결과가 Stream인 데이터들을 다시 Collection 객체로 반환해주는 기능
				
		List<String> p = Arrays.asList("홍길동","이순신","김창진","박창진","강창진");
		List<String> jin = p.stream().filter(name->name.contains("진")).collect(Collectors.toList()); //Collectors.toList : 스트림에서 처리된 요소들을 List형태로 반환
		System.out.println(jin);
		
		
		//map() : 요소들을 특정조건에 해당하는 값으로 반환해준다.
		List<String> w = Arrays.asList("java","html","css","javascript");
		
		List<String> res = w.stream().map(String::toUpperCase).collect(Collectors.toList()); //String으로 된걸 모두 다 toUpperCase로 바꿔준다.
		System.out.println("res: "+res);
		System.out.println("w: "+w);
		
		//10보다 작은 숫자만(filter) 제곱해서(map) 리스트로(collect) 만들자
		List<Integer> num = Arrays.asList(2,6,7,8,9,12,18,22);
		List<Integer> res2 = 
				num.stream().filter(n->n<10)
				.map(n->n*n).
				collect(Collectors.toList());
		System.out.println(res2);
		System.out.println(num);
		
		//count() : 요소의 갯수를 세어준다.
		System.out.println(w.stream().filter(word->word.contains("t")).count());
		
		//1~45까지의 숫자를 랜덤으로 6개 추출한 리스트 생성해보기
		//generate() 순서 없는 무한한 스트림 생성
		//limit() 개수 제한
		//distinct() : 중복 제거
		List<Integer> lotto = Stream
							.generate(()->(int)(Math.random()*45)+1)
							.distinct() //중복 제거
							.limit(6)
							.sorted()
							.collect(Collectors.toList());
		lotto.forEach(System.out::println);
		
		//anyMatch() : 하나라도 일치하는게 있는지 찾아보는 것
		boolean tf = num.stream().anyMatch(n->n%3==0);
		System.out.println("3의 배수 존재 여부: "+tf);
		tf = num.stream().anyMatch(n->n%5==0);
		System.out.println("5의 배수 존재 여부: "+tf);
		
		//스트림 생성
		Stream<String> s01 = Stream.empty(); //비어있는 스트림 생성
		
		//builder : 직접 원하는 값을 넣을 수 있다.
		Stream<String> s02 = Stream.<String>builder().add("Hello").add("Java").add("Oracle").build();
		s02.forEach(System.out::println);
		
		
		//IntStream : 정수만 다루는 스트림
		IntStream rn01 = IntStream.range(1, 10)//1~9까지의 정수
										.skip(3) //처음 3개 건너띔
										.limit(5); //5개만
		rn01.forEach(System.out::println);
		
		IntStream.rangeClosed(1, 10)  //1~10까지의 정수
						.forEach(System.out::println);
	}
}
	
	
	
