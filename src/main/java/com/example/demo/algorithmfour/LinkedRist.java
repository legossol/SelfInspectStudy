package com.example.demo.algorithmfour;

import java.util.NoSuchElementException;

/*
* insert x : 연결리스트의 가장 앞에 키 x를 가진 요소를 추가
* delete x : 키 x를 가진 첫번째 요소를 연결 리스트에서 제거
* deleteFirst : 연결 리스트의 가장 앞 요소를 제거
* deleteLast : 연결 리스트의 가장 뒤 요소를 제거
* */
class Node{
  Integer data;
  Node next;
  Node prev;

  Node(Integer data){
    this.data = data;
    this.prev = null;
    this.next = null;
  }
}
interface MyMethod{
  Object deleteFirst();
  Object deleteLast();
  void insert(int x);
  Object delete(int x);
  void print();
}
class LinkedList implements MyMethod{
  private Node head;
  private Node tail;
  private int size;

  public LinkedList() {
    size = 0;
  }

  @Override
  public Object deleteFirst() {
    if(size ==0){
      return null;
    }
    Node node = head;
    head = null;
    head = node.next;
    head.prev = null;
    size--;
    return node.data;
  }

  @Override
  public Object deleteLast() {
    if(size ==0)return null;
    Node node = tail;
    tail = null;
    tail = node.prev;
    tail.next = null;
    size--;
    return node.data;
  }

  @Override
  public void insert(int x) {
    Node node = new Node(x);

    if (head != null) {
      node.next = head;
      head.prev = node;
    }
    head = node;
    if (head.next == null) {
      tail = head;
    }
    size++;
  }

  @Override
  public Object delete(int x) {
    if(size ==0)return null;
    Node node = tail;
    while(node != null){
      if(node.data == x&& node.next == null){
        deleteLast();
        break;
      }
      if(node.data == x&& node.prev == null){
        deleteFirst();
        break;
      }
      if(node.data == x){
        Node prevNode = node.prev;
        Node nextNode = node.next;
        prevNode.next = null;
        nextNode.prev = null;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
        size--;
        return node.data;
      }
      node = node.prev;
    }
    return node.data;
  }

  @Override
  public void print() {

    for(; size !=0; size--){
      Node node = head;
      System.out.println(node.data);
      if(head.next == null){
        break;
      }
      head = null;
      head = node.next;
      head.prev = null;
    }
  }
}
class startNode{

  public static void main(String[] args) {
    LinkedList list = new LinkedList();
    list.insert(5);
    list.insert(2);
    list.insert(3);
    list.insert(1);
    list.delete(3);
    list.insert(6);
    list.delete(5);
    list.print();
  }
}
