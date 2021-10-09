package miniProject;

import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ExerciseImpl implements Exercise{

  private Scanner sc = new Scanner(System.in);
  private HashMap<String, ExerciseMember> map = new HashMap<>();  // 회원정보 저장소
  private List<Yoga> yogaFirstTime = new ArrayList<>();  // 첫번째 시간표 저장소
  private List<Yoga> yogaSecondTime = new ArrayList<>(); // 두번째 시간표 저장소
  private List<String> resDays = new ArrayList<>();
  private String id;
  private boolean login;

  @Override
  /** 예약시간표 업데이트 */
  public void tableUpdate() throws IOException {

//    Calendar today = Calendar.getInstance();
//    int todayDay= today.get(Calendar.DAY_OF_WEEK);
//    if(todayDay==1) { // 예약하는 시점이 일요일때만 시간표 업데이트 하기

//    List<String> reserveDays2 = new ArrayList<>();

    for (int index = 0, day = 2; day <= 6; index++, day++) {
      
        yogaFirstTime.add(new Yoga());
        yogaSecondTime.add(new Yoga());
//      resDays.add(" ");

      String fileName = ".\\src\\miniProject\\" + day + ".txt"; // day = 2,3,4,5,6
      // 파일에 있는 문장들을 한줄씩 읽어서 String타입의 stream으로 반환;
      Stream<String> stream = Files.lines(Paths.get(fileName), Charset.forName("UTF-8"));

//      stream.collect(Collectors.toList()).forEach(System.out::println);

      List<String> list = stream.collect(Collectors.toList());  // 스트림을 List로 변환
      yogaFirstTime.get(index).setClasses(list.get(0) + list.get(2));  // index = 0,1,2,3,4
      yogaSecondTime.get(index).setClasses(list.get(0) + list.get(4));
    }
  }

  @Override
  public void init() {

    while(true) {
      Calendar sDay = Calendar.getInstance();
      Calendar eDay = Calendar.getInstance();

      int year = sDay.get(Calendar.YEAR);
      int month = sDay.get(Calendar.MONTH); // 지금은 7월이니 6을 준다.
      int START_DAY_OF_WEEK = 0;
      int END_DAY = 0;

      sDay.set(year, month, 1);
      eDay.set(year, month + 1, 1);

//    month = sDay.get(Calendar.MONTH);

      // 다음달의 첫날에서 하루를 빼면 현재달의 마지막 날이 된다.
      eDay.add(Calendar.DATE, -1);

      // 첫 번째 요일이 무슨 요일인지 알아낸다.
      START_DAY_OF_WEEK = sDay.get(Calendar.DAY_OF_WEEK);

      //eDay에 지정된 날짜를 얻어온다.
      END_DAY = eDay.get(Calendar.DATE);

      // 월은 0부터 시작해서 11로 끝난다. 그래서 +1을 해줘야 한다.
      month = sDay.get(Calendar.MONTH) + 1;

      System.out.println();
      System.out.println("      " + year + "년 " + month + "월");
      System.out.println(" SU MO TU WE TH FR SA");

      // 해당 월의 1일이 어느 요일인지에 따라서 공백을 출력한다.
      // 만일 1일이 수요일이라면 공백을 세 번 찍는다. (일요일(1)부터 시작)
      for (int i = 1; i < START_DAY_OF_WEEK; i++) {
        System.out.print("   ");
      }

      for (int i = 1, n = START_DAY_OF_WEEK; i <= END_DAY; i++, n++) {
        System.out.print((i < 10) ? "  " + i : " " + i);
        if (n % 7 == 0) {
          System.out.println();
        }
      }

      System.out.println();
      System.out.println("--------------------------------------------");
      System.out.println("원하는 번호를 입력하세요.");
      System.out.println("1.회원가입  2.로그인  3.예약 4.예약현황 5.예약취소 6.종료");
      System.out.println(">>");

      String input = sc.nextLine();

      try {
        switch (input) {
        case "1" : join(); break;
        case "2" : login(); break;
        case "3" : reserve(); break;
        case "4" : readReservation(); break;
        case "5" : cancel(); break;
        case "6" : quit(); break;
        default :
          System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
        }
      } catch (InputMismatchException e){
        System.out.println("조건에 맞게 입력해주세요.");
      } catch (NoLoginException me) {
        System.out.println(me.getMessage());
      } catch (Exception e) {
        e.getMessage();
      }
    }
  }

  @Override
  public void join() throws InputMismatchException {

    boolean run = true;

    while (run) {
      System.out.println("*******************");
      System.out.println("아이디 (맨앞만 숫자 불가능/ 대소문자,숫자 모두 가능/ 최소 4자에서 12자까지 특수문자 불가)");
      System.out.println(">>");
      id = sc.nextLine();

      String regExp = "[a-zA-Z]{1}[a-zA-Z0-9]{3,11}"; // 맨앞만 숫자 불가능/ 대소문자,숫자 모두 가능/ 최소 4자에서 12자까지 특수문자 불가)

      // 1. ID가 정규식 조건에 부합하는지
      boolean idMatch = Pattern.matches(regExp, id);

      if (!idMatch) { // ID가 정규식 조건에 부합하지 않으면 부합하면 해당 블럭{}만 수행하고 if문을 빠져나간다.
        System.out.println("ID 로 사용할 수 없습니다 조건에 맞는 아이디를 입력해주세요.");

      } else {    // ID가 정규식 조건에 부합하면 -> 2. 중복 아이디가 없는지
        Predicate<String> predicate = id -> map.containsKey(id);  // 지정된 키(id)가 포함되어 있는지 알려준다.

        if (!predicate.test(id) | map.size() == 0) {

          System.out.println(id + "는 ID로 사용할 수 있습니다.");
          System.out.println("비밀번호 >>");
          String pw = sc.nextLine();

          System.out.println("시작일 (ex.2021-07-29) >> ");
          String startDay = sc.nextLine().trim();

          String Day0fRegExp = "(19|20)\\d{2}-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])";
//          String Day0fRegExp = "/^(20\d{2})-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[0-1])$/";

          // 시작일이 정규식 조건에 부합하는지
          boolean dayMatch = Pattern.matches(Day0fRegExp, startDay);

          if (!dayMatch) { // 정규식 조건에 부합하지 않으면 while문으로 돌아감.
            System.out.println("입력이 조건에 맞지 않습니다. 조건에 맞게 날짜를 입력해주세요.");
          } else {  // 정규식 조건에 맞게 날짜를 입력했으면

            System.out.println("등록 개월수를 입력하세요. (ex. 3개월이면 3을 입력) ");
            int registerMonth = sc.nextInt();
            sc.nextLine();

            System.out.println("주에 몇 회입니까? (ex. 주2회면 2 입력, 주3회면 3 입력, 주 5회면 5 입력)");
            int number = sc.nextInt();
            sc.nextLine();

            List calList = calculateEndDay(startDay, registerMonth);  // 종료일 계산해주는 메서드
            Calendar sDay = (Calendar) calList.get(0);
            Calendar endDay = (Calendar)calList.get(1);

            int couponNumber = calculateCou(sDay, endDay, number);    // 쿠폰횟수 계산해주는 메서드
            System.out.println("쿠폰횟수 " + couponNumber + "회 입니다. ");

            String sEndDay = (String)calList.get(2);

            ExerciseMember exmember = new ExerciseMember(id, pw, startDay, sEndDay, registerMonth, couponNumber);
            map.put(id, exmember);   // 회원정보 저장소에 저장
            System.out.println(id + "님의 회원가입이 완료되었습니다.\n");

            run = false;
          }

        } else {
          System.out.println("이미 중복된 ID가 있습니다.");
          System.out.println("다시 한 번 입력해주세요\n");
        }
      }
    }
  }

@Override
/** 시작일, 등록개월 수에 따른 종료일을 Calendar 객체로 변환하여 List에 저장하여 반환 */
  public List calculateEndDay(String startDay, int registerMonth) {

    DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    Calendar sDay = Calendar.getInstance();
    Calendar eDay = Calendar.getInstance();
    sDay.clear();
    eDay.clear();

    try {
      Date d = df.parse(startDay);
      sDay.setTime(d); // Date를 Calendar로 변환
      eDay.setTime(d);
    } catch (ParseException e) {
     // 위에서 정규식 확인하니 은폐용
    }

//    String[] arr = startDay.split("-");
//    int year = Integer.parseInt(arr[0]);
//    int month = Integer.parseInt(arr[1])-1;
//    int date = Integer.parseInt(arr[2]);
//
//    Calendar sDay = Calendar.getInstance();

//    sDay.set(year, month, date);

//      eDay.set(year, month, date);
      eDay.add(Calendar.MONTH, registerMonth);   // 등록개월수를 더한 날짜가 나옴.
      eDay.add(Calendar.DATE, -1);

      int cedYear = eDay.get(Calendar.YEAR);
      int cedMonth = eDay.get(Calendar.MONTH) +1;
      int cedDate = eDay.get(Calendar.DATE);

      System.out.println("종료일은 " + cedYear + '-' + cedMonth + '-' + cedDate + "일 입니다.");

      String s = String.valueOf(cedYear) + '-' + String.valueOf(cedMonth) +'-' + String.valueOf(cedDate);

      List calList = new ArrayList<>();
      calList.add(sDay);
      calList.add(eDay);
      calList.add(s);
      return calList;

  }

  @Override
  /** 등록개월수, 주 횟수에 따른 자동 쿠폰 횟수 계산메서드 */
  public int calculateCou(Calendar sDay, Calendar eDay, int number) {

    long difference = (eDay.getTimeInMillis() - sDay.getTimeInMillis())/(1000*60*60*24);  // 1/1000초 단위를 -> 일로 바꾸기
    int coupon = (int)(difference / 7) * number;

    return coupon;
  }

  @Override
  public void login() throws IOException {

//    String input = "true";
//
//    Function<String, String> f = input2 -> input2 = "false";  // 변수를 false로 바꿔주는 함수형 인터페이스
//    Predicate<String> p = input3 -> input3.equals("true");  // 변수가 true인지 확인하는 함수형 인터페이스

    boolean run = true;

    while(run) {
      System.out.println("아이디를 입력하세요");
      System.out.println(">>");

      id = sc.nextLine();

      if(map.isEmpty())
        System.out.println("회원가입을 먼저 해주세요.");

      Predicate<String> predicate = id -> map.containsKey(id);  // 지정된 키(id)가 포함되어 있는지 알려준다.

      if(predicate.test(id)) {
          System.out.println("비밀번호를 입력하세요");
          System.out.println(">>");

          String pw = sc.nextLine();

          if(map.get(id).getPassword().equals(pw)) {
            System.out.println("로그인 되었습니다.");
            System.out.println("예약화면이 보여집니다.");
            login = true;
            reserve();
            run = false;
          } else {
            System.out.println("비밀번호가 맞지 않습니다.");
          }
        } else {  // 아이디가 없을때
          System.out.println("입력하신 아이디는 없습니다.");
          run = false;
        }
    }
  }

  @Override
  public void reserve() throws NoLoginException,IOException {

    if(login!=true) {
      throw new NoLoginException("로그인을 해주세요");
    } else {
      Calendar sDay = Calendar.getInstance();
      Calendar eDay = Calendar.getInstance();

      int year = sDay.get(Calendar.YEAR);
      int month = sDay.get(Calendar.MONTH); // 지금은 7월이니 6을 준다.
      int START_DAY_OF_WEEK = 0;
      int END_DAY = 0;

      sDay.set(year, month, 1);
      eDay.set(year, month + 1, 1);

//    month = sDay.get(Calendar.MONTH);

      // 다음달의 첫날에서 하루를 빼면 현재달의 마지막 날이 된다.
      eDay.add(Calendar.DATE, -1);

      // 첫 번째 요일이 무슨 요일인지 알아낸다.
      START_DAY_OF_WEEK = sDay.get(Calendar.DAY_OF_WEEK);

      //eDay에 지정된 날짜를 얻어온다.
      END_DAY = eDay.get(Calendar.DATE);

      // 월은 0부터 시작해서 11로 끝난다. 그래서 +1을 해줘야 한다.
      month = sDay.get(Calendar.MONTH) + 1;

      System.out.println();
      System.out.println("      " + year + "년 " + month + "월");
      System.out.println(" SU MO TU WE TH FR SA");

      // 해당 월의 1일이 어느 요일인지에 따라서 공백을 출력한다.
      // 만일 1일이 수요일이라면 공백을 세 번 찍는다. (일요일(1)부터 시작)
      for (int i = 1; i < START_DAY_OF_WEEK; i++) {
        System.out.print("   ");
      }

      for (int i = 1, n = START_DAY_OF_WEEK; i <= END_DAY; i++, n++) {
        System.out.print((i < 10) ? "  " + i : " " + i);
        if (n % 7 == 0) {
          System.out.println();
        }
      }

      System.out.println();
      System.out.println("--------------------------------------------");
      System.out.println("원하는 날짜를 입력하세요. (ex. 2021-07-31)");
      System.out.println(">>");

      String reserveDay = sc.nextLine();

//    map.forEach((k,v)-> {
      String sDay1 = map.get(id).getStartDay();
      String eDay1 = String.valueOf(map.get(id).getEndDay());
      int couponNumber = map.get(id).getCouponNumber();

//      SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
//      String dfsDay1 = df.format(sDay1);
//      String dfeDay1 = df.format(eDay1);
      System.out.println(id + "님의 수강기간은 " + sDay1 + " ~ " + eDay1 + "," + "횟수는 " + couponNumber + "회");

      // 입력받은 날짜에서 요일 값을 얻어서 해당하는 index 자리로 값을 변환

      int ytIndex = getDayOfWeek(reserveDay);

      System.out.println(yogaFirstTime.get(ytIndex)); // 해당하는 요일의 요가클래스들 출력
      System.out.println(yogaSecondTime.get(ytIndex));
      System.out.println();
      System.out.println(reserveDay + "의 몇번째 수업을 들으시겠습니까?");
      System.out.println("해당하는 번호를 입력하세요.( ex. 1)");
      System.out.println("강의당 최대예약인원은 10명입니다.");
      System.out.println(">>");

      int resClassNumber = sc.nextInt();
      sc.nextLine();

      String[] s = map.get(id).getReserveDays();

      // 요일에 맞게 ExerciseMember에 있는 변수 reserveDays(List)에 저장
      if (resClassNumber == 1) {
        s[ytIndex] = yogaFirstTime.get(ytIndex).getClasses();
        yogaFirstTime.get(ytIndex).setPlusAttendee(); // 예약인원++
      } else {
        s[ytIndex] = yogaSecondTime.get(ytIndex).getClasses();
        yogaSecondTime.get(ytIndex).setPlusAttendee(); // 예약인원++
      }

      map.get(id).setReserveDays(s);  // ExerciseMember의 변수 reserveDays에 예약정보 저장
      map.get(id).setMinusCouponNumer();// 쿠폰횟수 차감

      System.out.println(reserveDay + ", " + resClassNumber + "번째 수업 예약완료하였습니다.");
    }
  }


  @Override
  /** 입력받은 날짜 -> Calendar 객체로 변환하여 요일의 값 얻기
   *  요일의 값을 (요일)배열의 index 번호에 맞게 변수 값 변환
   *  @param String inputDay 예약 or 취소 날짜
   *  @return Int ytIndex 월요일(2) : ytIndex = 0, 화요일(3) : ytIndex = 1; */
  public int getDayOfWeek(String inputDay) {

    Date d = new Date();
    DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    try {
      d = df.parse(inputDay);
    } catch (ParseException e) { }

    Calendar cal = Calendar.getInstance();
    cal.setTime(d);
    cal.get(Calendar.DAY_OF_WEEK);
    int day = cal.get(Calendar.DAY_OF_WEEK);  // 입력한 날짜 요일 얻기 1: 일 , 2: 월
    int ytIndex = 0;
    switch(day) {
      case 2 : ytIndex = 0; break;  //  월
      case 3 : ytIndex = 1; break;  //  화
      case 4 : ytIndex = 2; break;  //  수
      case 5 : ytIndex = 3; break;  //  목
      case 6 : ytIndex = 4; break;  //  금
    }

    return ytIndex;
  }


  @Override
  /** 예약현황 보기 */
  public void readReservation() throws NoLoginException {

    if(login!=true) {
      throw new NoLoginException("로그인을 해주세요");
    } else {
      System.out.println(id + "님의 예약현황");

      String[] s = map.get(id).getReserveDays();
      for (int i = 0; i < 5; i++) {
        if (s[i] != null) {
          System.out.println(s[i]);
        }
      }
    }

//    Stream<String> stream = reserveList.stream();
//    stream.forEach(System.out::println);
  }

  @Override
  public void cancel() throws NoLoginException {

    if(login!=true) {
     throw new NoLoginException("로그인을 해주세요");
    } else {
      boolean run = true;
      readReservation();  // 예약현황 보여주기

      while (run) {
        System.out.println("\n" + "취소할 수업의 날짜를 입력해주세요.(ex.2021-07-31)");
        System.out.println(">>");

        String cancelDay = sc.nextLine();

        String Day0fRegExp = "(19|20)\\d{2}-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])";

        boolean dayMatch = Pattern.matches(Day0fRegExp, cancelDay);

        if (!dayMatch) { // 정규식 조건에 부합하지 않으면 while문으로 돌아감.
          System.out.println("입력이 조건에 맞지 않습니다. 조건에 맞게 날짜를 입력해주세요.");
        } else {  // 정규식 조건에 맞게 날짜를 입력했으면

          int ytIndex = getDayOfWeek(cancelDay);

          String[] s = map.get(id).getReserveDays();

          // 예약인원--
          // TODO 공백있을시 위험
          // FIXME
          int classNumber = s[ytIndex].indexOf(')') + 2;
          if (classNumber == 1) {
            yogaFirstTime.get(ytIndex).setMinusAttendee();
          } else {
            yogaSecondTime.get(ytIndex).setMinusAttendee();
          }

          // 쿠폰횟수++
          map.get(id).setPlusCouponNumer();
          // ExerciseMember의 reserveDays의 예약정보 삭제
          s[ytIndex] = " ";
          map.get(id).setReserveDays(s);

          System.out.println(cancelDay + " 수업예약이 취소되었습니다.");
          run = false;
        }
      }
    }
  }

  @Override
  public void quit() {
    System.out.println("프로그램을 종료합니다.");
    System.exit(0);
  }

}

/** 로그인 안했을때 메뉴실행예외  */
class NoLoginException extends RuntimeException {
  NoLoginException(String msg) {
   super(msg);
  }
}

