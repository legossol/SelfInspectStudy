package com.example.demo.algorithmfour;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import lombok.extern.slf4j.Slf4j;

/*2진 탐색을 활용하여
1부터 n 까지의 중복되지 않은 숫자가 무작위로 있는 배열에서 숫자
x (1~n 사이의값)의 위치를 찾는 메소드를 작성하시오.
* */
@Slf4j
class Logic{
  Random random = new Random();

  int ARRAY_RANDOM_LENGTH;

  int[] randArr;

  public void makeRandomArraySet(int MAX_NUM){
    Random random = new Random();
    //임의의 배열 길이
    ARRAY_RANDOM_LENGTH = random.nextInt(MAX_NUM)+1;
    //임의의 길이 배열 생성
    randArr = new int[ARRAY_RANDOM_LENGTH];

    //배열에 임의의 값들 중복 거르고 넣기
    for (int i = 0;i < ARRAY_RANDOM_LENGTH;){
      int willPutNum = random.nextInt(MAX_NUM)+1;
      if(i == 0 ){
        randArr[i] = willPutNum;
        i++;
      }else {
        Set<Integer> arraySet = new HashSet<>();
        for (int temp : randArr) {
          if(temp != 0) {
            arraySet.add(temp);
            arraySet.add(willPutNum);
          }
          if (arraySet.size() == i + 1) {
            randArr[i] = willPutNum;
            i++;
          }
        }
      }
    }
    //배열 확인
    log.info("임의의 배열 길이 = {}",randArr.length);
    for(int j : randArr) {
      Set<Integer> showArrSet = new HashSet<>();
      showArrSet.add(j);
      System.out.print(showArrSet);
    }
    System.out.println();
  }

  //소주병의 숫자 맞추기 게임과 같은 원리(헌데 꼭 있다...중간값 말안하는 사람)
  public int searchStart(int keyNum){
    int FAIL = -1;
    //탐색을 위한 배열 정렬
    Arrays.sort(randArr);
    int middle;
    int low = 0;
    int hight = ARRAY_RANDOM_LENGTH-1;
    while(low <= hight){
      middle = (low + hight)/2;
      if(keyNum == randArr[middle]){
        log.info("찾으시는 임의의 값 {} 는 배열의[{}]위치에 있습니다",keyNum,middle);
        return middle;
      }else if(keyNum<randArr[middle]){
        hight = middle-1;
      }else {
        low = middle + 1;
      }
    }
    log.info("원하는 임의의 {} 는 배열에 존재하지 않습니다",keyNum);
    return FAIL;
  }
}
public class BinarySearch {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    Random random = new Random();
    int randNumN = scan.nextInt();
    int randNumX = random.nextInt(randNumN)+1;

    Logic logic = new Logic();
    logic.makeRandomArraySet(randNumN);
    logic.searchStart(randNumX);

  }
}
