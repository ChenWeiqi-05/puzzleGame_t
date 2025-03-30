package com.chenweiqi.test;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class MyJFrame extends javax.swing.JFrame implements ActionListener {

    JButton jtb1 = new JButton("点我1");

    JButton jtb2 = new JButton("点我2");


    public MyJFrame() {

        this.setSize(600, 680);
        this.setTitle("拼图游戏");

        this.setAlwaysOnTop(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        this.setLayout(null);


        jtb1.setBounds(0, 0, 100, 50);

        jtb1.addActionListener(this);

        jtb2.addActionListener(this);

        jtb2.setBounds(100, 0, 100, 50);

        this.getContentPane().add(jtb1);
        this.getContentPane().add(jtb2);

        this.setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == jtb1) {

            jtb1.setLocation(100, 100);
            System.out.println("你点击了按钮1");
        } else if (source == jtb2) {
            Random r = new Random();
            jtb2.setLocation(r.nextInt(500),r.nextInt(500));
            System.out.println("你点击了按钮2");
        }


    }
}
