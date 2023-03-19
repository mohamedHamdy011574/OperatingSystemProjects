/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.primenumbers;

public class semaphore {

    protected int value = 0;

    protected semaphore() {
        value = 0;
    }

    protected semaphore(int initial) {
        value = initial;
    }

    public synchronized void P() {
        value--;
        if (value < 0)
    try {
            wait();
        } catch (InterruptedException e) {
        }
    }

    public synchronized void V() {
        value++;
        if (value <= 0) {
            notify();
        }
    }
}
