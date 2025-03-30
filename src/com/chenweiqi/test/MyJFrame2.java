package com.chenweiqi.test;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

public class MyJFrame2 extends JFrame implements MouseListener {

    JButton jtb1 = new JButton("点我1");

    JButton jtb2 = new JButton("点我2");


    public MyJFrame2() {

        this.setSize(600, 680);
        this.setTitle("拼图游戏");

        this.setAlwaysOnTop(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        this.setLayout(null);


        jtb1.setBounds(0, 0, 100, 50);

       jtb1.addMouseListener(this);

        jtb2.addMouseListener(this);

        jtb2.setBounds(100, 0, 100, 50);

        this.getContentPane().add(jtb1);
        this.getContentPane().add(jtb2);

        this.setVisible(true);


    }


    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("点击");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("按下");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("松开");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.println("划入");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        System.out.println("划出");
    }
}
