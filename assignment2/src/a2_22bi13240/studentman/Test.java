package a2_22bi13240.studentman;

public class Test {
	public static void main(String args[]) {
		Student lam1 = new Student(123, "lam1", "0923543588", "hanoi");
		UndergradStudent lam2 = new UndergradStudent(123456, "lam2", "0923543589", "hanoi1");
		PostgradStudent lam3 = new PostgradStudent(123456789, "lam3", "0923543580", "hanoi2", 3.9);

		lam2.setAddress("HCM");
		System.out.println(lam1.repOK());
		System.out.println(lam2.toHtmlDoc());
		System.out.println(lam3.toHtmlDoc());

	}
}
