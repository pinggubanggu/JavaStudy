package JavaStudy08;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateExample {

  public static void main(String[] args) {
    Date d = new Date();

    String input = "2021-08-07";

    DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

    try {
      d = df.parse(input);
    } catch (Exception e) { }

    System.out.println(d);
  }

}
