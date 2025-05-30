package com.silsub1;

import java.util.Arrays;
import java.util.List;

public class Silsub01 {

	public static void main(String[] args) {
		Trader raoul = new Trader("kim","Seoul");
		Trader mario = new Trader("lee","Suwon");
		Trader alan = new Trader("park","Busan");
		Trader brian = new Trader("choi","Incheon");
		
		List<Transaction> transactions = Arrays.asList(
	        new Transaction(brian, 2021, 500),
	        new Transaction(raoul, 2022, 1200),
	        new Transaction(raoul, 2021, 300),
	        new Transaction(mario, 2022, 620),
	        new Transaction(mario, 2022, 810),
	        new Transaction(alan, 2022, 990)
	    );
				
		// 1. 2021년에 일어난 모든 트랜잭션을 찾아 값을 오름차순으로 정렬하시오.
		List<Transaction> tlist1 = transactions.stream().filter(year->)
		
        // 2. 2022년에 일어난 모든 트랜잭션을 찾아 필드 value를 기준으로 오름차순으로 정렬하시오.
  
        // 3. 거래자가 근무하는 모든 도시를 중복 없이 나열하시오.
    
        // 4. 서울에서 근무하는 모든 거래자를 찾아서 이름순으로 정렬하시오.

        // 5. 모든 거래자의 이름을 알파벳 순으로 정렬해서 반환하시오.

        // 6. 인천에 거래자가 있는가?

        // 7. 수원에 거주하는 거래자의 모든 트랜잭션 값을 출력하시오.

        // 8. 전체 트랜잭션 중 필드value의 값이 최댓값은 얼마인가?
	}

}
