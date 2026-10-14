import java.util.*;
class Student {
    private int id;
    private String name;
    private double cgpa;
    public Student(int id, String name, double cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }
    public int getId() {return this.id; }
    public String getName() {return this.name; }
    public double getCgpa() {return this.cgpa; }
}
class StudentComparator implements Comparator<Student> {
    public int compare(Student s1, Student s2) {
        if (Double.compare(s2.getCgpa(), s1.getCgpa()) != 0) {
            return Double.compare(s2.getCgpa(), s1.getCgpa());
        }
        if (s1.getName().compareTo(s2.getName()) != 0) {
            return s1.getName().compareTo(s2.getName());
        }
        return Integer.compare(s1.getId(), s2.getId());
    }
}
public class JavaSort {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < n; i++) {
           int id = sc.nextInt();
           String name = sc.next();
           double cgpa = sc.nextDouble();
           students.add(new Student(id, name, cgpa));
        }
        StudentComparator comp = new StudentComparator();
        students.sort(comp);
        for (Student s: students) System.out.println(s.getName());
    }
}