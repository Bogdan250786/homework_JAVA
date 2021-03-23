package com.paramud.homeworkThreads;
import java.util.concurrent.*;
public class Main {
    
    public static void main(String[] args) {
    

        Semaphore sem = new Semaphore(1);
        int counter = 0;
        while (counter < 10) {
            try {
                new Producer(sem);
                new Consumer(sem);
                counter++;
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
