package edu.isu.cs.cs3308.structures.impl;

/*Hyunse Seo
 * 01/27/2019*/
/*create DoublyNode Class for applying Construct DoublyLinkedlist.*/
public class Node<E> {
  private E element;
  private Node<E> prev;
  private Node<E> next;

  public Node(E e, Node<E>p, Node<E> n){
    element = e;
    prev = p;
    next = n;
  }

  public Node(E element, Node<E> next)
  {
    this.element = element;
    this.next = next;
  }

  public E getElement(){return element;}
  public Node<E> getPrev(){return prev;}
  public Node<E> getNext(){return next;}
  public void setPrev(Node<E> p){prev = p;}
  public void setNext(Node<E> n){next = n;}

}
