package TankGame6;

import javax.swing.*;

/**
 * 优化：实现敌方坦克子弹消失之后可以再次发射子弹
 *       敌人可以发射多颗子弹或者等敌人子弹消失后才能再次发射
 *       敌人击中我方坦克，我防坦克消失
 * @author muchen
 * @create 2022 - 09 - 2022/9/2 22:28
 */
public class TanKeGame06 extends JFrame {
    Mypanel m1 = null;
    public static void main(String[] args) {
        TanKeGame06 tanKeGame = new TanKeGame06();
    }
    public TanKeGame06(){
        m1 = new Mypanel();//该面板就是游戏的绘图区域
        this.addKeyListener(m1);
        new Thread(m1).start();
        this.add(m1);
        this.setSize (1000,750);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
