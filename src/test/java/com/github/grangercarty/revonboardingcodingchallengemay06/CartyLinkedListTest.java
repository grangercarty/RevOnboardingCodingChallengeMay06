package com.github.grangercarty.revonboardingcodingchallengemay06;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CartyLinkedListTest {

    @Test
    public void ConstructorTest() {
        CartyLinkedList list = new CartyLinkedList();
        list.addFirst(1);
        list.addLast(2);
        CartyNode current = list.head;
        current = current.getNext();
        Assertions.assertEquals(2, current.getValue());
    }

    @Test
    public void intersectionTest() {
        CartyLinkedList list1 = new CartyLinkedList();
        CartyLinkedList list2 = new CartyLinkedList();
        CartyLinkedList list3 = new CartyLinkedList();

        list1.addFirst(1);
        list1.addLast(2);
        list1.addLast(3);
        list1.addFirst(0);

        list2.addFirst(4);
        list2.addLast(5);

        list3.addFirst(6);
        list3.addLast(7);

        CartyNode node = list1.head.getNext().getNext();
        list3.tail.setNext(node);

        Assertions.assertTrue(list1.intersects(list3));
        Assertions.assertTrue(list3.intersects(list1));
        Assertions.assertEquals(node, list1.intersectFinder(list3));

        Assertions.assertFalse(list1.intersects(list2));
        Assertions.assertFalse(list3.intersects(list2));
        Assertions.assertFalse(list2.intersects(list1));
        Assertions.assertFalse(list2.intersects(list3));
        Assertions.assertNull(list1.intersectFinder(list2));
    }

    @Test
    public void loopTest() {
        CartyLinkedList list1 = new CartyLinkedList();
        list1.addFirst(1);
        list1.addLast(2);
        list1.addLast(3);
        list1.addFirst(0);
        CartyNode current = list1.head.getNext();
        list1.tail.setNext(current);

        CartyLinkedList list2 = new CartyLinkedList();
        list2.addFirst(4);
        list2.addLast(5);

        Assertions.assertTrue(list1.loopDetector());
        Assertions.assertFalse(list2.loopDetector());

        Assertions.assertEquals(current, list1.loopFinder());
        Assertions.assertNull(list2.loopFinder());
    }
}
