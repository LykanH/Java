package event;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * @author muchen
 * @create 2022 - 09 - 2022/9/4 10:19
 * 演示小球通过键盘控制 上下左右移动——>讲解Java的事件控制
 */
public class BallMove extends JFrame{
    Mypanel mypanel = null;

    public BallMove(){
        mypanel = new Mypanel();

        this.addKeyListener(mypanel);//******窗口JFrame可以监听事件（在mypanel上触发的事件）

        this.setSize(500,500);
        this.add(mypanel);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {
        new BallMove();
    }

}
class Mypanel extends JPanel implements KeyListener {
    private int x = 100;
    private int y = 100;

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.GREEN);
        g.fillOval(x,y,20,20);
    }

    @Override   //字符打印监听
    public void keyTyped(KeyEvent e) {

    }

    @Override   //*****键盘按下监听
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_DOWN){    //*******
            y+=2;
        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
            y-=2;
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            x-=2;
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            x+=2;
        }
        this.repaint();     //让面板重绘
    }

    @Override   //按键释放监听
    public void keyReleased(KeyEvent e) {

    }
}

