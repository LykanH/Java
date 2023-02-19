package TankGame7;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Scanner;

/**
 * 优化：1.防止坦克重叠
 *      2.写出游戏数据界面，在文件中记录玩家成绩
 *      3.实现游戏存盘，使玩家可以选择继续上局游戏
 *      4.继续上局游戏
 * @author muchen
 * @create 2022 - 09 - 2022/9/2 22:28
 */

@SuppressWarnings("all")
public class TanKeGame07 extends JFrame {
    static String flag = "";
    Mypanel m1 = null;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("继续上一把输入:1,开启新游戏输入:2 ：");
        flag = scanner.next();
        TanKeGame07 tanKeGame = new TanKeGame07();
    }
    public TanKeGame07(){
        m1 = new Mypanel(flag);//该面板就是游戏的绘图区域
        this.addKeyListener(m1);
        new Thread(m1).start();
        this.add(m1);
        this.setSize (1300,785);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        //在JFrame中加入窗口关闭时的响应事件，游戏退出时，将游戏中存储的数据存入文件中
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                Recorder.storeEnemyNum();
                System.exit(0);
            }
        });
    }
}
