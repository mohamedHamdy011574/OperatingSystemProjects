/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.primenumbers;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class consumer extends Thread {
    String output;
    buffer buf;
    public consumer(String output,buffer buf) {
        this.buf = buf;
        this.output = output;
    }

    public void run() {
        while (buf.que.size() > 0) {
            try {
                File file = new File("file.txt");
                FileWriter fr = new FileWriter(file, true);
                fr.write("' " + (buf.consume().toString()) + " ',");
                fr.close();
            } catch (IOException e) {
                System.out.println("error");
            }
        }
    }
}

