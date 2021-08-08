package javaStudy07;

class ThreadExample02 implements Runnable {
    static boolean autoSave = false;

    public static void main(String[] args) {
        Thread t = new Thread(new ThreadExample02()); // run()이라는 메서드를 가지고 있는 클래스의 객체를 매개변수로 준다.
        t.setDaemon(true);  // 1. 데몬쓰레드로 지정
        t.start();          // 2. start() 호출하여 쓰레드 실행       --> 순서 기억! 거꾸로 하면 예외발생!

        for(int i=1; i <=10; i++) {
            try{
                Thread.sleep(1000);
            } catch(InterruptedException e) {}
            System.out.println(i);

            if(i==5) autoSave = true;
        }
    }

    @Override
    public void run() {
        while(true) {                   // 무한루프 -> 일반쓰레드가 하나도 없을때 자동종료!
            try {
                Thread.sleep(3*1000);
            } catch(InterruptedException e) {}

            if(autoSave) autoSave();
        }
    }

    public void autoSave() {
        System.out.println("작업파일이 자동저장되었습니다.");
    }
}

