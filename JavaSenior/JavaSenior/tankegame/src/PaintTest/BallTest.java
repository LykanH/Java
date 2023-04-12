package PaintTest;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * @author muchen
 * @create 2022 - 10 - 2022/10/14 0:30
 */
public class BallTest {
    public static void main(String[] args) {
        new myFram();
    }
}

class myFram extends JFrame{
    MyPaint myPaint = new MyPaint();
    public myFram(){
        this.add(myPaint);
        this.addKeyListener(myPaint);
        this.setSize(400,400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}

class Ball{
    private int x,y,width,higth;

    public Ball(int x, int y, int width,int higth) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.higth = higth;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHigth() {
        return higth;
    }

    public void setHigth(int higth) {
        this.higth = higth;
    }
}

class MyPaint extends JPanel implements KeyListener {
    Ball ball1 = new Ball(50,50,10,10);
    Ball ball2 = new Ball(100,100,10,10);
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.cyan);
        g.fillOval(ball1.getX(),ball1.getY(),ball1.getWidth(),ball1.getHigth());
        g.fillOval(ball2.getX(),ball2.getY(),ball2.getWidth(),ball2.getHigth());
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
//        System.out.println((char) e.getKeyCode() + "被按下....");
        if(e.getKeyCode() == KeyEvent.VK_UP){
            ball1.setY(ball1.getY() - 2);
        }else if (e.getKeyCode() == KeyEvent.VK_DOWN){
            ball1.setY(ball1.getY() + 2);
        }else if (e.getKeyCode() == KeyEvent.VK_LEFT){
            ball1.setX(ball1.getX() - 2);
        }else if (e.getKeyCode() == KeyEvent.VK_RIGHT){
            ball1.setX(ball1.getX() + 2);
        }
        this.repaint();

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
