package miniProject;

public class Yoga {
  private String classes;
  private int attendee;

  public String getClasses() {
    return classes;     // ex. 2021년 8월 9일 (월) 1. 하타요가 19:20~ 20:20
  }

  public void setClasses(String classes) {
    this.classes = classes;
  }

  public int getAttendee() {
    return attendee;
  }

  public void setAttendee(int attendee) { // 수강인원 10명 제한
    if(attendee > 10) return;
    this.attendee = attendee;
  }

  public void setPlusAttendee() {
    if(attendee > 10) return;
    attendee++;
  }

  public void setMinusAttendee() {
    if(attendee <= 0) return;
    attendee--;
  }

  @Override
  public String toString() {
    return  classes + ", 예약인원 = " + attendee + "명";
  }
}
