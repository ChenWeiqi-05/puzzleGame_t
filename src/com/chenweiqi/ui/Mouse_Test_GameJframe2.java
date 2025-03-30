package com.chenweiqi.ui;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

public class Mouse_Test_GameJframe2 extends JFrame implements MouseListener {
    int[][] data = new int[4][4];

    int x = 0;
    int y = 0;

    public Mouse_Test_GameJframe2() {
        initJFrame();
        initJMenuBar();
        initData();
        initImage();
        this.setVisible(true);
    }

    private void initJFrame() {
        this.setSize(603, 680);
        this.setTitle("拼图界面");
        this.setAlwaysOnTop(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.addMouseListener(this);
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

    private void initImage() {
        this.getContentPane().removeAll();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int num = data[i][j];
                JLabel jLabel = new JLabel(new ImageIcon("E:\\idea_workspace\\puzzleGame_t\\image\\animal\\animal1\\" + num + ".jpg"));
                jLabel.setBounds(105 * j + 83, 105 * i + 134, 105, 105);
                jLabel.setBorder(new BevelBorder(0));
                this.getContentPane().add(jLabel);
            }
        }

        JLabel background = new JLabel(new ImageIcon("E:\\idea_workspace\\puzzleGame_t\\image\\register\\background.png"));
        background.setBounds(40, 40, 508, 560);
        this.getContentPane().add(background);

        this.getContentPane().repaint();
    }

    private void initData() {
        int[] tempArr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        Random r = new Random();
        for (int i = 0; i < tempArr.length; i++) {
            int index = r.nextInt(tempArr.length);
            int temp = tempArr[i];
            tempArr[i] = tempArr[index];
            tempArr[index] = temp;
        }

        for (int i = 0; i < tempArr.length; i++) {
            if (tempArr[i] == 0) {
                x = i / 4;
                y = i % 4;
            } else {
                data[i / 4][i % 4] = tempArr[i];
            }
        }
    }

    int count = 0;
    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("鼠标被点击了" + count++ + "次");
        int mx = e.getX();
        int my = e.getY();
        System.out.println("点击位置: (" + mx + ", " + my + ")");

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int px = 105 * j + 83;
                int py = 105 * i + 134;
                if (mx >= px && mx <= px + 105 && my >= py && my <= py + 105) {
                    System.out.println("匹配到拼图块: (" + i + ", " + j + ")");
                    if (canMove(i, j)) {
                        swap(i, j, x, y);
                        x = i;
                        y = j;
                        initImage();
                    }
                }
            }
        }
    }


    private boolean canMove(int i, int j) {
        return (i == x && Math.abs(j - y) == 1) || (j == y && Math.abs(i - x) == 1);
    }

    private void swap(int i1, int j1, int i2, int j2) {
        int temp = data[i1][j1];
        data[i1][j1] = data[i2][j2];
        data[i2][j2] = temp;
    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
}

