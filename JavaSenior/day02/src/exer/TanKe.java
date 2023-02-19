package exer;

import javax.swing.*;
import java.awt.*;

/**
 * @author muchen
 * @create 2022 - 09 - 2022/9/2 17:30
 */
@SuppressWarnings({"all"})
public class TanKe extends JFrame{

    public static void main(String[] args) {
        new TanKe();
    }
    private Mypanel2 m2 = null;
    public TanKe(){
        m2 = new Mypanel2();
        this.add(m2);
        this.setSize(500,500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
class Mypanel2 extends JPanel{
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.black);
        g.fillRect(0,0,500,500);
        g.setColor(Color.BLUE);
        g.fillOval(130,135,30,30);
        g.setColor(new Color(51,102,150,110));
        g.fillRect(110,110,20,80);
        g.fillRect(160,110,20,80);
        g.fillRect(144,100,2,50);
        g.fillRect(120,125,50,50);
    }
}
