/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.primenumbers;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;
import java.util.*;

public class producer extends Thread{
    buffer buf;
    Vector<Integer> vec =new Vector<Integer>();
    public producer(buffer buf,Vector<Integer> v) {
        this.buf = buf;
        vec = v;
    }


    public void run() {
        for (int i = 0; i < vec.size(); i++){
            buf.produce(vec.get(i));
        }
    }
}