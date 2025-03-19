package com.chenweiqi.ui;

import javax.swing.*;

public class GameJframe extends JFrame {
    public GameJframe() {


        initJFrame();

        initJMenuBar();

        initImage();

        this.setVisible(true);

    }

    private void initImage() {
//        ImageIcon icon = new ImageIcon("image/animal/animal3/1.jpg");

        int number = 1;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                JLabel jLabel = new JLabel(new ImageIcon("image/animal/animal3/"+number+".jpg"));

                jLabel.setBounds(105*j,105*i,105,105);

                this.getContentPane().add(jLabel);

                number++;
            }
        }
    }

    private void initJFrame() {
        this.setSize(436, 483);
        this.setTitle("拼图界面");
        this.setAlwaysOnTop(true);
        this.setLocationRelativeTo(null);// 设置居中
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLayout(null);

    }

    private void initJMenuBar() {
        JMenuBar jMenuBar = new JMenuBar();

        JMenu funcationJMenu = new JMenu("功能菜单");
        JMenu aboutJMenu = new JMenu("关于我们菜单");

        JMenuItem replayItem = new JMenuItem("重新游戏条目");
        JMenuItem reLoginItem = new JMenuItem("重新登陆条目");
        JMenuItem closeItem = new JMenuItem("关闭条目");
        JMenuItem accountItem = new JMenuItem("公众号条目");

        funcationJMenu.add(replayItem);
        funcationJMenu.add(reLoginItem);
        funcationJMenu.add(closeItem);
        aboutJMenu.add(accountItem);

        jMenuBar.add(funcationJMenu);
        jMenuBar.add(aboutJMenu);


        this.setJMenuBar(jMenuBar);
    }


}
