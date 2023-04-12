package exer;

/**
 * 多线程练习二：
 * 有两个用户分别从同一个卡里取钱（总额：10000）
 * 每次都取出1000，当余额不足时就不能取了
 * 不能出现超取现象 ————> 线程同步问题。
 * <p>
 * alt + shift + D   //运行
 *
 * @author muchen
 * @create 2022 - 09 - 2022/9/1 22:41
 */
public class HomeWork2 {
    public static void main(String[] args) {
        draw d1 = new draw();

        new Thread(d1).start();
        new Thread(d1).start();

    }
}

class draw implements Runnable {
    bankCount b1 = new bankCount(10000);
    boolean flag = true;

    @Override
    public void run() {
        while (flag) {

            synchronized (this) {
                if (b1.getBalance() > 0) {
                    b1.setBalance(b1.getBalance() - 1000);
                    System.out.println(Thread.currentThread().getName() + "取出1000，当前账户余额为:" + b1.getBalance());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                } else {
                    System.out.println("余额为零，取钱结束");
                    break;
                }
            }
        }
    }
}

class bankCount {
    private int balance;

    public bankCount(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}