package com.quiz;

import java.util.Iterator;

/**
 * Design an int type singly linkedlist class, and then implement some functions below using the self designed class.
 * Can not use Java built in List interface
 * 1. Append an element into the linkedlist
 * 2. Remove the tail element from a linkedlist
 * 3. Remove all element in the linkedlist that is great than a target value
 **/
public class CustomSinglyLinkedList {

    private Node head;
    private Node tail;
    private int size;

    public CustomSinglyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    private void insert(int data, int index) {
        if (index > size) {
            throw new IllegalArgumentException("The index [" + index
                    + "] is greater than the currentent size [" + size + "].");
        } else {
            Node temp = new Node(data);
            Node current = getNode(index);
            if (index == 0) {
                temp.setNext(head);
                head = temp;
                tail = head;
            } else {
                temp.setNext(current.getNext());
                current.setNext(temp);
            }
            if (index == size - 1) {
                tail.setNext(temp);
                tail = temp;
            }
        }
        size++;
    }

    public void append(int data) {
        insert(data, size);
    }

    public void removeTailElement() {
        if (head == null) {
            return;
        }
        if (head.getNext() == null) {
            head = null;
            return;
        }
        Node current = head;
        while (current.getNext().getNext() != null) {
            current = current.getNext().getNext();
        }
        current.setNext(null);
        this.size--;
    }

    private Node getNode(int index) {
        if (index > size) {
            throw new IllegalArgumentException("The index [" + index + "] is greater than the current size [" + size + "].");
        }
        Node current = head;
        for (int i = 1; i < index; i++) {
            current = current.getNext();
        }
        return current;
    }

    public void removeAllElementsGreaterThanTargetValue(int data){
        Node currNode = head;
        while (currNode.getNext() != null) {
            if (currNode.getNext().getData() > data) {
                currNode.next = currNode.getNext().getNext();
                this.size--;
            } else {
                currNode = currNode.getNext();
            }
        }
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();

        Node current = head;
        while (current != null) {
            builder.append("[" + current.getData() + "]");
            current = current.getNext();
        }

        return builder.toString();

    }


    private class Node {

        Node next;
        int data;

        public Node(int data) {
            this(data, null);
        }

        public Node(int data, Node next) {
            this.next = next;
            this.data = data;
        }

        public int getData() {
            return this.data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public Node getNext() {
            return this.next;
        }

        public void setNext(Node nextNode) {
            this.next = nextNode;
        }

    }
}
