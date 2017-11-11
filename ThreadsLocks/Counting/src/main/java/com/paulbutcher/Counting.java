/***
 * Excerpted from "Seven Concurrency Models in Seven Weeks",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/pb7con for more book information.
***/
package com.paulbutcher;

public class Counting {
  public static void main(String[] args) throws InterruptedException {
    class Counter {
      private int count = 0;
      public synchronized void increment() { ++count; }
      public int getCount() { return count; }
    }
    final Counter counter = new Counter();
    class CountingThread extends Thread {
      public void run() {
        for(int x = 0; x < 10000; ++x)
          counter.increment();
      }
    }

    CountingThread t1 = new CountingThread();
    CountingThread t2 = new CountingThread();
    CountingThread t3 = new CountingThread();
    CountingThread t4 = new CountingThread();
    CountingThread t5 = new CountingThread();
    CountingThread t6 = new CountingThread();
    
    t1.start(); t2.start(); t3.start(); t4.start(); t5.start(); t6.start();
    t1.join(); t2.join(); t3.join(); t4.join(); t5.join(); t6.join();
    System.out.println(counter.getCount());
  }
}
