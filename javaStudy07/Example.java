package javaStudy07;

enum Direction {
    EAST(1), SOUTH(5), WEST(-1), NORTH(10); // 끝에 ';'를 추가해야 한다.

    private final int value;				// 정수를 저장할 필드(인스턴스 변수)를 추가
    Direction(int value) { this.value = value; }	// 생성자를 추가, 제어자 private 생략

    public int getValue() { return value; }
}

public class Example {
    public static void main(String[] args) {
    }
}
