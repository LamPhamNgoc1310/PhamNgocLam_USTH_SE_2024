public class test {
    public static void main(String[] args) {
        Student Lam = new Student(1, "Lam", "0923543588", "Hanoi");
        UndergradStudent Lam2 = new UndergradStudent(1000000, "Lam2", "0923543588", "Hanoi");
        PostgradStudent Lam3 = new PostgradStudent(1000000000, "Lam3", "0923543588", "Hanoi", 3.5);
        
        System.out.println(Lam.toString());
        System.out.println(Lam2.toString());
        System.out.println(Lam3.toString());
    }
}
