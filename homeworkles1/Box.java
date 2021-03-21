package com.paramud.homeworkles1;

public class Box  {
  public  int capacity;
  public Box(int capacity) {
    this.capacity = capacity;
  }

  public boolean add(Shape shape) {
    if(shape.calcCap() > capacity){
      System.out.println(false + "  There is no place to add ");
      return false;
    }
    else {
      capacity = capacity - shape.calcCap();
      System.out.println("You can use " + capacity);
    return true;
    }
  }
}
