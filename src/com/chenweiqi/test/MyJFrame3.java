package com.chenweiqi.test;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MyJFrame3 extends JFrame implements KeyListener {

    JButton jtb1 = new JButton("点我1");

    JButton jtb2 = new JButton("点我2");


    public MyJFrame3() {

        this.setSize(600, 680);
        this.setTitle("拼图游戏");

        this.setAlwaysOnTop(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        this.setLayout(null);


        jtb1.setBounds(0, 0, 100, 50);

       jtb1.addKeyListener(this);
       jtb2.addKeyListener(this);

        jtb2.setBounds(100, 0, 100, 50);

        this.getContentPane().add(jtb1);
        this.getContentPane().add(jtb2);

        this.setVisible(true);


    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("按键不松");
    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("松开按键");
        int code = e.getKeyCode();
  if (code ==65)
  {
      System.out.println("a");
  }
        System.out.println(code);
    }
}
