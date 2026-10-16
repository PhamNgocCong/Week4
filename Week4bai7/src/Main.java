import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n=scanner.nextInt();
        List<Student> students = new ArrayList<>();


        for (int i = 0; i < n; i++) {
            String id = scanner.next();
            String name = scanner.next();
            double gpa = scanner.nextDouble();
            students.add(new Student(id, name, gpa));
        }

        students.removeIf(student -> student.getGpa() < 5.0);
        System.out.println("After removing GPA < 5.0:");
        for (Student s : students) {
            System.out.println(s);
        }
        students.sort((s1, s2) -> s1.getName().compareTo(s2.getName()));
        System.out.println("\nAfter sorting by name:");
        for (Student s : students) {
            System.out.println(s);
        }
    }

}
