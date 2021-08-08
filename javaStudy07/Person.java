package javaStudy07;

public class Person {
  public static void main(String[] args) {
    Person person = new Person();
    LunchBox lunchBox = person.getLunchBox();
  }
    private LunchBox lunchBox;
    public LunchBox getLunchBox() {
      return lunchBox; }
  }

  class LunchBox {
    private Beverage beverage;
    public Beverage getBeverage() {
      return beverage; }
  }

  class Beverage {
    private String name;
    public String getName() {
      return name; }
  }


