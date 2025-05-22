package silsub4.model.Run;

import silsub4.model.vo.Student;

public class Run {
	public static void main(String[] args) {
		Student s = new Student();
		s.setGrade(5);
		s.setClassroom(2);
		s.setName("pse");
		s.setHeight(160.5);
		s.setGender('F');
		
		System.out.println(s.information());
	}
	
}
