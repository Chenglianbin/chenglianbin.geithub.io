package com.clblea.tankgame2;/*
 *  @author 程连斌
 *  @version 1.0
 */
//坦克大战的绘图区

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

public class MyPanel extends JPanel implements KeyListener {
    Hero hero;
    Vector<EnemyTank> enemyTanks = new Vector<>();
    int enemyTanksSize = 3;
    public MyPanel(){
        hero = new Hero(250 , 400);
        hero.setSpeed(5);
        /*hero1 = new Hero(100 , 200);//初始化一个坦克
        hero1.setSpeed(5);
        hero2 = new Hero(200 , 200);//初始化一个坦克
        hero2.setSpeed(5);
        hero3 = new Hero(400 , 200);//初始化一个坦克
        hero3.setSpeed(5);
        hero4 = new Hero(500 , 200);//初始化一个坦克
        hero4.setSpeed(5);*/
        //定义敌人坦克

        for (int i = 0; i < enemyTanksSize; i++) {
            enemyTanks.add(new EnemyTank(100 * (i + 1),0));
        }



    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0,0,1000,750);//填充矩形，默认黑色
        //画出坦克——分装方法
        drawTank(g,hero.getX(),hero.getY(),hero.getDirect(),1);
        for (int i = 0; i < enemyTanksSize; i++) {
            EnemyTank enemyTank = enemyTanks.get(i);
            drawTank(g ,enemyTank.getX(),enemyTank.getY(),enemyTank.getDirect(),0);
            enemyTank.setDirect(1);
        }

    }
    //编写方法，画出坦克
    /*
    * x 坦克左上角x坐标
    * y 坦克左上角y坐标
    * g 画笔
    * direct 坦克方向
    * type 坦克类型
    * */
    public void drawTank(Graphics g,int x , int y, int direct, int type){
        switch(type){
            case 0 ://我们的坦克
                g.setColor(Color.cyan);
                break;
            case 1://敌人的坦克
                g.setColor(Color.yellow);
                break;
        }
        //根据坦克方向绘制坦克
        switch (direct){
            case 0://上
                g.fill3DRect(x,y,10,60,false);//左轮
                g.fill3DRect(x + 30,y,10,60,false);//右轮
                g.fill3DRect(x + 10,y + 10,20,40,false);//盖子
                g.drawOval(x + 10,y + 20,20,20);//画圆盖
                g.drawLine(x + 20,y,x + 20,y +30);//炮筒
                break;
            case 1://下
                g.fill3DRect(x, y,10,60,false);//左轮
                g.fill3DRect(x + 30,y,10,60,false);//右轮
                g.fill3DRect(x + 10,y + 10,20,40,false);//盖子
                g.drawOval(x + 10,y + 20,20,20);//画圆盖
                g.drawLine(x + 20,y + 60,x + 20,y +30);//炮筒
                break;
            case 2://左
                g.fill3DRect(x, y, 60 ,10,false);
                g.fill3DRect(x, y + 30 , 60 , 10 ,false);
                g.fill3DRect(x + 10, y + 10, 40 ,20,false);
                g.drawOval(x + 20 ,y + 10 , 20, 20);
                g.drawLine(x, y + 20 ,x + 20 ,y + 20);
                break;
            case 3://右
                g.fill3DRect(x, y, 60 ,10,false);
                g.fill3DRect(x, y + 30 , 60 , 10 ,false);
                g.fill3DRect(x + 10, y + 10, 40 ,20,false);
                g.drawOval(x + 20 ,y + 10 , 20, 20);
                g.drawLine(x + 60, y + 20 ,x + 20 ,y + 20);
                break;
            default:
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_UP){
            hero.setDirect(0);
            hero.moveUp();
        }else if(e.getKeyCode() == KeyEvent.VK_S || e.getKeyCode() == KeyEvent.VK_DOWN){
            hero.setDirect(1);
            hero.moveDown();
        }else if (e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode() == KeyEvent.VK_LEFT){
            hero.setDirect(2);
            hero.moveLeft();
        } else if(e.getKeyCode() == KeyEvent.VK_D || e.getKeyCode() == KeyEvent.VK_RIGHT){
            hero.setDirect(3);
            hero.moveRight();
        }
        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
