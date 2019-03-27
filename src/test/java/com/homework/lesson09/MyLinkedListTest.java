package com.homework.lesson09;

import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.assertEquals;

public class MyLinkedListTest {
    private List<Integer> myLinkedList;

    @Before
    public void setUp() {
        myLinkedList = new MyLinkedList<>();
        myLinkedList.add(1);
    }

    @Test
    public void get() {
        int actual = myLinkedList.get(0);
        int expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    public void add() {
        myLinkedList.add(2);
        int actual = myLinkedList.get(1);
        int expected = 2;
        assertEquals(expected, actual);
    }

    @Test
    public void remove() {
        myLinkedList.add(2);
        myLinkedList.add(3);
        myLinkedList.remove(1);
        int expected = 3;
        int actual = myLinkedList.get(1);
        assertEquals(expected, actual);
    }

    @Test
    public void size() {
        int actual = myLinkedList.size();
        int expected = 1;
        assertEquals(expected, actual);

    }

    @Test
    public void clear() {
        myLinkedList.clear();
        int actual = myLinkedList.size();
        int expected = 0;
        assertEquals(expected, actual);
    }
}
