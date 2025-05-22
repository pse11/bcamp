package com.poly.part00_test.test01;

public class MTest {
	public static void main(String[] args) {
		Dog dog = new Dog(); //Dog 객체 생성
		dog.bark();
		dog.eat("뼈다귀");
		
		Cat cat = new Cat();
		cat.bark();
		cat.eat("생선");
		
		//Animal a = new Animal(); //추상클래스이기 때문에 객체로 만들수없다.
		//단,
		Animal a = new Dog();
		Animal b = new Cat();
		//자식 클래스 객체는 저장할 수 있다.
		// = 다형성 적용이 된다.
		a.bark();
		b.bark();
	}
}
