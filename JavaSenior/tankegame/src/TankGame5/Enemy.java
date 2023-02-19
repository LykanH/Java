package TankGame5;

import java.util.Vector;

/**
 * @author muchen
 * @create 2022 - 09 - 2022/9/4 15:40
 */
public class Enemy extends TanKe implements Runnable {
    private boolean isLive = true;

    public boolean isLive() {
        return isLive;
    }

    public void setLive(boolean live) {
        isLive = live;
    }

    Vector<Shot> vector = new Vector<>();       //该集合中存放敌人坦克的子弹
    public Enemy(int x, int y, int direct) {
        super(x, y, direct);
    }

    @Override
    public void run() {
        while(true){
            //让坦克按照原来的方向运动一段时间
            switch (getDirect()){
                case 0:
                    for (int i = 35;i >= 0 ;i--) {
                        if (this.getY() > 0) {
                            this.tank_Up();

                            try {
                                Thread.sleep(50);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        }else {break;}
                    }
                    break;
                case 1:
                    for (int i = 35;i >= 0 ;i--) {
                        if(this.getX() + 60 < 1000) {
                            this.tank_Right();
                            try {
                                Thread.sleep(50);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        }else break;
                    }

                    break;
                case 2:
                    for (int i = 35;i >= 0 ;i--) {
                        if(this.getY() + 60 < 750) {
                            this.tank_Down();
                            try {
                                Thread.sleep(50);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        }else break;
                    }
                    break;
                case 3:
                    for (int i = 35;i >= 0 ;i--) {
                        if (this.getX() > 0) {
                            this.tank_Left();
                            try {
                                Thread.sleep(50);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        }else break;
                    }
                    break;
            }

            setDirect( (int) (Math.random()*4) );
            if (this.isLive()==false){
                break;
            }
        }
    }
}
