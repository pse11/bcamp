package silsub1.run;

import silsub1.model.vo.Member;

public class Run {

	public static void main(String[] args) {
		Member mb = new Member();
		mb.setMemberId("admin");
		mb.setMemberPwd("1234");
		mb.setMemberName("박상은");
		mb.setAge(25);
		mb.setGender('F');
		mb.setPhone("010-1234-1234");
		mb.setEmail("aser@asdf");
		
		String result ="";
		result+=mb.getMemberId()+", ";
		result+=mb.getMemberPwd()+", ";
		result+=mb.getMemberName()+", ";
		result+=mb.getAge()+", ";
		result+=mb.getGender()+", ";
		result+=mb.getPhone()+", ";
		result+=mb.getEmail()+", ";
		System.out.println(result);
	}

}
