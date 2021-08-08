package JavaStudy08;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class createFileTest {
  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    System.out.println("파일이름을 입력해주세요");
    System.out.println(">>");

    String input = sc.nextLine().trim();

    try {
      File f = createFile(input);
      System.out.println( f.getName() + "파일이 성공적으로 생성되었습니다.");
    } catch (Exception e) {
      System.out.println(e.getMessage() + "다시 입력해 주시기 바랍니다.");
    }
  }

  static File createFile(String fileName) throws Exception {
    if (fileName==null || fileName.equals(""))
      throw new Exception("파일이름이 유효하지 않습니다.");
    File f = new File(fileName);
    // File객체의 createNewFile메서드를 이용해서 실제 파일을 생성한다.
    f.createNewFile();
    return f;
  }
}

