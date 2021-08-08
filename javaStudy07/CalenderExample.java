package javaStudy07;

import java.util.Calendar;

public class CalenderExample {

  public static void main(String[] args) {

    Calendar sDay = Calendar.getInstance();
    Calendar eDay = Calendar.getInstance();

    int year = sDay.get(Calendar.YEAR);
    int month= sDay.get(Calendar.MONTH); // 지금은 7월이니 6을 준다.
    int START_DAY_OF_WEEK = 0;
    int END_DAY = 0;


    // 월의 경우 0부터 11까지의 값을 가지므로 1을 빼주어야 한다.
    // ex) 2019년 10월 1일 -> sDay.set(2019,09,1);과 같이 해줘야 한다.
    sDay.set(year, month, 1);
    eDay.set(year, month+1, 1);

//    month = sDay.get(Calendar.MONTH);

    // 다음달의 첫날에서 하루를 빼면 현재달의 마지막 날이 된다.
    eDay.add(Calendar.DATE, -1);

    // 첫 번째 요일이 무슨 요일인지 알아낸다.
    START_DAY_OF_WEEK = sDay.get(Calendar.DAY_OF_WEEK);

    //eDay에 지정된 날짜를 얻어온다.
    END_DAY = eDay.get(Calendar.DATE);



    month = sDay.get(Calendar.MONTH)+1;

    System.out.println();
    System.out.println("      " + year + "년 " + month + "월");
    System.out.println(" SU MO TU WE TH FR SA");

    // 해당 월의 1일이 어느 요일인지에 따라서 공백을 출력한다.
    // 만일 1일이 수요일이라면 공백을 세 번 찍는다. (일요일부터 시작)
    for (int i = 1; i < START_DAY_OF_WEEK; i++) {
      System.out.print("   ");
    }

    for(int i=1, n=START_DAY_OF_WEEK ; i <= END_DAY; i++, n++) {
      System.out.print((i<10) ? "  " +i : " "+i );
      if (n % 7 == 0) {
        System.out.println();
      }
    }

    System.out.println("--------------------------");
    System.out.println("1.회원가입  2.로그인  3.예약");

  }
}
