package edu.isu.cs.cs3308.structures.impl;

import edu.isu.cs.cs3308.structures.List;

public class DoublyLinkedList<E> implements List<E> {
  /**
   *  Hyunse Seo
   *  01/27/2019
   *  create DoublyLinkedList.
   */
    protected Node<E> header;
    protected Node<E> trailer;
    protected int size = 0;

    public DoublyLinkedList() {
      header = new Node<>(null, null, null);
      trailer = new Node<>(null,header,null);
      header.setNext(trailer);
    }

    @Override
    /*
     * return first Element except if it is not empty.*/
    public E first() {
      if(isEmpty()){
        return null;
      }

      return header.getNext().getElement();
    }

    /*
     * return last element except if it is not empty*/
    @Override
    public E last() {
      if(isEmpty()){
        return null;
      }
      return trailer.getPrev().getElement();
    }

    @Override
    /*
     * override a addLast method with element parameter to put this node at the end of the list.*/
    public void addLast(E element) {
      if(element == null) {
        return;
      }
      Node<E> newnode = new Node<>(element, null,null);
      newnode.setPrev(trailer.getPrev());
      newnode.setNext(trailer);
      trailer.getPrev().setNext(newnode);
      trailer.setPrev(newnode);
      size++;

    }




    @Override
    /*override addFirst method with Element parameter to put this nodd at the top of the list. a */
    public void addFirst(E element) {
      if(element == null){
        return;
      }
      Node<E> newnode = new Node<>(element, null,null);
      newnode.setPrev(header);
      newnode.setNext(header.getNext());
      header.setNext(newnode);
      newnode.getNext().setPrev(newnode);
      size++;
    }

    @Override
    /*override removeFirst method to get rid of first node of the list. a */
    public E removeFirst() {
      if(isEmpty()){
        return null;
      }

      Node<E> temp = header.getNext();
      header.setNext(temp.getNext());
      temp.getNext().setPrev(header);
      temp.setNext(null);
      temp.setPrev(null);
      size--;

      return temp.getElement();
    }

    @Override
    /*override removeLast method to get rid of first node of the list. a */
    public E removeLast() {
      if(isEmpty()){
        return null;
      }
      Node<E> temp = trailer.getPrev();
      trailer.setPrev(temp.getPrev());
      temp.getPrev().setNext(trailer);
      temp.setPrev(null);
      temp.setNext(null);
      size--;
      return temp.getElement();
    }

    @Override
    /*override insert method with element and index, it will track the node following index, and create a node with this
     * element as parameter, then connecting with this list. */
    public void insert(E element, int index) {
      if(element == null || index < 0 ){
        return;
      }
      else {
        if (index == 0) {
          addFirst(element);
          return;
        } else if (index >= size()) {
          addLast(element);
          return;
        }
        Node<E> firstNode = header.getNext();
        for(int i =0; i<index-1; i++){
          firstNode = firstNode.getNext();
        }
        Node<E> newNode = new Node<>(element,null,null);
        newNode.setNext(firstNode.getNext());
        newNode.setPrev(firstNode);
        firstNode.getNext().setPrev(newNode);
        firstNode.setNext(newNode);

        size++;

      }


    }



    @Override
    /*override remove method to find node where we want to get rid of this list using index parameter.*/
    public E remove(int index) {
      if(index < 0 || index >= size()){
        return null;
      }
      else{
        Node<E> temp = header.getNext();
        for(int i = 0; i<index; i++){
          temp = temp.getNext();
        }
        temp.setPrev(null);
        temp.setNext(null);

        size--;
        return temp.getElement();

      }


    }

    @Override
    /*override get method to return element of node in the list following by index parameter.*/
    public E get(int index) {
      if (index >= size() || index < 0 ) {
        return null;
      }
      if(index == 0){
        return header.getNext().getElement();
      }
      Node<E> temp = header.getNext();
      for(int i = 0; i<index; i++){
        temp = temp.getNext();
      }
      return temp.getElement();
    }

    @Override
    /*override size() method to return this list's size.*/
    public int size() {
      return this.size;
    }

    @Override
    /*override isEmpty method to check this list is empty.*/
    public boolean isEmpty() {

      return size()==0;
    }


    @Override
    /*override printList() method to print out this list.*/
    public void printList() {
      for(int i=0 ; i<size; i++)

        System.out.println(get(i));

    }
  }


