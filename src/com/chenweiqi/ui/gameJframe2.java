package com.chenweiqi.ui;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class gameJframe2 extends JFrame implements KeyListener, ActionListener {
    int[][] data = new int[4][4];

    int x = 0;
    int y = 0;

    int[][] win = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 0}};

    int step = 0;
    JMenuItem replayItem = new JMenuItem("重新游戏条目");
    JMenuItem reLoginItem = new JMenuItem("重新登陆条目");
    JMenuItem closeItem = new JMenuItem("关闭条目");
    JMenuItem accountItem = new JMenuItem("公众号条目");

    JMenuItem pictureAnimal = new JMenuItem("Animal");
    JMenuItem pictureGirl = new JMenuItem("Girl");
    JMenuItem pictureSport = new JMenuItem("Sport");

    // 添加一个变量来存储当前图片路径
    private String currentImagePath = "E:\\idea_workspace\\puzzleGame_t\\image\\animal\\animal1";

    public gameJframe2() {
        initJFrame();
        initJMenuBar();
        initData();
        initImage(currentImagePath); // 使用当前图片路径
        this.setVisible(true);
    }

    private void initJFrame() {
        this.setSize(603, 680);
        this.setTitle("拼图界面");
        this.setAlwaysOnTop(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.addKeyListener(this);
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
        pictureAnimal.addActionListener(this);
        pictureGirl.addActionListener(this);
        pictureSport.addActionListener(this);

        aboutJMenu.add(accountItem);
        jMenuBar.add(funcationJMenu);
        jMenuBar.add(aboutJMenu);

        this.setJMenuBar(jMenuBar);
    }

    private void initImage(String imagePath) {
        this.getContentPane().removeAll();

        JLabel stepCount = new JLabel("步数：" + step);
        stepCount.setBounds(50, 30, 100, 20);
        this.getContentPane().add(stepCount);

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int num = data[i][j];
                JLabel jLabel = new JLabel(new ImageIcon(imagePath + "\\" + num + ".jpg"));
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
            }
            data[i / 4][i % 4] = tempArr[i];
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
        int code = e.getKeyCode();
        System.out.println(code);
        if (code == 37) {
            if (y == 3) {
                return;
            }
            data[x][y] = data[x][y + 1];
            data[x][y + 1] = 0;
            y++;
            initImage(currentImagePath); // 使用当前图片路径
            step++;
        } else if (code == 38) {
            if (x == 3) {
                return;
            }
            data[x][y] = data[x + 1][y];
            data[x + 1][y] = 0;
            x++;
            initImage(currentImagePath); // 使用当前图片路径
            step++;
        } else if (code == 39) {
            if (y == 0) {
                return;
            }
            data[x][y] = data[x][y - 1];
            data[x][y - 1] = 0;
            y--;
            initImage(currentImagePath); // 使用当前图片路径
            step++;
        } else if (code == 40) {
            if (x == 0) {
                return;
            }
            data[x][y] = data[x - 1][y];
            data[x - 1][y] = 0;
            x--;
            initImage(currentImagePath); // 使用当前图片路径
            step++;
        } else if (code == 65) {
            initImage(currentImagePath); // 使用当前图片路径
        } else if (code == 87) {
            data = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 0}};
            initImage(currentImagePath); // 使用当前图片路径
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
            initData();
            initImage(currentImagePath); // 使用当前图片路径
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
            jDialog.setAlwaysOnTop(true);
            jDialog.setLocationRelativeTo(null);
            jDialog.setModal(true);
            jDialog.setVisible(true);
        } else if (obj == pictureGirl) {
            System.out.println("点击了女孩图片");
            Random r = new Random();
            int randomNumber = r.nextInt(10) + 1; // 生成1到10之间的随机数

            String imagePath = "E:\\idea_workspace\\puzzleGame_t\\image\\girl\\girl" + randomNumber;
             System.out.println("图片路径为："+imagePath  );
            currentImagePath = imagePath; // 更新当前图片路径
            initImage(imagePath);
        } else if (obj == pictureAnimal) {
            System.out.println("点击了动物图片");//图片路径为
            Random r = new Random();
            int randomNumber = r.nextInt(10) + 1;
            String imagePath = "E:\\idea_workspace\\puzzleGame_t\\image\\animal\\animal" + randomNumber;
            System.out.println("图片路径为："+imagePath );
            currentImagePath = imagePath; // 更新当前图片路径
            initImage(imagePath);
        } else if (obj == pictureSport) {
            System.out.println("点击了运动图片");
            Random r = new Random();
            int randomNumber = r.nextInt(10) + 1;   String imagePath = "E:\\idea_workspace\\puzzleGame_t\\image\\sport\\sport" + randomNumber;
            System.out.println("图片路径为："+imagePath  );
            currentImagePath = imagePath; // 更新当前图片路径
            initImage(imagePath);
        }
    }
}
