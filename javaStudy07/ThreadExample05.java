package javaStudy07;

public class ThreadExample05 {
    static long startTime = 0;

    public static void main(String[] args) {
        Thread11 t11 = new Thread11();
        Thread110 t110 = new Thread110();
        t11.start();
        t110.start();
        startTime = System.currentTimeMillis();

        try {
            t11.join();     // main 쓰레드가 t11의 작업이 끝날 때까지 기다린다.
            t110.join();    // main 쓰레드가 t110의 작업이 끝날 때까지 기다린다.
        } catch (InterruptedException e) { }
        System.out.println("소요시간 : " + (System.currentTimeMillis() - ThreadExample05.startTime));
    }
}

class Thread11 extends Thread {
    public void run() {
        for(int i=0; i < 300; i++) {
            System.out.print("-");
        }
    }
}

class Thread110 extends Thread {
    public void run() {
        for(int i=0; i < 300; i++) {
            System.out.print("|");
        }
    }
}
