package TankGame7;

/**
 * @author muchen
 * @create 2022 - 11 - 2022/11/22 0:14
 *
 * 炸弹爆炸效果
 */
public class Bomb {
    private int x;
    private int y;
    int life = 9;
    boolean isLive = true;//炸弹是否还存活，为了保证其只能出现一次爆炸

    public Bomb(int x, int y) {
        this.x = x;
        this.y = y;
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

    public void downLife(){
        if (life > 0){
            life--;
        }else {
            isLive = false;
        }
    }
}
