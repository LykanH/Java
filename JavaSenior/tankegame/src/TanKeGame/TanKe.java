package TanKeGame;

/**
 * @author muchen
 * @create 2022 - 09 - 2022/9/2 22:13
 */
public class TanKe {
    private int x;
    private int y;

    public TanKe(int x, int y) {
        this.x = x;//坦克的横坐标
        this.y = y;//坦克的纵坐标
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
}
