package com.chenweiqi.test;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class test3 {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame();
        jFrame.setSize(603, 680);
        jFrame.setTitle("拼图游戏");
        jFrame.setAlwaysOnTop(true);

        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setLayout(null);

        JButton jtb = new JButton("点我");

        jtb.setBounds(0, 0, 100, 50);

        jtb.addActionListener(new MyActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //匿名内部类
                System.out.println("不要点我！！！");
            }


        });

        jFrame.getContentPane().add(jtb);

        jFrame.setVisible(true);


    }
}
