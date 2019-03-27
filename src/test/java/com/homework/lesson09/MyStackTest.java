package com.homework.lesson09;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MyStackTest {
    Stack<Integer> myStack;

    @Before
    public void setUp() {
        myStack = new MyStack<>(2);
    }

    @Test
    public void push() {
        myStack.push(1);
        int expected = 1;
        int actual = myStack.peek();
        assertEquals(expected, actual);
    }

    @Test
    public void pop() {
        myStack.push(1);
        int expected = 1;
        int actual = myStack.pop();
        assertEquals(expected, actual);
    }

    @Test
    public void remove() {
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.remove(1);
        int expected = 2;
        int actual = myStack.getSize();
        assertEquals(expected, actual);
    }

    @Test
    public void peek() {
        myStack.push(1);
        myStack.push(2);
        int expected = 2;
        int actual = myStack.peek();
        assertEquals(expected, actual);
    }

    @Test
    public void getSize() {
        myStack.push(1);
        myStack.push(1);
        int actual = myStack.getSize();
        int expected = 2;
        assertEquals(expected, actual);
    }

    @Test
    public void clear() {
        myStack.push(1);
        myStack.push(1);
        myStack.clear();
        int expected = 0;
        int actual = myStack.getSize();
        assertEquals(expected, actual);
    }
}