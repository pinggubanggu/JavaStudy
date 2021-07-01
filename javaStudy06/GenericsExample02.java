package javaStudy06;

import java.util.HashMap;

class Student {
    String name ="";
    int ban;
    int no;

    Student () { }

    Student(String name, int ban, int no) {
        this.name = name;
        this.ban = ban;
        this.no = no;
    }

    public String toString() {
        return "이름 : " + name + ", 반 : " + ban + ", 번호 : " + no;
    }

}
public class GenericsExample02 {
    public static void main(String[] args) {
        HashMap<String, Student> map = new HashMap<String, Student>();

        map.put("김자바", new Student("김자바",1,1));

//        Iterator it = map.entrySet().iterator();
//
//        while(it.hasNext()) {
//            System.out.println(it.next());
//        }
        Student s1 = map.get("김자바");

        System.out.println(s1);
    }
}
