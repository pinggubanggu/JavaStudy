package javaStudy07;

import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;


public class synchronizedExample02 {
    public static void main(String[] args) throws Exception{
        Table table = new Table();  //  여러 쓰레드가 공유하는 객체

        Thread cust1 = new Thread(new Customer(table, "dount"), "CUST1");
        cust1.setPriority(10);
        cust1.start();

        new Thread(new Customer(table, "burger"), "CUST2").start();
        new Thread(new Cook(table), "COOK").start();


        Thread.sleep(4000);
        System.exit(0);
    }
}

class Customer implements Runnable {
    private Table table;
    private String food;

    Customer(Table table, String food) {
        this.table = table;
        this.food = food;
    }

    public void run() {
        while(true) {
            try{ Thread.sleep(1000);} catch(InterruptedException e) { }
            String name = Thread.currentThread().getName();

            table.remove(food);
            System.out.println(name + " ate a " + food);
        }
    }
}

class Cook implements Runnable {
    private Table table;

    Cook(Table table) { this.table = table; }

    public void run() {
        while(true) {
            int idx = (int)(Math.random()*table.dishNum());
            table.add(table.dishNames[idx]);
            try {Thread.sleep(100); } catch(InterruptedException e) { }
        }
    }
}

class Table {
    private ReentrantLock lock = new ReentrantLock();   // lock을 생성

    private Condition forCook = lock.newCondition();    // lock으로 condition을 생성
    private Condition forCust1 = lock.newCondition();
    private Condition forCust2 = lock.newCondition();

    String[] dishNames = {"donut", "dount", "burger"};
    final int MAX_FOOD = 6;
    private ArrayList<String> dishes = new ArrayList();

    public void add(String dish) {
        lock.lock();    // lock을 건다.

        try {
            while (dishes.size() >= MAX_FOOD) {
                String name = Thread.currentThread().getName();
                System.out.println(name + " is a waiting. ");
                try {
                    forCook.await();    // Cook쓰레드를 기다리게 한다.
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                }
            }
            dishes.add(dish);
            forCust2.signal();   // 기다리고 있는 CUST를 깨우기 위함
            System.out.println("Dishes: " + dishes.toString());
        } finally {     // try 블럭 내에 어떤 일이 발생해도 finally블럭에 있는 unlock()이 수행되어 lock이 풀리지 않는 일은 발생하지 않음.
            lock.unlock();  // lock을 해제한다.
        }
    }


    public void remove(String dishName) {
        lock.lock();
        String name = Thread.currentThread().getName();
        try {
            while (dishes.size() == 0) {
                System.out.println(name + " is waiting");
                try {
                    forCust2.await();     // CUST1 쓰레드를 기다리게 한다.
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                }
            }

            while(true) {
                for (int i = 0; i < dishes.size(); i++) {
                if (dishName.equals(dishes.get(i))) {
                    dishes.remove(i);
                    forCook.signal();  // 잠자고 있는 COOK을 깨우기 위함.
                    return;
                }
            }
                try {
                    System.out.println(name + " is a waiting. ");
                    forCust2.await();   // 원하는 음식이 없는 CUST쓰레드를 기다리게 한다.
                    Thread.sleep(500);
                } catch (InterruptedException e) { }
            }
        } finally {
            lock.unlock();
        }
    }
    public int dishNum() { return dishNames.length; }
}