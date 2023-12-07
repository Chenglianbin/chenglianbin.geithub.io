package com.clblea.tankgame2;/*
 *  @author 程连斌
 *  @version 1.0
 */

import javax.swing.*;

public class ClbTankGame02 extends JFrame {
    MyPanel mp = null;
    public static void main(String[] args) {
        ClbTankGame02 clbTankGame02 = new ClbTankGame02();
    }
    public ClbTankGame02(){
        mp = new MyPanel();
        this.add(mp);
        this.setSize(1000, 750);
        this.addKeyListener(mp);//JFream 监听
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
