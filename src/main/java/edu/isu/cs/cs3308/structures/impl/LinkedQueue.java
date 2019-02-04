package edu.isu.cs.cs3308.structures.impl;

import edu.isu.cs.cs3308.structures.Queue;
import edu.isu.cs.cs3308.structures.impl.Node;

public class LinkedQueue<E> extends DoublyLinkedList<E> implements Queue<E> {



  public LinkedQueue(){

  }


  @Override
  public int size() {
    return size;
  }

  @Override
  public boolean isEmpty() {
    return size==0;
  }

  @Override
  public void offer(E element) {
    addFirst(element);

  }

  @Override
  public E peek() {
    return last();
  }

  @Override
  public E poll() {
    return removeLast();
  }

  @Override
  public void printQueue() {
    for(int i=size()-1 ; i>=0; i--)

      System.out.println(get(i));

  }

  @Override
  public void transfer(Queue<E> into) {
    if(into == null){
      return;
    }
    int length = size();
    this.reverse();
    for(int i=length-1; i>=0; i--) {

      E element = peek();
      poll();
      into.offer(element);
    }
    isEmpty();
  }

  @Override
  public void reverse() {
    for(int i=0; i<size(); i++) {
      E element = peek();
      poll();
      insert(element,i);
    }

  }

  @Override
  public void merge(Queue<E> from) {
    if(from == null){
      return;
    }

    int size = from.size();
    for(int i = 0; i <size; i++){
      E element = ((DoublyLinkedList<E>)from).get(i);
      addLast(element);
    }
  }

}
