package Stream;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

class student {
    int rollno;
    String name;
    int age;
    String sudentClass;

    public student(int rollno, String name, int age, String sudentClass) {
        this.rollno = rollno;
        this.name = name;
        this.age = age;
        this.sudentClass = sudentClass;
    }
    public int getRollno() {
        return rollno;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getSudentClass() {
        return sudentClass;
    }

    @Override
    public String toString() {
        return "student{" +
                "rollno=" + rollno +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sudentClass='" + sudentClass + '\'' +
                '}';
    }
}

public class practice {

    public static void main(String[] args) {
        List<student> ls= new ArrayList<>();
        ls.add(new student(1,"piyush",10,"First"));
        ls.add(new student(2,"piyus11",11,"First"));
        ls.add(new student(4,"piyush12",12,"Second"));
        ls.add(new student(3,"piyush13",13,"Fifth"));
        ls.add(new student(5,"piyush50",50,"Twelfth"));
        ls.add(new student(6,"piyush51",51,"Twelfth"));
        ls.add(new student(50,"piyush100",100,"Fifth"));
        ls.add(new student(6,"piyush159",159,"Fourth"));
        ls.add(new student(70,"piyush50",70,"Fourth"));
        ls.add(new student(80,"piyush90",90,"Fourth"));


        // list of student age less than 50
        List<student> studentLessThanAge50 = ls.stream().filter(student -> student.getAge() < 50).toList();
        System.out.println("studentLessThanAge50 = " + studentLessThanAge50);

        //count of student age less than 50
        long studentLessThanAge502_Count= ls.stream().filter(student -> student.getAge() < 50).count();
        System.out.println("studentLessThanAge502_Count = " + studentLessThanAge502_Count);

        //print First element in list of object
        Optional<student> s = ls.stream().reduce((student s1, student s2) -> s1);
        System.out.println("s = " + s);
        Set<student> set = new HashSet<>();

        // printStudent(duplicateStudents);
        List<student> duplicateStudents = ls.stream().filter((student s1) -> set.add(s1)).collect(Collectors.toList());
        System.out.println("duplicateStudents = " + duplicateStudents);
        Set<student> duplicateStudentsSet = ls.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .entrySet()
                .stream()
                .filter(m -> m.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());
        System.out.println("duplicateStudentsSet = " + duplicateStudentsSet);







    }


}
