package javaStudy06;

import java.time.LocalDate;

public class LocalDateExample01 {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        LocalDate tommorrow = today.plusDays(1);

        int result = today.compareTo(tommorrow); // 같으면 0, today가 이전이면 -1, today가 이후면 1
//        Period p = Period.between(today, tommorrow);
//        System.out.println(p);
        System.out.println(result);
    }
}
