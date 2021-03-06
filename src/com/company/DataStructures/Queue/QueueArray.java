package com.company.DataStructures.Queue;

public class QueueArray {
    int[] queueArray;
    int queueTop;
    int queueStart;

    // Constructor : Queue
    public QueueArray(int size) {
        this.queueArray = new int[size];
        this.queueTop = -1;
        this.queueStart = -1;
        System.out.print("Queue Successfully Created of Size : " + size);
    }

    // isEmpty : Queue
    public boolean isEmpty() {
        return queueStart == -1 || queueStart == queueArray.length;
    }

    // isFull : Queue
    public boolean isFull() {
        return queueTop == queueArray.length-1;
    }

    // enQueue : Queue
    public void enQueue(int value) {
        if (isFull()) {
            System.out.print("Queue is full");
        } else if (isEmpty()) {
            queueStart = 0;
            queueTop++;
            queueArray[queueTop] = value;
            System.out.print(value + " : Inserted Successfully");
        } else {
            queueTop++;
            queueArray[queueTop] = value;
            System.out.print(value + " : Inserted Successfully");
        }
    }

    // deQueue : Queue
    public int deQueue() {
        if (isEmpty()) {
            System.out.print("Queue is empty");
            return -1;
        } else {
            int removedElement = queueArray[queueStart];
            queueStart++;
            if (queueStart > queueTop) {
                queueStart = queueTop = -1;
            }
            return removedElement;
        }
    }

    // Peek : Queue
    public int peek() {
        if (!isEmpty()) {
            return queueArray[queueStart];
        } else {
            System.out.print("Queue is empty");
            return -1;
        }
    }

    public void delete() {
        queueArray = null;
        System.out.print("Queue: Deleted Successfully");
    }
}
