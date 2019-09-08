package com.prashanth.os.thread.lock;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo {

  private static ReentrantLock reentrantLock = new ReentrantLock(true);

  public static void main(String[] args) {
    new Thread(() -> lockTest()).start();
    new Thread(() -> lockTest()).start();
  }

  private static void lockTest() {
    reentrantLock.lock();
    try {
      System.out.println("locked");
      Thread.sleep(3000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    } finally {
      reentrantLock.unlock();
      System.out.println("unlocked");
    }
  }
}

