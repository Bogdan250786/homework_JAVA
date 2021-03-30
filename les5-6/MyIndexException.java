package com.paramud.homeworkLinkedList;

public class MyIndexException extends Exception {
  private int number;
  public int getNumber() {
    return number;
  }
  public MyIndexException(String message, int index) {
    super(message);
    number = index;
  }
}
