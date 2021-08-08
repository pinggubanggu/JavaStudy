package javaStudy07;

import java.util.function.Predicate;

public class Ex14_3 {

  public static void main(String[] args) {
    String str1 = "abc";
    String str2 = new String("abc");

    Predicate<String> p2 = Predicate.isEqual(str1);
    boolean result = p2.test(str2);
    System.out.println(result);
  }
}
