package TankGame7;

/**
 * @author muchen
 * @create 2022 - 09 - 2022/9/2 22:13
 */
public class TanKe {
    private int x;
    private int y;

    private int direct;
    private int speed = 1;
    private boolean isLive = true;

    public boolean isLive() {
        return isLive;
    }

    public void setLive(boolean live) {
        isLive = live;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public TanKe(int x, int y, int direct) {
        this.x = x;//坦克的横坐标
        this.y = y;//坦克的纵坐标
        this.direct = direct;//坦克的方向
    }
    public void tank_Up(){
        y-=speed;
    }

    public void tank_Right(){
        x += speed;
    }
    public void tank_Down(){
        y += speed;
    }
    public void tank_Left(){
        x -= speed;
    }

    public int getX() {
        return x;
    }

    public int getDirect() {
        return direct;
    }

    public void setDirect(int direct) {
        this.direct = direct;
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
