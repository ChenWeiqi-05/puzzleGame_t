package com.chenweiqi.ui;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class GameJframe extends JFrame implements KeyListener, ActionListener {//keyListener
    int[][] data = new int[4][4];//4

    int x = 0;
    int y = 0;

    //boolean victory = victory();
    int[][] win = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 0}};

    int step = 0;
    JMenuItem replayItem = new JMenuItem("重新游戏条目");
    JMenuItem reLoginItem = new JMenuItem("重新登陆条目");
    JMenuItem closeItem = new JMenuItem("关闭条目");
    JMenuItem accountItem = new JMenuItem("公众号条目");

    JMenuItem pictureAnimal = new JMenuItem("Animal");
    JMenuItem pictureGirl = new JMenuItem("Girl");
    JMenuItem pictureSport = new JMenuItem("Sport");


    public GameJframe() {


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
        this.setLocationRelativeTo(null);// 设置居中
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLayout(null);

        this.addKeyListener(this);
//this.addMouseListener(this);

    }

    private void initJMenuBar() {
        JMenuBar jMenuBar = new JMenuBar();

        JMenu funcationJMenu = new JMenu("功能菜单");
        JMenu aboutJMenu = new JMenu("关于我们菜单");
        JMenu changeImage = new JMenu("更换图片");

        funcationJMenu.add(replayItem);
        funcationJMenu.add(reLoginItem);
        funcationJMenu.add(closeItem);
        funcationJMenu.add(changeImage);


        changeImage.add(pictureAnimal);
        changeImage.add(pictureGirl);
        changeImage.add(pictureSport);


        replayItem.addActionListener(this);
        reLoginItem.addActionListener(this);
        closeItem.addActionListener(this);
        accountItem.addActionListener(this);
        changeImage.addActionListener(this);

        pictureAnimal.addActionListener(this);
        pictureGirl.addActionListener(this);
        pictureSport.addActionListener(this);


        aboutJMenu.add(accountItem);
        jMenuBar.add(funcationJMenu);
        jMenuBar.add(aboutJMenu);


        this.setJMenuBar(jMenuBar);
    }

    private void initImage() {

        this.getContentPane().removeAll();
        // boolean victory = victory();
//        if (victory){
//
//            JLabel winJLabel = new JLabel(new ImageIcon(""));
//        }
        JLabel stepCount = new JLabel("步数：" + step);
        stepCount.setBounds(50, 30, 100, 20);
        this.getContentPane().add(stepCount);

        //   int num  = 1;
        for (int i = 0; i < 4; i++) {//4
            for (int j = 0; j < 4; j++) {//4

                int num = data[i][j];
                JLabel jLabel = new JLabel(new ImageIcon("E:\\idea_workspace\\puzzleGame_t\\image\\animal\\animal1\\" + num + ".jpg"));

                jLabel.setBounds(105 * j + 83, 105 * i + 134, 105, 105);

                jLabel.setBorder(new BevelBorder(0));//边框
                this.getContentPane().add(jLabel);//添加到容器中
                jLabel.setBounds(105 * j + 83, 105 * i + 134, 105, 105);  //设置图片位置
                num++;
            }
        }

        JLabel background = new JLabel(new ImageIcon("E:\\idea_workspace\\puzzleGame_t\\image\\register\\background.png"));
        background.setBounds(40, 40, 508, 560);


        this.getContentPane().add(background);

        this.getContentPane().repaint();

    }

    //actionLiteners
    //MouseListener
    //keyListener

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
            System.out.print(tempArr[i] + " ");
        }
        System.out.println();
//方法1
        // int[][] data = new int[4][4];
        for (int i = 0; i < tempArr.length; i++) {
            if (tempArr[i] == 0) {

                x = i / 4;//4
                y = i % 4;//4
            }
            data[i / 4][i % 4] = tempArr[i];

        }

        //以下为遍历二维数组，给里面每一个数据赋值方法2
//        int index = 0;
//        for (int i = 0; i < data.length; i++) {
//            for (int j = 0; j < data.length; j++) {
//                data[i][j] = tempArr[index];//赋值
//                index++;
//            }
//        }


//遍历二维数组，并打印到控制台中
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data.length; j++) {
                System.out.print(data[i][j] + " ");
            }
            System.out.println();
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == 65) {
            this.getContentPane().removeAll();
            JLabel all = new JLabel(new ImageIcon("E:\\idea_workspace\\puzzleGame_t\\image\\animal\\animal1\\all.jpg"));
            all.setBounds(83, 134, 420, 420);
            this.getContentPane().add(all);
            JLabel background = new JLabel(new ImageIcon("E:\\idea_workspace\\puzzleGame_t\\image\\register\\background.png"));
            background.setBounds(40, 40, 508, 560);
            this.getContentPane().add(background);
            this.getContentPane().repaint();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

//        if (victory){
//            return;
//        }
        int code = e.getKeyCode();
        System.out.println(code);
        if (code == 37) {
            System.out.println("向左");
            if (y == 3) {//3
                return;
            }

            data[x][y] = data[x][y + 1];
            data[x][y + 1] = 0;
            y++;
            initImage();

            step++;
        } else if (code == 38) {
            System.out.println("向上");

            if (x == 3) {//3
                return;
            }
            data[x][y] = data[x + 1][y];
            data[x + 1][y] = 0;
            x++;
            initImage();
            step++;
        } else if (code == 39) {
            System.out.println("向右");
            if (y == 0) {
                return;
            }
            data[x][y] = data[x][y - 1];
            data[x][y - 1] = 0;
            y--;
            initImage();
            step++;

        } else if (code == 40) {
            System.out.println("向下");
            if (x == 0) {
                return;
            }
            data[x][y] = data[x - 1][y];
            data[x - 1][y] = 0;
            x--;
            initImage();
            step++;
        } else if (code == 65) {
            initImage();
        } else if (code == 87) {
            data = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 0}};
            initImage();
            System.out.println("玩家长按W键还原拼图");
            step++;
        }

    }

    public boolean victory() {
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data.length; j++) {
                if (data[i][j] != win[i][j]) {
                    return false;
                }
            }
        }

        return true;

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Object obj = e.getSource();

        if (obj == replayItem) {
            System.out.println("重新游戏");
            step = 0;
            //再次打乱二维数组中的数据
            initData();
            //重新加载图片
            initImage();
            //计步器清零
        } else if (obj == reLoginItem) {


            System.out.println("重新登录");


        } else if (obj == closeItem) {
            System.out.println("关闭游戏");
        } else if (obj == accountItem) {
            System.out.println("微信公众号");

            JDialog jDialog = new JDialog();
            JLabel jLabel = new JLabel(new ImageIcon("H:\\OneDrive\\图片\\迷迭香.jpg"));

            jLabel.setBounds(0, 0, 400, 400);
            jDialog.getContentPane().add(jLabel);
            jDialog.setSize(344, 344);

            // 调用 JDialog 实例的 setAlwaysOnTop 方法
            jDialog.setAlwaysOnTop(true);
            // 显示对话框

            jDialog.setLocationRelativeTo(null);

            jDialog.setModal(true);

            jDialog.setVisible(true);

        }
        Object source2 = e.getSource();
        if (source2 == pictureGirl) {
            System.out.println("点击了女孩图片");
            Random r = new Random();
            int i = r.nextInt(10) + 1;

        }

    }

}
