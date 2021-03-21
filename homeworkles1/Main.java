package com.paramud.homeworkles1;

public class Main {


    public static void main(String[] args) {
        PrimeNumb prime = new PrimeNumb();
        prime.primeCount(2,100);
        BubbleArr bubleAlg = new BubbleArr();
        System.out.println("________________________________________________________________________________________");
        bubleAlg.createDefArr(100);
        bubleAlg.sortedArr();
        System.out.println("________________________________________________________________________________________");
    Box box = new Box(2000);
        box.add(new Shape("Triangle", 2, 40));
        box.add(new Shape("Triangle", 20, 40));
        box.add(new Shape("Square", 3, 20));
        box.add(new Shape("Liquid", 20, 4));
        box.add(new Shape("Circle", 2, 4));
        box.add(new Shape("Triangle", 20, 40));
        box.add(new Shape("Triangle", 20, 40));

    }
}
