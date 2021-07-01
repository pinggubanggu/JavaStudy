package javaStudy06;

public class CloneExample01 implements Cloneable{   // 1. Cloneable인터페이스를 구현한다.

    public Object clone() { // 2. 접근제어자를 protected에서 public으로 변경
        Object obj = null;
        try {
            obj = super.clone();    // 3. try-catch내에서 조상클래스의 clone()을 호출
        }catch(CloneNotSupportedException e) { }
        return obj;
    }
}


