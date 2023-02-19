package TanKeGame;

import javax.swing.*;

/**
 * @author muchen
 * @create 2022 - 09 - 2022/9/2 22:28
 */
public class TanKeGame01 extends JFrame {
    Mypanel m1 = null;
    public static void main(String[] args) {
        TanKeGame01 tanKeGame = new TanKeGame01();
    }
    public TanKeGame01(){
        m1 = new Mypanel();//该面板就是游戏的绘图区域
        this.add(m1);
        this.setSize(1000,750);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
