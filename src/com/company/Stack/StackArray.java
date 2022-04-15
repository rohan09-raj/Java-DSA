package com.company.Stack;

public class StackArray {
    int[] stackArray;
    int stackTop;

    // Constructor : Stack
    public StackArray(int size) {
        this.stackArray = new int[size];
        this.stackTop = -1;
        System.out.print("Stack: Created Successfully");
    }

    // isEmpty : Stack
    public boolean isEmpty() {
        return stackTop == -1;
    }

    // isFull : Stack
    public boolean isFull() {
        return stackTop == stackArray.length - 1;
    }

    // Push : Stack
    public void push(int value) {
        if (isFull()) {
            System.out.print("Stack is full!");
        } else {
            stackArray[stackTop+1] = value;
            stackTop++;
            System.out.print(value + " : Successfully Inserted");
        }
    }

    // Pop : Stack
    public int pop() {
        if (isEmpty()) {
            System.out.print("Stack is empty!");
            return -1;
        } else {
            int poppedValue = stackArray[stackTop];
            stackTop--;
            return poppedValue;
        }
    }

    // Peek : Stack
    public int peek() {
        if (isEmpty()) {
            System.out.print("Stack is empty!");
            return -1;
        } else {
            return stackArray[stackTop];
        }
    }

    // Delete : Stack
    public void delete() {
        stackArray = null;
        System.out.print("Stack deleted successfully");
    }

}
