package TanKeGame02;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

/**
 * @author muchen
 * @create 2022 - 09 - 2022/9/2 22:21
 */
public class Mypanel extends JPanel implements KeyListener {
    Hero hero = null;
    Vector<Enemy> enemyTank = new Vector();
    int enemyTankNum = 4;

    //    Enemy[] enemies = new Enemy[3];
//    Enemy enemy = null;
    public Mypanel() {
        for (int i = 0; i < enemyTankNum; i++) {
            enemyTank.add(new Enemy(100 * (i + 1), 0, 2));
        }
        hero = new Hero(100, 100, 0);//初始化自己的坦克
        hero.setSpeed(4);       //将坦克的移动速度设置为4
    }

//    Mypanel mypanel = new Mypanel();      //？？？？？？

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0, 0, 1000, 750);//填充矩形，默认黑色
        drawTank(hero.getX(), hero.getY(), g, hero.getDirect(), 0);//画出第一个自己的坦克

        for (int i = 0; i < enemyTank.size(); i++) {
            Enemy enemy = enemyTank.get(i);
            drawTank(enemy.getX(),enemy.getY(),g,enemy.getDirect(),1);
        }
//        drawTank(enemyTank.get.getX(), enemies[1].getY(), g, enemies[1].getDirect(), 1);
//        drawTank(enemy.getX() + 60,enemy.getY(),g,enemy.getDirect(),1);
//        drawTank(enemy.getX() + 120,enemy.getY(),g,enemy.getDirect(),1);
//        drawTank(hero.getX() + 60, hero.getY(), g, hero.getDirect(), 1);
//        drawTank(hero.getX() + 120, hero.getY(), g, 2, 1);
//        drawTank(hero.getX() + 180, hero.getY(), g, 3, 1);


//        g.fillRect(0,0,500,500);
//        g.setColor(Color.BLUE);
//        g.fillOval(130,135,30,30);//坦克圆盘
//        g.setColor(new Color(51,102,150,110));
//        g.fillRect(110,110,20,80);//坦克左轮
//        g.fillRect(160,110,20,80);//坦克右轮
//        g.fillRect(144,110,2,25);//坦克弹道
//        g.fillRect(120,125,50,50);//坦克车身
    }


    /**
     * @param x:坦克左上角的x坐标
     * @param y：坦克左上角的y坐标
     * @param g：画笔
     * @param direction：坦克的方向
     * @param type：坦克的类型，友军还是敌军
     */
    public void drawTank(int x, int y, Graphics g, int direction, int type) {
        switch (type) {
            case 0: {
                g.setColor(Color.cyan);
                break;
            }
            case 1: {
                g.setColor(Color.GREEN);
                break;
            }
        }
        //通过type的值来控制坦克的方向(0:向上,1:向右,2:向下,3:向左)
        switch (direction) {
            case 0: {               // 0:向上的坦克
                g.fill3DRect(x, y, 10, 60, false);
                g.fill3DRect(x + 30, y, 10, 60, false);
                g.fill3DRect(x + 10, y + 10, 20, 40, false);
                g.fillOval(x + 10, y + 20, 20, 20);
                g.drawLine(x + 20, y + 30, x + 20, y);
                break;
            }
            case 1: {               // 0:向右的坦克
                g.fill3DRect(x, y, 60, 10, false);
                g.fill3DRect(x, y + 30, 60, 10, false);
                g.fill3DRect(x + 10, y + 10, 40, 20, false);
                g.fillOval(x + 20, y + 10, 20, 20);
                g.drawLine(x + 20, y + 20, x + 60, y + 20);
                break;
            }
            case 2: {      //向下的坦克
                g.fill3DRect(x, y, 10, 60, false);
                g.fill3DRect(x + 30, y, 10, 60, false);
                g.fill3DRect(x + 10, y + 10, 20, 40, false);
                g.fillOval(x + 10, y + 20, 20, 20);
                g.drawLine(x + 20, y + 30, x + 20, y + 60);
                break;
            }
            case 3: {      //向左的坦克
                g.fill3DRect(x, y, 60, 10, false);
                g.fill3DRect(x, y + 30, 60, 10, false);
                g.fill3DRect(x + 10, y + 10, 40, 20, false);
                g.fillOval(x + 20, y + 10, 20, 20);
                g.drawLine(x + 20, y + 20, x, y + 20);
                break;
            }

        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W) {
//            hero.setY(hero.getY() - hero.getSpeed());
            //修改坦克的朝向
            hero.setDirect(0);
            //使坦克移动
            hero.tank_Up();
//            drawTank(hero.getX(), hero.getY(),getGraphics(), 0, 0);//不能修改原来坦克方向，仅仅是新创造了一个坦克
        } else if (e.getKeyCode() == KeyEvent.VK_D) {
//            hero.setX(hero.getX() + hero.getSpeed());
            //朝向右
            hero.setDirect(1);
//            向右移动
            hero.tank_Right();
//            drawTank(hero.getX(), hero.getY(),getGraphics(), 1, 0);
        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            hero.setDirect(2);
//            hero.setY(hero.getY() + hero.getSpeed());
            hero.tank_Down();
//            drawTank(hero.getX(), hero.getY(),getGraphics(), 2, 0);
        } else if (e.getKeyCode() == KeyEvent.VK_A) {
            hero.setDirect(3);
            hero.tank_Left();
//            hero.setX(hero.getX() - hero.getSpeed());
//            drawTank(hero.getX(), hero.getY(),getGraphics(), 3, 0);
        }
        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
