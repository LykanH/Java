package TankGame7;

/**
 * @author muchen
 * @create 2022 - 11 - 2022/11/28 20:50
 *
 * 将存入磁盘中的数据导入出来存放在node中、体现面向对象的编程思想
 */
public class Node {
    private int x;//存放坦克x坐标
    private int y;//存放坦克y坐标
    private int direction;//存放坦克方向

    public Node(int x, int y, int direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
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

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }
}
