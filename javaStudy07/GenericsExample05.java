package javaStudy07;



import java.util.ArrayList;

class Apple { }

public class GenericsExample05 {
    public static void main(String[] args) {


        ArrayList list = new ArrayList();
        list.add(new Apple());
        list.add(1);
        list.add("1");
        System.out.println(list.toString());
    }
}
