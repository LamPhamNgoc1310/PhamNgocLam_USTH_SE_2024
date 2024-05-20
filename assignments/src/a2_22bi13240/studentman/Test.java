package a2_22bi13240.studentman;
import java.util.List;
import java.util.ArrayList;

public class Test {
	public static void main(String args[]) {
		ProgStudentMan studentMan = new ProgStudentMan();
		
		// StudentMan array 
		Object[] studentManArr = {};
		// Student object data
		Object[] studentData = new Object[]{123, "lam1", "0923543588", "hanoi"};		
		Student student = studentMan.createStudent(studentData);
		studentMan.addStudent(student);
		
//		// UndergradStudent object data
//		Object[] undergradStudentData = new Object[]{123456, "lam2", "0923543589", "hanoi1"};
//		UndergradStudent underGradStudent = (UndergradStudent) studentMan.createStudent(undergradStudentData);
//		
//		// PostgradStudent object data
//		Object[] postgradStudentData = new Object[]{123456789, "lam3", "0923543580", "hanoi2", 3.9f};
//		PostgradStudent postGradStudent = (PostgradStudent) studentMan.createPostgradStudent(postgradStudentData);
//		
//		Student[] students = {student, underGradStudent, postGradStudent};
//		for(int i = 0; i < students.length; i++) {			
//			studentMan.addStudent(students[i]);
//		}
		
		studentMan.objectIterator();
//		
//		for (int i = 0; i < students.length; i++) {
//			studentMan.addStudent(lam1);
//		}
//		System.out.println(studentMan.toString());
//		System.out.println(students[0]);
//		
	}
}
