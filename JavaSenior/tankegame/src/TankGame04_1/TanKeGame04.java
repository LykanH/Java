package TankGame04_1;

import javax.swing.*;

/**
 * 敌人发射子弹，且己方坦克发出子弹,且如果击中敌方坦克， 敌方坦克消失！
 * @author muchen
 * @create 2022 - 09 - 2022/9/2 22:28
 */
public class TanKeGame04 extends JFrame {
    Mypanel m1 = null;
    public static void main(String[] args) {
        TanKeGame04 tanKeGame = new TanKeGame04();
    }
    public TanKeGame04(){
        m1 = new Mypanel();//该面板就是游戏的绘图区域

        this.addKeyListener(m1);
        new Thread(m1).start();
        this.add(m1);
        this.setSize(1000,750);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
