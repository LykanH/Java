package TanKeGame02;

import javax.swing.*;

/**
 * v4.0 : 实现敌人坦克发射子弹，且可以同时存在多颗子弹
 *
 * @author muchen
 * @create 2022 - 09 - 2022/9/2 22:28
 */
public class TanKeGame02 extends JFrame {
    Mypanel m1 = null;
    public static void main(String[] args) {
        TanKeGame02 tanKeGame = new TanKeGame02();
    }
    public TanKeGame02(){
        m1 = new Mypanel();//该面板就是游戏的绘图区域

        this.addKeyListener(m1);

        this.add(m1);
        this.setSize(1000,750);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
