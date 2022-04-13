package com.company;

import java.util.Arrays;


class QueueFullException extends Exception {}

class QueueEmptyException extends Exception {}

class Queue<E> {
    private E[] elements;
    private int index = 0;
    private int size;

    Queue(int size) {
        elements = (E[]) new Object[size];
        this.size = size;
    }

    void enqueue(E element) throws QueueFullException{
        if (index >= size) {
            throw new QueueFullException();
        }

        elements[index] = element;
        index++;
    }

    E dequeue () throws QueueEmptyException{
        if(index == 0){
            throw new QueueEmptyException();
        }
        E returnElement = elements[size - index];
        index--;
        return returnElement;
    }

    @Override
    public String toString() {
        return Arrays.toString(elements);
    }
}




public class Main {

    public static void main(String[] agrs) {
        Queue<String> strings = new Queue<>(3);
        try {
            strings.enqueue("Test");
            strings.enqueue("Test2");
            strings.enqueue("Test3");
            System.out.println(strings.dequeue());
            System.out.println(strings.dequeue());
            System.out.println(strings.dequeue());
        } catch (QueueFullException | QueueEmptyException e) {
            e.printStackTrace();
        }

    }
}
