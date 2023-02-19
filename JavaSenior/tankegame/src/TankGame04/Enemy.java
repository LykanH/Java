package TankGame04;

import java.util.Vector;

/**
 * @author muchen
 * @create 2022 - 09 - 2022/9/4 15:40
 */
public class Enemy extends TanKe {
    int ememyTankNum = 3;
    Vector vector = new Vector();
    Shot shot = null;

    public Enemy(int x, int y, int direct) {
        super(x, y, direct);
        switch (direct) {
            case 0:
                shot = new Shot(x + 20, y, direct);
                break;
            case 1:
                shot = new Shot(x + 60, y + 20, direct);
                break;
            case 2:
                shot = new Shot(x + 20, y + 60, direct);
                break;
            case 3:
                shot = new Shot(x, y + 20, direct);
                break;
        }
        vector.add(shot);
        new Thread(shot).start();
    }

}
