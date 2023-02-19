package TanKeGame;

import javax.swing.*;
import java.awt.*;

/**
 * @author muchen
 * @create 2022 - 09 - 2022/9/2 22:21
 */
public class Mypanel extends JPanel {
    Hero hero = null;

    public Mypanel() {
        hero = new Hero(100, 100);//初始化自己的坦克
    }

//    Mypanel mypanel = new Mypanel();      //？？？？？？

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0, 0, 1000, 750);//填充矩形，默认黑色

        drawTank(hero.getX(), hero.getY(), g, 0, 0);    //画出第一个自己的坦克
        drawTank(hero.getX() + 60, hero.getY(), g, 1, 1);


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
        switch (direction) {
            case 0: {
                g.fill3DRect(x, y, 10, 60, false);
                g.fill3DRect(x + 30,y,10,60,false);
                g.fill3DRect(x + 10,y + 10,20,40,false);
                g.fillOval(x + 10,y + 20,20,20);
                g.drawLine(x + 20,y + 30,x + 20,y);
            }

        }
    }
}
