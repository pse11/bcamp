package com.test1.run;

import com.test1.model.vo.Employee;

public class Run {
//3개의 생성자를 사용하여 3명의 사원 정보를 배열로 생성한 후 출력 해보고 
//	값이 없는 필드에 각각 값을 입력해 넣어 출력 
//	직원 각각의 보너스가 적용된 연봉을 계산하여 출력하고 
//	총 직원 연봉의 평균을 구하여 출력
	public static void main(String[] args) {
		// 객체배열을 크기 3으로 할당 한 뒤 3개의 생성자를 각각 이용하여 객체 생성 후 출력 
		Employee[] e = new Employee[3];
		e[0]= new Employee();
		e[1]=new Employee(1,"홍길동",19,'M',"01022223333","서울 잠실");
		e[2]=new Employee(2, "강말순", "교육부", "강사", 20, 'F', 1000000, 0.01, "01011112222", "서울 마곡");
		
		for(int i=0;i<3;i++) {
			System.out.println("emp["+i+"] : "+e[i].information());
		}
		System.out.println("===================================");
		// 3개의 객체 중 값이 없는 필드에 각각 값을 넣은 뒤 출력 
		e[0].setEmpNo(0);
		e[0].setEmpName("김말똥");
		e[0].setDept("영업부");
		e[0].setJob("팀장");
		e[0].setAge(30);
		e[0].setGender('M');
		e[0].setSalary(3000000);
		e[0].setBonusPoint(0.2);
		e[0].setPhone("01055559999");
		e[0].setAddress("전라도 광주");
	
		e[1].setDept("기획부");
		e[1].setJob("팀장");
		e[1].setSalary(4000000);
		e[1].setBonusPoint(0.3);
		System.out.println("emp[0] : "+e[0].information());
		System.out.println("emp[1] : "+e[1].information());
		System.out.println("========================================");
		// 직원 각각의 보너스가 적용된 1년 연봉을 계산하여 출력 
		// 연봉 = (급여 + (급여 * 보너스포인트)) * 12 
		int sum =0;
		for(Employee emp:e) {
			int salary=emp.getSalary();
			double bonus = emp.getBonusPoint();
			int result = (int)(salary+(salary*bonus))*12;
			System.out.println(emp.getEmpName()+"의 연봉 : "+result+"원");
			sum+=result;
		}
		System.out.println("========================================");
		// 3명의 직원의 연봉 평균을 구하여 출력
	
		System.out.println("직원들의 연봉의 평균 : "+(int)sum/3+"원");
	}

}
