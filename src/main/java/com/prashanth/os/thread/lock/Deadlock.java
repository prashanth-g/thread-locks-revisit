package com.prashanth.os.thread.lock;

public class Deadlock {

  private static Object objectWrite = new Object();
  private static Object objectRead = new Object();

  public static void main(String[] args) {
    new Thread(() -> new Deadlock().holdA()).start();
    new Thread(() -> new Deadlock().holdB()).start();
  }

  public void holdA() {
    synchronized (objectWrite) {
      System.out.println("Thread " + Thread.currentThread().getName() +" holding objectWrite");
      try {
        Thread.sleep(10);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      System.out.println("Thread " + Thread.currentThread().getName() +" waiting to get objectRead");
      // Deadlock
      synchronized (objectRead) {
        // Never reach here
      }
    }
  }


  public void holdB() {
    synchronized (objectRead) {
      System.out.println("Thread " + Thread.currentThread().getName() +" holding objectRead");
      try {
        Thread.sleep(10);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      System.out.println("Thread " + Thread.currentThread().getName() +" waiting to get objectWrite");
      // Deadlock
      synchronized (objectWrite) {
        // Never reach here
      }
    }
  }
}
