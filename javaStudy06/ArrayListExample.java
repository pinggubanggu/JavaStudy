package javaStudy06;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayListExample {
    public static void main(String[] args) {
        ArrayList list1 = new ArrayList(10);
        list1.add(new Integer(5));
        list1.add(Integer.valueOf(4));
        list1.add(Integer.valueOf(0));
        list1.add(Integer.valueOf(6));
        list1.add(Integer.valueOf(3));
        list1.add(Integer.valueOf(1));

        ArrayList list2 = new ArrayList(list1.subList(1,4));
//        print(list1, list2);

        Collections.sort(list1);
        Collections.sort(list2);
//        print(list1, list2);

//        System.out.println("list1.containsALL(list2) : " + list1.containsAll(list2));

        list2.add("B");
        list2.add("C");
        list2.add(3,"A");
//        print(list1,list2);

        list2.set(3,"AA");

        System.out.println("list1.retainAll(list2) : " + list1.retainAll(list2));

//        print(list1,list2);

        for(int i = list2.size()-1; i>=0; i--) {
            if(list1.contains(list2.get(i)))
                list2.remove(i);
        }

        print(list1,list2);

    }

    private static void print(ArrayList list1, ArrayList list2) {
        System.out.println("list1 : " + list1);
        System.out.println("list2 : " + list2);
        System.out.println();

    }
}
