public class Practise {
  static int c = 20;

    public static void main(String[] args) {

      TestClass tc1 = new TestClass();
      tc1.a = 3;

      TestClass tc2 = new TestClass();
      tc2.a = 4;

      System.out.println("tc1.a="+tc1.a+"  tc2.a="+tc2.a);
      System.out.println("tc1="+tc1+"  tc2="+tc2);

      System.out.println("tc1.b="+tc1.b+"  tc2.b="+tc2.b);

      // Practise.TestClass.a = 3; //컴파일에러
      System.out.println(Practise.TestClass.c);
      System.out.println("static TestClass.c=" + TestClass.c);

    }

    static class TestClass {
      int a;
      int b = c;
      static int c = 200;

    }

  }
