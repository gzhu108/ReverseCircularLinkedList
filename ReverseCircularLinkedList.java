package com.interview.reversecircularlinkedlist;

import java.util.Stack;


class Node {
    public int data;
    public Node next;
}

class CircularLinkedList {
    private Node head;
    private Node tail;

    public CircularLinkedList buildWith(int[] data) {
        if (data.length == 0) {
            head = null;
            tail = null;
            return this;
        }

        head = null;
        Node node = null;

        for (int d : data) {
            tail = new Node();
            tail.data = d;

            if (head == null) {
                head = tail;
            }

            if (node != null) {
                node.next = tail;
            }

            tail.next = head;
            node = tail;
        }

        return this;
    }

    public void print() {
        System.out.println("Circular Linked List:");
        Node node = head;
        
        do {
            if (node != null) {
                System.out.println(node.data);
                node = node.next;
            }
        } while (node != head);
    }

    public void reverse() {
        if (head == null) {
            return;
        }

        Node previous = head;
        Node node = previous.next;
        Node next = null;

        do {
            next = node.next;
            node.next = previous;
            previous = node;
            node = next;
        } while (node != head);

        node.next = tail;
        head = tail;
        tail = node;
    }

    public void reverseStack() {
        if (head == null) {
            return;
        }

        Stack<Node> stack = new Stack<Node>();
        Node node = head;
        do {
            stack.push(node);
            node = node.next;
        } while (node != head);

        head = stack.pop();
        node = head;
        Node next = null;
        while (!stack.empty()) {
            next = stack.pop();
            node.next = next;
            node = next;
        }

        node.next = head;
        tail = node;
    }

    public static void bar(CircularLinkedList list) {
        list = null;
    }

    public static void main(String[] argv) {
        int[] data = new int[]{ 1, 2, 3, 4 };
        CircularLinkedList list = new CircularLinkedList().buildWith(data);

        list.print();
        list.reverse();
        list.print();
        list.reverseStack();
        list.print();

        bar(list);
        list.print();
    }
}
