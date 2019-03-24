package com.homework.lesson09;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MyStackTest {
    MyStack<Integer> myStack;

    @Before
    public void setUp() {
        myStack = new MyStack<>(2);
    }

    @Test
    public void push() {
        myStack.push(1);
        int expected = myStack.peek();
        int actual = 1;
        assertEquals(expected, actual);
    }

    @Test
    public void pop() {
        myStack.push(1);
        int expected = myStack.pop();
        int actual = 1;
        assertEquals(expected, actual);
    }

    @Test
    public void remove() {
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.remove(1);
        int expected = myStack.getSize();
        int actual = 2;
        assertEquals(expected, actual);
    }

    @Test
    public void peek() {

    }

    @Test
    public void getSize() {
    }

    @Test
    public void clear() {
    }
}