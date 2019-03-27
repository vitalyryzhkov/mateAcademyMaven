package com.homework.lesson09;

import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.assertEquals;

public class MyArrayListTest {
    private List<Integer> myArrayList;

    @Before
    public void setUp() {
        myArrayList = new MyArrayList<>();
        myArrayList.add(1);
    }

    @Test
    public void get() {
        int expected = 1;
        int actual = myArrayList.get(0);
        assertEquals(expected, actual);
    }

    @Test
    public void add() {
        myArrayList.add(2);
        int expected = 2;
        int actual = myArrayList.get(1);
        assertEquals(expected, actual);
    }

    @Test
    public void remove() {
        myArrayList.add(2);
        myArrayList.add(3);
        myArrayList.remove(1);
        int expected = 3;
        int actual = myArrayList.get(1);
        assertEquals(expected, actual);

    }

    @Test
    public void size() {
        int expected = 1;
        int actual = myArrayList.size();
        assertEquals(expected, actual);

    }

    @Test
    public void clear() {
        myArrayList.clear();
        int expected = 0;
        int actual = myArrayList.size();
        assertEquals(expected, actual);
    }
}
