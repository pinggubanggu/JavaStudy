package javaStudy07;

import java.util.*;

enum Direction {
    EAST(1), SOUTH(5), WEST(-1), NORTH(10); // 끝에 ';'를 추가해야 한다.

    private final int value;				// 정수를 저장할 필드(인스턴스 변수)를 추가
    Direction(int value) { this.value = value; }	// 생성자를 추가, 제어자 private 생략

    public int getValue() { return value; }
}

public class Example01 {
    public static void main(String[] args) {

        HashMap map = new HashMap();
        map.put("김자바", new Integer(100));
        map.put("나자바", new Integer(90));
        map.put("박자바", new Integer(80));
        map.put("이자바", new Integer(70));

        Object o = map.get("박자바");
        System.out.println(o);

//        Collection values = map.values();
//        Iterator it = values.iterator();
//
//        while(it.hasNext()) {
//            System.out.println(it.next());
//        }



    }
}
