package TankGame7;

import java.util.Vector;

/**
 * @author muchen
 * @create 2022 - 09 - 2022/9/2 22:18
 */
public class Hero extends TanKe {
    Shot shot = null;

    private boolean isLive = true;
    //创建一个集合 存放我方坦克的子弹
    Vector<Shot> heroShots = new Vector<>();

    public Hero(int x, int y, int direct) {
        super(x, y, direct);
    }

    public boolean isLive() {
        return isLive;
    }

    public void setLive(boolean live) {
        isLive = live;
    }



    public void shotEnemyTank(){
        switch (getDirect()){
            case 0:
                shot = new Shot(this.getX() + 20,this.getY(),getDirect());
                heroShots.add(shot);
                break;
            case 1:
                shot = new Shot(this.getX() + 60,this.getY() + 20,getDirect());
                heroShots.add(shot);
                break;
            case 2:
                shot = new Shot(this.getX() + 20,this.getY() + 60,getDirect());
                heroShots.add(shot);
                break;
            case 3:
                shot = new Shot(this.getX() ,this.getY() + 20,getDirect());
                heroShots.add(shot);
                break;
        }

        new Thread(shot).start();
    }
}
