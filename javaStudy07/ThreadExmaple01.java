package javaStudy07;

public class ThreadExmaple01 {
        public static void main(String[] args) {
            Thread01 t1 = new Thread01();

            Runnable r = new Thread02();
            Thread t2 = new Thread(r);

            t1.start();
            t2.start();

        }
}

    class Thread01 extends Thread {
        public void run() {
            for(int i=0; i < 10; i++ ) {
                System.out.println(getName());	// 조상인 Thread의 getName()을 호출
            }
        }
    }

    class Thread02 implements Runnable {
        public void run() {
            for(int i=0; i<10; i++) {
                System.out.println(Thread.currentThread().getName());
            }
        }
    }

