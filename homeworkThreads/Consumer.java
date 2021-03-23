package com.paramud.homeworkThreads;

import java.util.concurrent.*;

public class Consumer implements Runnable {
    
    Thread c;
    Semaphore sem;
    private final static String messageOneGet = "Customer bought product, product is in the shop - ";
    private final static String messageManyGet = "Customer bought product, products are in the shop - ";
    
    Consumer(Semaphore s) {
        this.sem = s;
        c = new Thread (this);
        try {
            c.start();
            c.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void run() {
        try {
            sem.acquire();
            for (int i = 0; i < 10; i++) {
                Shop.product--;
                System.out.println((Shop.product > 1) ? messageManyGet +
                        Shop.product : messageOneGet + Shop.product);
            
            }    Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            sem.release();
        }
    }
}

