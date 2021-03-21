package com.paramud.homeworkles1;

import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;

public class BubbleArr {
  int[] defaultArr;

  public int[] createDefArr(int n) {
    defaultArr = new int[n];
    for (int i = 0; i < defaultArr.length; i++) {
      defaultArr[i] = (int) (Math.random() * (i + 1) * 100);
    }
    System.out.println("default array" + "\n" + Arrays.toString(defaultArr));
    return defaultArr;
  }

  int[] sortedArr() {
    int temp = 0;
    boolean isSorted = false;
    while (!isSorted) {
      isSorted = true;
      for (int j = 0; j < defaultArr.length - 1; j++) {
        if (defaultArr[j] > defaultArr[j + 1]) {
          isSorted = false;
          temp = defaultArr[j];
          defaultArr[j] = defaultArr[j + 1];
          defaultArr[j + 1] = temp;
        }
      }
    }
    System.out.println("sorted array" + "\n" + Arrays.toString(defaultArr));
    return defaultArr;
  }
}
