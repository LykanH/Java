package TankGame03;

/**
 * @author muchen
 * @create 2022 - 09 - 2022/9/2 22:18
 */
public class Hero extends TanKe {
    Shot shot = null;
    public Hero(int x, int y, int direct) {
        super(x, y, direct);
    }

    public void shotEnemyTank(){
        switch (getDirect()){
            case 0:
                shot = new Shot(this.getX() + 20,this.getY(),getDirect());
                break;
            case 1:
                shot = new Shot(this.getX() + 60,this.getY() + 20,getDirect());
                break;
            case 2:
                shot = new Shot(this.getX() + 20,this.getY() + 60,getDirect());
                break;
            case 3:
                shot = new Shot(this.getX() ,this.getY() + 20,getDirect());
                break;
        }

        new Thread(shot).start();
    }
}
