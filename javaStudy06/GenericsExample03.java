package javaStudy06;

import java.util.ArrayList;
import java.util.List;

class Student01 { }
public class GenericsExample03 {
    public static void main(String[] args) {
        List list  = new ArrayList();
        list.add("1");
        list.add("자바");
        list.add(new Student01());

        System.out.println(list.toString());




    }


}
