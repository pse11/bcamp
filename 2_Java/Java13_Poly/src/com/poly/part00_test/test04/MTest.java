package com.poly.part00_test.test04;

public class MTest {

	public static void main(String[] args) {
		Cat cat =new Cat();
		cat.bark();
		cat.eat("참치");
		
		Dog dog = new Dog();
		dog.bark();
		dog.eat("뼈다귀");
		dog.bite();
		
		Pigeon p = new Pigeon();
		p.bark();
		p.eat("벌레");
		p.fly();
		
		Animal a = new Cat();
		a=new Dog();
		a=new Pigeon();
		
		Bird b = new Pigeon();
		//b= new Dog();//강아지 클래스는 bird를 상속받지 않았기 때문에 불가능
		
		//a.fly(); //a 변수 타입이 Animal, Animal에는 fly() 없기때문.
	}

}
