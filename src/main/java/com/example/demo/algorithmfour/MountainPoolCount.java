package com.example.demo.algorithmfour;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class MountainPoolCount {
  public static void main(String[] args) throws IOException {
    BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    Deque<Integer> oneQue = new ArrayDeque<>();
    Deque<int[]> twoQue = new ArrayDeque<>();
    char[] list = buffer.readLine().toCharArray();
    int sum = 0;

    for(int i = 0; i < list.length; i++){
      if(list[i] == '\\'){
        oneQue.push(i);
      }else if(list[i] == '/'){
        if(!oneQue.isEmpty()){
          int j = oneQue.pop();
          int area = i - j;
          sum += area;
          while (!twoQue.isEmpty()&&twoQue.peek()[0]>j){
            area += twoQue.pop()[1];
          }
          int [] value = {j,area};
          twoQue.push(value);
        }
      }
    }
    System.out.println(sum);
    System.out.println(twoQue.size());
    while(!twoQue.isEmpty()){
      System.out.println("  "+ twoQue.pollLast()[1]);
    }
    System.out.println();

  }
}