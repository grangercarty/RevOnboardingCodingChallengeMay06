package com.github.grangercarty.revonboardingcodingchallengemay06;

import java.util.ArrayList;

public class CartyLinkedList {
    public CartyNode head;
    public CartyNode tail;
    public boolean empty;

    public CartyLinkedList() {
        this.empty = true;
    }

    public void addFirst(int i) {
        if (empty) {
            head = new CartyNode(i);
            tail = head;
            empty = false;
        }
        else {
            CartyNode newNode = new CartyNode(i);
            newNode.setNext(head);
            head = newNode;
        }
    }

    public void addLast(int i) {
        if (empty) {
            head = new CartyNode(i);
            tail = head;
            empty = false;
        }
        else {
            CartyNode newNode = new CartyNode(i);
            tail.setNext(newNode);
            tail = tail.getNext();
        }
    }

    public boolean intersects(CartyLinkedList testList) {
        boolean intersectFound = false;
        CartyNode current = head;
        CartyNode testNode = testList.head;
        while (!intersectFound && current.hasNext) {
            testNode = testList.head;
            while (testNode.hasNext) {
                intersectFound = (intersectFound || (testNode == current));
                testNode = testNode.getNext();
            }
            current = current.getNext();
        }
        intersectFound = (intersectFound || (testNode == current));
        return intersectFound;
    }

    public boolean loopDetector() {
        boolean loopFound = false;
        ArrayList<CartyNode> nodeList = new ArrayList<>();
        CartyNode current = head;
        while (current.hasNext && !loopFound) {
            loopFound = (nodeList.contains(current));
            nodeList.add(current);
            current = current.getNext();
        }
        return loopFound;
    }
}
