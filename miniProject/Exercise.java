package miniProject;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;

public interface Exercise {

  /** 초기화면 실행 */
  void init();

  /** 회원가입 */
  void join();

  /** 시작일, 등록개월 수에 따른 종료일을 Calendar 객체로 변환하여 List에 저장하여 반환 */
  List<Calendar> calculateEndDay(String startDat, int registerMonth);

  /** 등록개월수, 주 횟수에 따른 자동 쿠폰 횟수 계산메서드 */
  int calculateCou(Calendar sDay, Calendar eDay, int number);

  void login() throws IOException;

  void reserve() throws IOException;

  /** 입력받은 날짜 -> (요일)배열의 index 번호에 맞게 변수 값 변환 */
  int getDayOfWeek(String inputDay);

  /** 예약시간표 업데이트 */
  void tableUpdate() throws IOException;

  /** 예약현황 보기 */
  void readReservation();

  void cancel();

  void quit();

}
