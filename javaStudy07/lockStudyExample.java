package javaStudy07;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;


public class lockStudyExample {

  public static void main(String[] args) throws Exception {
    Ssg ssg = new Ssg();  //  여러 쓰레드가 공유하는 객체

    Thread cust1 = new Thread(new Buyer(ssg, "milk"), "BUYER1");
    cust1.setPriority(10);
    cust1.start();

    new Thread(new Buyer(ssg, "snack"), "BUYER2").start();
    new Thread(new Seller(ssg), "SELLER").start();

    Thread.sleep(3000);
    System.exit(0);
  }
}

class Buyer implements Runnable {

  private Ssg ssg;
  private String item;

  Buyer(Ssg ssg, String item) {
    this.ssg = ssg;
    this.item = item;
  }

  public void run() {
    while (true) {
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
      }
      String name = Thread.currentThread().getName();

      ssg.remove(item);
      System.out.println(name + " bought a " + item);
    }
  }
}

class Seller implements Runnable {

  private Ssg ssg;

  Seller(Ssg ssg) {
    this.ssg = ssg;
  }

  public void run() {
    while (true) {
      int idx = (int) (Math.random() * ssg.itemNum());
      ssg.add(ssg.itemNames[idx]);
      try {
        Thread.sleep(100);
      } catch (InterruptedException e) {
      }
    }
  }
}

class Ssg {

  private ReentrantLock lock = new ReentrantLock();   // lock을 생성

  private Condition forSeller = lock.newCondition();    // lock으로 condition을 생성
  private Condition forBuyer1 = lock.newCondition();
  private Condition forBuyer2 = lock.newCondition();

  String[] itemNames = {"milk", "banana", "milk", "snack"};
  final int MAX_ITEM = 6;
  private LinkedList<String> items = new LinkedList<>();

  public void add(String dish) {
    lock.lock();    // lock을 건다.

    try {
      while (items.size() >= MAX_ITEM) {
        String name = Thread.currentThread().getName();
        System.out.println(name + " is a waiting. ");
        try {
          forSeller.await();    // Seller쓰레드를 기다리게 한다.
          Thread.sleep(500);
        } catch (InterruptedException e) {
        }
      }
      items.add(dish);
      forBuyer2.signal();   // 기다리고 있는 Buyer를 깨우기 위함
      System.out.println("items: " + items.toString());
    } finally {     // try 블럭 내에 어떤 일이 발생해도 finally블럭에 있는 unlock()이 수행되어 lock이 풀리지 않는 일은 발생하지 않음.
      lock.unlock();  // lock을 해제한다.
    }
  }


  public void remove(String dishName) {
    lock.lock();
    String name = Thread.currentThread().getName();

    try {
      while (items.size() == 0) {
        System.out.println(name + " is waiting");
        try {
          forBuyer1.await();     // Buyer1 쓰레드를 기다리게 한다.
          Thread.sleep(500);
        } catch (InterruptedException e) {
        }
      }

      while (true) {
        for (int i = 0; i < items.size(); i++) {
          if (dishName.equals(items.get(i))) {
            items.remove(i);
            forSeller.signal();  // 잠자고 있는 COOK을 깨우기 위함.
            return;
          }
        }
        try {
          System.out.println(name + " is a waiting. ");
          forBuyer2.await();   // 원하는 음식이 없는 CUST쓰레드를 기다리게 한다.
          Thread.sleep(500);
        } catch (InterruptedException e) {
        }
      }
    } finally {
      lock.unlock();
    }
  }

  public int itemNum() {
    return itemNames.length;
  }
}