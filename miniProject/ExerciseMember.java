package miniProject;

import java.util.ArrayList;
import java.util.List;

public class ExerciseMember {

  private String id;
  private String password;
  private String startDay;
  private String endDay;
  private int registerMonth;
  private int couponNumber;
  private String[] reserveDays = new String[5];
//  private List<String> reserveDays2 = new ArrayList<>();

  public ExerciseMember(String id, String password, String startDay, String endDay, int registerMonth, int couponNumber) {
    this.id = id;
    this.password = password;
    this.startDay = startDay;
    this.endDay = endDay;
    this.registerMonth = registerMonth;
    this.couponNumber = couponNumber;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  String getPassword() {
    return password;
  }

  void setPassword(String password) {
    this.password = password;
  }

  public String getStartDay() {
    return startDay;
  }

  public void setStartDay(String startDay) {
    this.startDay = startDay;
  }

  public String getEndDay() {
    return endDay;
  }

  public void setEndDay(String endDay) {
    this.endDay = endDay;
  }

  public int getRegisterMonth() {
    return registerMonth;
  }

  public void setRegisterMonth(int registerMonth) {
    this.registerMonth = registerMonth;
  }

  public int getCouponNumber() {
    return couponNumber;
  }

  public void setCouponNumber(int couponNumber) {
    this.couponNumber = couponNumber;
  }

  public void setPlusCouponNumer() {
    couponNumber++;
  }

  public void setMinusCouponNumer() {
    couponNumber--;
  }

  public String[] getReserveDays() {
    return reserveDays;
  }

  public void setReserveDays(String[] reserveDays) {
    this.reserveDays = reserveDays;
  }

//  public List<String> getReserveDays2() {
//    return reserveDays2;
//  }
//
//  public void setReserveDays2(List<String> reserveDays2) {
//    this.reserveDays2 = reserveDays2;
//  }
//}
