import java.util.*;
import java.util.stream.Collectors;

class student{
    int id ;
    int mark;
    String name;
    String className;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassName() {
        return className;
        }

    public void setClassName(String className) {
        this.className = className;
        }

    public student(int id, int mark, String name, String className) {
        this.id = id;
        this.mark = mark;
        this.name = name;
        this.className = className;
        }

}



public class StreamApiQuestions {

    public static void main(String[] args) {
        List<student> ls = Arrays.asList(new student(1,23,"test","2"),
                new student(2,32,"adi","3") ,
                new student(3,20,"krish","2"),
                new student(4,50,"apu","2"),
                new student(5,10,"pau","2")
                );

        List<Integer>  ls1 = Arrays.asList(1,34,16,125,456);

        //Name Starts with A
        List<student> a1 = ls.stream().filter(a -> a.getName().startsWith("a")).toList();
        a1.forEach(student -> System.out.println(student.getName()));

        //
        Map<String, List<student>> collect = ls.stream().collect(Collectors.groupingBy(student::getClassName));
        System.out.println(collect.size());
        System.out.println(collect);

        ls1.stream().map(s->s+ "").filter(s -> s.startsWith("1")).forEach(System.out::println);




    }

}
