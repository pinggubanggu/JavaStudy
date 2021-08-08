package JavaStudy08;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class test {

  public static void main(String[] args) throws IOException {

    String day = "2";
    String s = "";

    FileReader fr = new FileReader(".\\src\\miniProject\\" +day + ".txt");
//    FileOutputStream fos = new FileOutputStream(".\\src\\miniProject\\12345.txt");


    String fileName = ".\\src\\miniProject\\" +day + ".txt";
    Stream<String> stream = Files.lines(Paths.get(fileName), Charset.forName("UTF-8"));
    stream.collect(Collectors.toList()).forEach(System.out::println);
    Stream<String> stream1 = Files.lines(Paths.get(fileName), Charset.forName("UTF-8"));
    List<String> list = stream1.collect(Collectors.toList());
    System.out.println(list.get(4));
    String as = list.get(4);
    stream.close();

//    int data  = 0;
//
//    while((data=fr.read())!=-1) {
//      char c = (char)data;
//      s += c;
//    }
//
//    System.out.println(s);
//
//    int ss = s.indexOf("1");
//    int e = s.indexOf(',');
//    String reserveClass = s.substring(ss, e);
//
//    // reserveClass Member 변수에 저장
//
//    // 수강인원 바꾸기
//
//    int a = s.indexOf('>');
//    int b = s.lastIndexOf('>');
//
//
//    String as = s.substring(a+2,e-1);
//    int ab = Integer.parseInt(as)+1;
//    s.replace(as, String.valueOf(ab));
//
//
//
//    fr.close();
  }
}
