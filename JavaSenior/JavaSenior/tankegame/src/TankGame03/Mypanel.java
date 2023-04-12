package TankGame03;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

/**
 * @author muchen
 * @create 2022 - 09 - 2022/9/2 22:21
 */
public class Mypanel extends JPanel implements KeyListener, Runnable {
    Hero hero = null;
    Vector<Enemy> enemyTank = new Vector();
    int enemyTankNum = 4;

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
        for (int i = 0; i < enemyTank.size(); i++) {           //画出敌人坦克
            Enemy enemy = enemyTank.get(i);
            drawTank(enemy.getX(), enemy.getY(), g, enemy.getDirect(), 1);
        }
        g.setColor(Color.magenta);
        if (hero.shot != null && hero.shot.isLive() == true) {
            System.out.println("子弹被绘制...");
            g.fill3DRect(hero.shot.getX(), hero.shot.getY(), 2, 2, false);
        }
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
            case 1: {               // 1:向右的坦克
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
        if (e.getKeyCode() == KeyEvent.VK_J) {
            hero.shotEnemyTank();
        }
        this.repaint();         //如果按下J后想让该子弹一直重绘，则需要将该类设计为多线程，在run接口
        // 中经过一段时间不停执行repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
//            System.out.println("正在执行repaint....");
            this.repaint();
        }
    }
}
