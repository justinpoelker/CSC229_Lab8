/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab08;

/**
 *
 * @author jpzuc
 */
class SinglyLinkedList<E> implements Iterable<E> {
    
    //Create variables with temp values
    private Node<E> head;
    private Node<E> tail;
    private int size;

    //Make the first list 
    public void addLast(E e) {
        Node<E> newNode = new Node<>(e);
        //Loop through the list to determine size
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    @Override
    //Generate the string with the value taken from the list
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node<E> current = head;
        while (current != null) {
            sb.append(current.element);
            current = current.next;
            if (current != null) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    @Override
    //Return value given
    public java.util.Iterator<E> iterator() {
        return new SinglyLinkedListIterator();
    }

    private static class Node<E> {

        E element;
        Node<E> next;

        public Node(E element) {
            this.element = element;
            this.next = null;
        }
    }

    //Create list algorithm class
    private class SinglyLinkedListIterator implements java.util.Iterator<E> {

        private Node<E> current;

        public SinglyLinkedListIterator() {
            current = head;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            E element = current.element;
            current = current.next;
            return element;
        }
    }
}
