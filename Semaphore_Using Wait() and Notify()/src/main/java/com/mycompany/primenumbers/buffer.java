/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.primenumbers;

import java.util.LinkedList;
import java.util.Queue;

public class buffer {

    public int size; // the buffer bound
    Queue<Object> que;
    semaphore spaces;
    semaphore elements;

    public buffer(int bufferSize) {
        size = bufferSize;
        spaces = new semaphore(size);
        elements = new semaphore(0);
        que = new LinkedList<>();
    }

    public void produce(Object value) {
        spaces.P();
        que.add(value);
        elements.V();
    }

    public Object consume() {
        Object value;
        elements.P();
        value = que.peek();
        que.remove();
        spaces.V();
        return value;
    }
}
