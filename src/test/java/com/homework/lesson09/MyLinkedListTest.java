package com.homework.lesson09;

import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.assertEquals;

public class MyLinkedListTest {
    private MyLinkedList<Integer> myLinkedList;

    @Before
    public void setUp() {
        myLinkedList = new MyLinkedList<>();
        myLinkedList.add(1);
    }

    @Test
    public void get() {
        int expected = myLinkedList.get(0);
        int actual = 1;
        assertEquals(expected, actual);
    }

    @Test
    public void add() {
        myLinkedList.add(2);
        int expected = myLinkedList.get(1);
        int actual = 2;
        assertEquals(expected, actual);
    }

    @Test
    public void remove() {
        myLinkedList.add(2);
        myLinkedList.add(3);
        myLinkedList.remove(1);
        int expected = myLinkedList.get(1);
        int actual = 3;
        assertEquals(expected, actual);

    }

    @Test
    public void size() {
        int expected = myLinkedList.size();
        int actual = 1;
        assertEquals(expected, actual);

    }

    @Test
    public void clear() {
        myLinkedList.clear();
        int expected = myLinkedList.size();
        int actual = 0;
        assertEquals(expected, actual);
    }
}
