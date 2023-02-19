package exer;

import javax.swing.*;
import java.awt.*;

/**
 * @author muchen
 * @create 2022 - 09 - 2022/9/2 16:43
 */
@SuppressWarnings({"all"})
public class DrawCircle extends JFrame{     //JFrame对应一个窗口
    //实例化出来一个面板
    private Mypanel m1 = null;

    public DrawCircle(){
        //初始化面板
        m1 = new Mypanel();
        //把面板放入画框
        this.add(m1);
        //设置窗口的大小
        this.setSize(1000,800);

        //当鼠标点击关闭窗口，窗口真正退出
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setVisible(true);//设置可以显示
    }
    public static void main(String[] args) {
        new DrawCircle();
    }
}
class Mypanel extends JPanel{
    //定义方法继承JPanel类，即为一个面板，而话图形就在面板上画
    @Override
    public void paint(Graphics g) {     //绘图方法
        super.paint(g);     //调用父类的方法完成初始化，不能去掉
//        g.drawOval(100,100,300,300);       //直径为300的圆形
//        g.drawLine(10,10,100,100);      //起始点为（10，10），终点为（100.100）的直线
//        g.drawRect(100,100,100,100);      //长宽都为100的长方形

        g.setColor(Color.CYAN);     //设置画笔的颜色
        g.fillRect(100,100,200,200);      //填充矩形

//        g.setColor(Color.CYAN);
//        g.fillOval(100,100,500,300);      //填充圆形或者椭圆

//        g.setColor(Color.CYAN);
//        g.
    }
}
