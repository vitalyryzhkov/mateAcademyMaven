package com.homework.lesson09;

import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.assertEquals;

public class MyArrayListTest {
    private MyArrayList<Integer> myArrayList;

    @Before
    public void setUp() {
        myArrayList = new MyArrayList<>();
        myArrayList.add(1);
    }

    @Test
    public void get() {
        int expected = myArrayList.get(0);
        int actual = 1;
        assertEquals(expected, actual);
    }

    @Test
    public void add() {
        myArrayList.add(2);
        int expected = myArrayList.get(1);
        int actual = 2;
        assertEquals(expected, actual);
    }

    @Test
    public void remove() {
        myArrayList.add(2);
        myArrayList.add(3);
        myArrayList.remove(1);
        int expected = myArrayList.get(1);
        int actual = 3;
        assertEquals(expected, actual);

    }

    @Test
    public void size() {
        int expected = myArrayList.size();
        int actual = 1;
        assertEquals(expected, actual);

    }

    @Test
    public void clear() {
        myArrayList.clear();
        int expected = myArrayList.size();
        int actual = 0;
        assertEquals(expected, actual);
    }
}
