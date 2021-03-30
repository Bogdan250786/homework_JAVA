package com.paramud.homeworkThreads;

import java.util.concurrent.*;

public class Producer implements Runnable {
    
    Thread p;
    Semaphore sem;
    private final static String messageOnePut = "Producer bring product, product is in the shop - ";
    private final static String messageManyPut = "Producer bring product, products are in the shop - ";
    
    Producer(Semaphore s) {
        this.sem = s;
        p = new Thread (this);
        try {
            p.start();
            p.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void run() {
        try {
            sem.acquire();
            for (int i = 0; i < 10; i++) {
                Shop.product++;
                System.out.println((Shop.product > 1) ? messageManyPut +
                        Shop.product : messageOnePut + Shop.product);

            }                Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            sem.release();

        }
    }
}

