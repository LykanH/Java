package exer;

import java.util.concurrent.locks.ReentrantLock;

/**
 * ctrl + alt + t   //快捷键
 *
 * 联习：银行有一个账户。
 * 有两个储户分别向同一个账户存3000元，每次存1000，存3次。每次存完打印账户余额！
 *
 * @author muchen
 * @create 2022 - 08 - 2022/8/26 16:37
 */
public class AccountTest {
    public static void main(String[] args) {
        InCash account = new InCash();

        Thread t1 = new Thread(account);
        Thread t2 = new Thread(account);

        t1.setName("储户1");
        t2.setName("储户2");

        t1.start();
        t2.start();
    }

}

class InCash implements Runnable {
    //使用lock解决线程安全问题
    private ReentrantLock lock = new ReentrantLock();
    private static int cash = 0;

    @Override
    public void run() {
        try {
            lock.lock();
            for (int i = 0; i < 3; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                cash += 1000;
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
                System.out.println(Thread.currentThread().getName() + "存入1000元，现在余额为：" + cash);

            }
        } finally {
            lock.unlock();
        }

    }
}
