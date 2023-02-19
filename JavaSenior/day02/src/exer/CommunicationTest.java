package exer;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author muchen
 * @create 2022 - 08 - 2022/8/31 19:05
 *
 * 线程通信的例子：使用两个线程打印 1-100，线程1，线程2 交替打印
 *
 * 涉及到三个方法
 * wait():一旦执行此方法，当前线程就会进入阻塞状态，并释放同步监视器
 * notify():一旦执行此方法，还会唤醒wait的一个线程，如果有多个线程被wait，则唤醒优先级高的线程
 * notifyAll():一旦执行此方法，会唤醒所有线程
 *
 * wait(),notify(),notifyAll()三个方法必须调用在同步代码块或同步方法中；不能使用在
 *
 */
public class    CommunicationTest {
    public static void main(String[] args) {
        Number n1 = new Number();

        Thread t1 = new Thread(n1);
        Thread t2 = new Thread(n1);

        t1.start();
        t2.start();

    }
}
class Number implements Runnable{
    private int num = 100;
    ReentrantLock lock = new ReentrantLock();

    Object obj = new Object();
    public void run() {

        while (true){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

//            obj.notify();
//            try {
//                lock.lock();
            synchronized (this) {
                notify();
                if (num > 0) {
                    System.out.println(Thread.currentThread().getName() + ":" + +num);
                    num--;
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                } else {
                    break;
                }

//            }
//            }finally {
//                lock.unlock();
            }
        }
    }
}
