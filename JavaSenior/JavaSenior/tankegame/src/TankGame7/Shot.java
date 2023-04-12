package TankGame7;

/**
 * @author muchen
 * @create 2022 - 10 - 2022/10/15 12:50
 */
public class Shot implements Runnable {
    private int x;      //子弹的横坐标
    private int y;      //子弹的纵坐标
    private int direct; //子弹的发射方向
    private int speed = 5;  //子弹射击速度

    private boolean isLive = true;

    public Shot(int x, int y, int direct) {
        this.x = x;
        this.y = y;
        this.direct = direct;
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

    public boolean isLive() {
        return isLive;
    }

    public void setLive(boolean live) {
        isLive = live;
    }

    public int getDirect() {
        return direct;
    }

    public void setDirect(int direct) {
        this.direct = direct;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    @Override
    public void run() {

        while (true) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            switch (getDirect()) {
                case 0:
                    setY(getY() - getSpeed());                    //0，1，2，3表示子弹发射方向 上右下左
                    break;
                case 1:
                    setX(getX() + getSpeed());
                    break;
                case 2:
                    setY(getY() + getSpeed());
                    break;
                case 3:
                    setX(getX() - getSpeed());
                    break;
            }
//            System.out.println("子弹横坐标："+getX() +"子弹纵坐标" + getY());
            if (!(getX() > 0 && getX() < 1000 && getY() > 0 && getY() < 750 && isLive)) {
                setLive(false);
//                System.out.println("子弹消失！");
                break;

            }
        }
    }
}
