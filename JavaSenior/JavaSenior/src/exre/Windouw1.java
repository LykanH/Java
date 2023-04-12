package exre;

/**
 * @author muchen
 * @create 2022 - 08 - 2022/8/22 14:23
 *
 * 实现Runnable接口的方法创建多线程
 * 例题：三个窗口同时卖出100张票
 *
 * 解决线程安全问题：
 * 方式一：同步代码块
 * synchronized(同步监视器){
 *      //需要被同步的代码
 * }
 *
 * 说明：
 *      1.操作共享数据的代码，即为需要被同步的代码
 *      2.共享数据，多个线程共同操作的变量。比如stack 就是共享数据
 *      3.同步监视器，俗称：锁，任何一个类的对象，都可以充当锁。
 *          要求：多个线程必须共用一把锁
 *
 * 方式二：同步方法
 *      4.同步的方式解决了线程安全问题 ————好处
 *      5.操作同步代码块时，只有一个线程参与，其他线程等待。相当于是一个单线程的过程，效率低。
 */
class Windows1 implements Runnable{
    private int stack = 100;

    Object obj = new Object();
    // obj 即为解决该线程安全问题的锁
    @Override
    public void run() {
            while (true) {
                //在实现Runnable接口创建多线程的方式中，我们可以考虑使用this来充当同步监视器。因为该this指的是同一个实例化对象
                synchronized (obj) {
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
                }

        }
    }
}


public class Windouw1 {
    public static void main(String[] args) {
        //使用此方法不需要将线程中公用Windows1中的属性改为static

        Windows1 w1 = new Windows1();

        Thread t1 = new Thread(w1);
        Thread t2 = new Thread(w1);
        Thread t3 = new Thread(w1);

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }
}
