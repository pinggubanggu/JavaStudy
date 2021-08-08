package javaStudy07;

public class ThreadExample03 {
    public static void main(String[] args) {
        
        ThreadEx01 t1 = new ThreadEx01();
        ThreadEx02 t2 = new ThreadEx02();
        
        t1.start(); t2.start();

        try {
//            t1.sleep(2000);                // 이렇게 해도 t1.sleep(2000)을 실행하는 main쓰레드가 실행된다.
                                             // 그래서 이렇게 오해하게 코드를 작성하면 안된다!!!
            Thread.sleep(2000);         // 이것을 실행하는 main쓰레드가 2초 잠들게 되는 것이다.
        } catch (InterruptedException e) { }

        System.out.print("main 종료");
            
    }
}

class ThreadEx01 extends Thread {
    public void run() {
        for(int i=0; i<300; i++) System.out.print("-");
        System.out.print("th1종료");
    }
}

class ThreadEx02 extends Thread {
    public void run() {
        for(int i=0; i<300; i++) System.out.print("|");
        System.out.print("th2종료");
    }
}