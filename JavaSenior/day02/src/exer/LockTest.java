package exer;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 解决线程安全问题方式三：
 * lock锁
 *
 * 1.面试题：
 * synchronized和lock的异同；
 *  相同：二者都可以解决线程安全问题
 *  不同：synchronized机制在执行完相应的同步代码块之后，自动的释放同步监视器
 *        Lock则需要手动的启动（lock()）和手动的释放（unlock()）
 * @author muchen
 * @create 2022 - 08 - 2022/8/24 19:16
 */
public class LockTest {
    public static void main(String[] args) {
        Windows w1 = new Windows();

        Thread t1 = new Thread(w1);
        Thread t2 = new Thread(w1);
        Thread t3 = new Thread(w1);

        t1.start();
        t2.start();
        t3.start();
    }
}

class Windows implements Runnable {
    private int stack = 100;

    Object obj = new Object();
    private ReentrantLock lock = new ReentrantLock();

    // obj 即为解决该线程安全问题的锁
    @Override
    public void run() {
        while (true) {

            //在实现Runnable接口创建多线程的方式中，我们可以考虑使用this来充当同步监视器。因为该this指的是同一个实例化对象
            try {
                lock.lock();
                //调用lock方法
                if (stack > 0) {
                    //让线程执行到这个地方强制睡眠100毫秒，会增加线程同步的概率 出错概率增大！
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    System.out.println(Thread.currentThread().getName() + "出售：" + stack);
                    stack--;
                } else {
                    break;
                }
            }finally {
//                System.out.println("准备解锁");
                lock.unlock();
            }
        }
    }
}