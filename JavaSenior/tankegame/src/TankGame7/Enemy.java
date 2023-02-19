package TankGame7;

import java.util.Vector;

/**
 * @author muchen
 * @create 2022 - 09 - 2022/9/4 15:40
 */
@SuppressWarnings("all")
public class Enemy extends TanKe implements Runnable {
    private boolean isLive = true;
    Vector<Enemy> enemies = new Vector<>();//用来存放敌人的所有坦克，通过方法从mypanel中获取

    public void getEnemies(Vector<Enemy> enemies){//该方法用来获取所有敌人坦克
        this.enemies = enemies;
    }

    //编写一个方法 用来判断敌人坦克之间是否重叠，如果重叠返回true
    public boolean isTouch(){
        switch (this.getDirect()) {//判断当前坦克的方向
            case 0://当前坦克左上角坐标[x,y] 右上[x+40,y]
                for (int i = 0;i < enemies.size();i++){
                    Enemy enemyOther = enemies.get(i);
                    if (this != enemyOther) {
                        if (enemyOther.getDirect() == 0 || enemyOther.getDirect() == 2) {
                            //如果左上角坐标在敌人坦克内部
                            if (this.getX() >= enemyOther.getX()&&this.getX() <= enemyOther.getX()+40
                            &&this.getY() >= enemyOther.getY()&&this.getY() <= enemyOther.getY() + 60){
                                return true;
                            }
                            //如果右上角坐标在敌人坦克内部
                            if (this.getX()+40>=enemyOther.getX()&&this.getX()+40<=enemyOther.getX()+40
                                    &&this.getY() >= enemyOther.getY()&&this.getY() <= enemyOther.getY() + 60){
                                return true;
                            }
                        }else {
                            if (this.getX()>=enemyOther.getX()&&this.getX()<=enemyOther.getX()+60
                            &&this.getY()>= enemyOther.getY()&&this.getY()<=enemyOther.getY()+40){
                                return true;
                            }
                            if (this.getX()+40>=enemyOther.getX()&&this.getX()+40<=enemyOther.getX()+60
                                    &&this.getY()>= enemyOther.getY()&&this.getY()<=enemyOther.getY()+40){
                                return true;
                            }
                        }
                    }
                }
                break;
            case 1:
                for (int i = 0;i < enemies.size();i++){
                    Enemy enemyOther = enemies.get(i);
                    if (this != enemyOther) {
                        if (enemyOther.getDirect() == 0 || enemyOther.getDirect() == 2) {
                            //如果左上角坐标在敌人坦克内部
                            if (this.getX()+60>=enemyOther.getX()&&this.getX()+60<=enemyOther.getX()+40
                                    &&this.getY()>=enemyOther.getY()&&this.getY()<=enemyOther.getY() + 60){
                                return true;
                            }
                            //如果右上角坐标在敌人坦克内部
                            if (this.getX()+60>=enemyOther.getX()&&this.getX()+60<=enemyOther.getX()+40
                                    &&this.getY()+40>=enemyOther.getY()&&this.getY()+40<=enemyOther.getY()+60){
                                return true;
                            }
                        }else {
                            if (this.getX()+60>=enemyOther.getX()&&this.getX()+60<=enemyOther.getX()+60
                                    &&this.getY()>=enemyOther.getY()&&this.getY()<=enemyOther.getY() + 40){
                                return true;
                            }
                            //如果右下角坐标在敌人坦克内部
                            if (this.getX()+60>=enemyOther.getX()&&this.getX()+60<=enemyOther.getX()+60
                                    &&this.getY()+40>=enemyOther.getY()&&this.getY()+40<=enemyOther.getY()+40){
                                return true;
                            }
                        }
                    }
                }
                break;
            case 2:
                for (int i = 0;i < enemies.size();i++){
                    Enemy enemyOther = enemies.get(i);
                    if (this != enemyOther) {
                        if (enemyOther.getDirect() == 0 || enemyOther.getDirect() == 2) {
                            //如果左下角坐标在敌人坦克内部
                            if (this.getX()>=enemyOther.getX()&&this.getX()<=enemyOther.getX()+40
                                    &&this.getY()+60>=enemyOther.getY()&&this.getY()<=enemyOther.getY()+60){
                                return true;
                            }
                            //如果右下角坐标在敌人坦克内部
                            if (this.getX()+40>=enemyOther.getX()&&this.getX()+40<=enemyOther.getX()+40
                                    &&this.getY()+60>=enemyOther.getY()&&this.getY()+60<=enemyOther.getY()+60){
                                return true;
                            }
                        }else {
                            if (this.getX()>=enemyOther.getX()&&this.getX()<=enemyOther.getX()+60
                                    &&this.getY()+60>=enemyOther.getY()&&this.getY()<=enemyOther.getY()+40){
                                return true;
                            }
                            if (this.getX()+40>=enemyOther.getX()&&this.getX()+40<=enemyOther.getX()+60
                                    &&this.getY()+60>= enemyOther.getY()&&this.getY()+60<=enemyOther.getY()+40){
                                return true;
                            }
                        }
                    }
                }
                break;
            case 3:
                for (int i = 0;i < enemies.size();i++){
                    Enemy enemyOther = enemies.get(i);
                    if (this != enemyOther) {
                        if (enemyOther.getDirect() == 0 || enemyOther.getDirect() == 2) {
                            //如果左上角坐标在敌人坦克内部
                            if (this.getX()>=enemyOther.getX()&&this.getX() <= enemyOther.getX()+40
                                    &&this.getY() >= enemyOther.getY()&&this.getY() <= enemyOther.getY() + 60){
                                return true;
                            }
                            //如果右上角坐标在敌人坦克内部
                            if (this.getX()>=enemyOther.getX()&&this.getX()<=enemyOther.getX()+40
                                    &&this.getY()+40>= enemyOther.getY()&&this.getY()+40<=enemyOther.getY() + 60){
                                return true;
                            }
                        }else {
                            if (this.getX()>=enemyOther.getX()&&this.getX() <= enemyOther.getX()+60
                                    &&this.getY() >= enemyOther.getY()&&this.getY() <= enemyOther.getY() + 40){
                                return true;
                            }
                            if (this.getX()>=enemyOther.getX()&&this.getX()<=enemyOther.getX()+60
                                    &&this.getY()+40>= enemyOther.getY()&&this.getY()+40<=enemyOther.getY() + 40){
                                return true;
                            }
                        }
                    }
                }
                break;

        }
        return false;
    }

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
            //判断的集合如果为空，则新创建一颗方向与坦克方向一致的子弹继续发射
            if (isLive && vector.size() <= 5){
                Shot shot = null;
                switch (this.getDirect()){
                    case 0:
                        shot = new Shot(getX() + 20,getY(),0);
                        break;
                    case 1:
                        shot = new Shot(getX() + 60,getY() + 20,1);
                        break;
                    case 2:
                        shot = new Shot(getX() + 20,getY() + 60,2);
                        break;
                    case 3:
                        shot = new Shot(getX(),getY() + 20,3);
                        break;
                }
                vector.add(shot);
                new Thread(shot).start();
            }


            //让坦克按照原来的方向运动一段时间
            switch (getDirect()){
                case 0:
                    for (int i = 35;i >= 0 ;i--) {
                        if (this.getY() > 0 && !isTouch()) {
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
                        if(this.getX() + 60 < 1000 && !isTouch()) {
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
                        if(this.getY() + 60 < 750 && !isTouch()) {
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
                        if (this.getX() > 0 && !isTouch()) {
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
