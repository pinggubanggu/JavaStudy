package javaStudy07;

interface MyFunction {
    void run();
}

public class Ex14_1 {
  static void execute(MyFunction f) {   // 매개변수의 타입이 MyFunction인 메서드
    f.run();
  }

  static MyFunction getMyFunction() {
    return ()-> System.out.println("f3.run()");
  }

  public static void main(String[] args) {

    MyFunction f1 = () -> System.out.println("f1.run()"); // 람다식으로 MyFunction의 run()을 구현

    MyFunction f2 = new MyFunction() {    // 익명클래스로 run() 을 구현
      @Override
      public void run() {
        System.out.println("f2.run()");
      }
    };

    MyFunction f3 = getMyFunction();

    f1.run();
    f2.run();
    f3.run();

    execute(f1);
    execute(()-> System.out.println("run()") );
  }
}
