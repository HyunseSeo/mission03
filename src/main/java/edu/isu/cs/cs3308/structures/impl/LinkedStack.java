package edu.isu.cs.cs3308.structures.impl;

import edu.isu.cs.cs3308.structures.Stack;

/*Hyunse Seo
 01/27/2019
/*Create LinkedStack Class with extend DoublyLinkedList class and implementing Stack Class.*/
public class LinkedStack<E> extends DoublyLinkedList<E> implements Stack<E> {


  private DoublyLinkedList<E> DLLStack = new DoublyLinkedList<E>();

  public LinkedStack(){

  };

  @Override
  /*override push method to store the node with element parameter.*/
  public void push(E element) {

    addLast(element);
  }

  @Override
  /*override peek() method to return the data of the top in the stack.*/
  public E peek() {

    return last();
  }

  @Override
  /*override pop method to get ride of top node from the stack. */
  public E pop() {
    return removeLast();
  }

  @Override
  /*override size() method to return this stack's size*/
  public int size() {
    return size;
  }

  @Override
  /* override isEmpty method to check whether this stack is empty or not.*/
  public boolean isEmpty() {
    if(size()==0)
      return true;
    else{
      return false;
    }
  }

  @Override
  /*override transfer method to transfer from this stack's content to another stack where is parameter.*/
  public void transfer(Stack to) {
    if(to == null){
      return;
    }
    int length = size();
    for(int i=0; i<length; i++) {
      E element = peek();
      to.push(element);

      pop();
    }
    isEmpty();

  }

  @Override
  /*override reverse() class to reverse this stack's order.*/
  public void reverse() {
    for(int i=0; i<size(); i++) {
      E element = peek();
      pop();

      insert(element,i);

    }
  }

  @Override
  /*override merge method to merge stack with another stack where comes as parameter, but after merge that parameter stack
   * should be remain still.*/
  public void merge(Stack other) {
    if(other == null){
      return;
    }

    int size = other.size();
    for(int i = 0; i <size; i++){
      E element = ((DoublyLinkedList<E>)other).get(i);
      push(element);
    }
  }

  @Override
  /*override printStack method to print out this stack.*/
  public void printStack() {
    for(int i=size()-1 ; i>=0; i--)

      System.out.println(get(i));



  }
}
