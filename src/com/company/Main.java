package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class StackFullException extends Exception {}

class StackEmptyException extends Exception {}


class Stack<E> {
    private E[] elements;
    private int index = 0;
    private int size;

    Stack(int size) {
        elements = (E[]) new Object[size];
        this.size = size;
    }

    public E[] getElements() {
        return elements;
    }

    public int getIndex() {
        return index;
    }

    public int getSize() {
        return size;
    }

    E enqueue(){
        E returnElement = elements[index];
        index++;
        return returnElement;
    }

    E dequeue(){
       E addElement = elements[index];
        index--;
       E[] removeElement = (E[]) (elements[index] = null);

       return addElement;
    }

    void push(E element ) throws StackFullException {
        if (index >= size) {
            throw new StackFullException();
        }

        elements[index] = element;
        index++;
    }

    E pop () throws StackEmptyException {
        if (index == 0) {
            throw new StackEmptyException();
        }

        E returnElement = elements[index - 1];
        index--;
        return returnElement;
    }
}


public class Main {

    public static void main(String[] agrs) {
        Stack<String> strings = new Stack<>(2);
        List<String> test = new ArrayList<>();
        try {
            strings.push("Hello");
            strings.push("World");
            System.out.println(strings.pop());
            System.out.println(strings.pop());
            System.out.println("----");
            System.out.println(strings.enqueue());
            System.out.println(strings.dequeue());
        } catch (StackFullException | StackEmptyException e) {
            e.printStackTrace();
        }

    }
}
