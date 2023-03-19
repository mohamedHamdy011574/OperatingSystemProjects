/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.primenumbers;

import java.io.IOException;
import java.util.Queue;
import java.util.Scanner;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PrimeNumbers {
    public static void main(String[] args) {
        Gui g = new Gui();
        g.setVisible(true);
    }
    static public Vector<Integer> calculatePrime(int n) {
        Vector<Integer> vector = new Vector<Integer>();
        int count;
        for (int i = 1; i <= n; i++) {
            count = 0;
            for (int j = 2; j <= i / 2; j++) {
                if (i % j == 0) {
                    count++;
                    break;
                }
            }
            if (count == 0) {
                vector.add(i);
            }
        }
        return vector;
    }
}
