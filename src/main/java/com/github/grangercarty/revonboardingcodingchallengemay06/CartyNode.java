package com.github.grangercarty.revonboardingcodingchallengemay06;

public class CartyNode {
    private int value;
    public CartyNode next;
    boolean hasNext;

    public CartyNode(int i) {
        this.setValue(i);
        hasNext = false;
    }

    public void setNext(CartyNode nextNode) {
        this.next = nextNode;
        hasNext = true;
    }

    public CartyNode getNext() {
        return next;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
