package com.paramud.homeworkLinkedList;
import java.util.*;
import com.paramud.homeworkLinkedList.MyLinkedList;

public class Main {


    public static void main(String[] args) {
        List<String> aaa = new LinkedList<>();

        MyLinkedList<String> myList = new MyLinkedList();
        MyLinkedList<Integer> myList1 = new MyLinkedList();
        myList.add("1");
        myList.add("2");
        myList.add("3");
        myList.add("4");
        try{
            myList1.add(0,10);
            System.out.println(myList1);
        }
        catch(MyIndexException ex){
            System.out.println(ex.getMessage());
        }
        System.out.println("_________________________________________________________________________");
        System.out.println(myList);
        System.out.println(myList.contains("2"));
        try {
            System.out.println(myList.get(1));
        } catch (MyIndexException ex){
            System.out.println(ex.getMessage());
        }
        System.out.println(myList.remove("10"));
        System.out.println(myList);


    }
}
