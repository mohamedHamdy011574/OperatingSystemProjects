/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.primenumbers;

import java.util.Vector;

/**
 *
 * @author Aliaa
 */
public class Gui extends javax.swing.JFrame {

    /**
     * Creates new form Gui
     */
    public Gui() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        inputN = new javax.swing.JTextField();
        InputBufferSize = new javax.swing.JTextField();
        InputOutputFile = new javax.swing.JTextField();
        N = new javax.swing.JLabel();
        BuferSize = new javax.swing.JLabel();
        OutputFile = new javax.swing.JLabel();
        producer = new javax.swing.JButton();
        LargestNum = new javax.swing.JLabel();
        numberOfEle = new javax.swing.JLabel();
        time = new javax.swing.JLabel();
        LargestNumOut = new javax.swing.JLabel();
        numberOfEleOut = new javax.swing.JLabel();
        timeOutput = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        inputN.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        inputN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputNActionPerformed(evt);
            }
        });

        InputBufferSize.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        InputBufferSize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InputBufferSizeActionPerformed(evt);
            }
        });

        InputOutputFile.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        InputOutputFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InputOutputFileActionPerformed(evt);
            }
        });

        N.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        N.setText(" N");

        BuferSize.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        BuferSize.setText(" Bufer Size");

        OutputFile.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        OutputFile.setText(" OutputFile");

        producer.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        producer.setText(" start producer");
        producer.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(204, 255, 255)));
        producer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                producerActionPerformed(evt);
            }
        });

        LargestNum.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        LargestNum.setText("the largest prime number");

        numberOfEle.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        numberOfEle.setText("# of elements (prime numbers) generoter");

        time.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        time.setText("time elapsed sine start procssing");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(inputN, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                            .addComponent(InputOutputFile)
                            .addComponent(InputBufferSize))
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BuferSize, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(N, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(OutputFile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(producer))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(numberOfEle, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(LargestNum, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(time, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(LargestNumOut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(6, 6, 6))
                            .addComponent(numberOfEleOut, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                            .addComponent(timeOutput, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(inputN, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(N, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(BuferSize, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(InputBufferSize, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(InputOutputFile, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(OutputFile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(producer, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(LargestNumOut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(LargestNum, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(numberOfEleOut, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                    .addComponent(numberOfEle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(timeOutput, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(time, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(78, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void InputOutputFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InputOutputFileActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_InputOutputFileActionPerformed

    private void InputBufferSizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InputBufferSizeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_InputBufferSizeActionPerformed

    private void inputNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputNActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputNActionPerformed

    private void producerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_producerActionPerformed
        // TODO add your handling code here:
        String output = OutputFile.getText();
        String bufferS = InputBufferSize.getText();
        String N = inputN.getText();
        int n = Integer.parseInt(N);
        PrimeNumbers pr = new PrimeNumbers();
        int bufferSize = Integer.parseInt(bufferS);
        Vector<Integer> vec_tor =new Vector<Integer>();        
        vec_tor = pr.calculatePrime(n);
        long startTime = System.nanoTime();
        buffer buf = new buffer(bufferSize);
        producer P = new producer(buf, vec_tor);
        consumer C = new consumer(output,buf);
        P.start();
        C.start();
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        timeOutput.setText(String.valueOf(duration));
        numberOfEleOut.setText(String.valueOf(vec_tor.size()));
        LargestNumOut.setText(String.valueOf(vec_tor.lastElement()));
    }//GEN-LAST:event_producerActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Gui().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BuferSize;
    private javax.swing.JTextField InputBufferSize;
    private javax.swing.JTextField InputOutputFile;
    private javax.swing.JLabel LargestNum;
    private javax.swing.JLabel LargestNumOut;
    private javax.swing.JLabel N;
    private javax.swing.JLabel OutputFile;
    private javax.swing.JTextField inputN;
    private javax.swing.JLabel numberOfEle;
    private javax.swing.JLabel numberOfEleOut;
    private javax.swing.JButton producer;
    private javax.swing.JLabel time;
    private javax.swing.JLabel timeOutput;
    // End of variables declaration//GEN-END:variables
}
