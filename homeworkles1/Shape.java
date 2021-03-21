package com.paramud.homeworkles1;

public class Shape {
  String name;
  int height;
  int weight;

  Shape(String name, int h, int w){
    this.name = name;
    this.height = h;
    this.weight = w;
  }
 public int calcCap(){
    return height * weight;
 }
}
