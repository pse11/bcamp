package silsub1.run;

import silsub1.model.vo.Member;
import silsub2.model.vo.Product;

public class Run {

	public static void main(String[] args) {
		Member mb = new Member();
		mb.setAge(20);
		mb.setEmail("abc@naver.com");
		mb.setGender('f');
		mb.setMemberId("123");
		mb.setMemberName("pse");
		mb.setMemberPwd("1234");
		mb.setPhone("010-1111-2222");
		
		System.out.println(
				"age: "+mb.getAge()+
				"email:"+mb.getEmail()+
				"gender:"+mb.getGender()+
				"memberid:"+mb.getMemberId()+
				"membername:"+mb.getMemberName()+
				"memberpwd:"+mb.getMemberPwd()+
				"phone:"+mb.getPhone()
				);
	}

}
