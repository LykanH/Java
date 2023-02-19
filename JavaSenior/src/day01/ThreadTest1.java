package day01;

/**
 * 线程：新建、就绪、运行、阻塞、死亡
 * 创建多线程的方式二：实现Runnable接口
 * 1、创建一个实现了Runnable接口的类
 * 2、实现类去实现Runnable中的抽象方法：run()
 * 3、创建实现类的对象
 * 4、将此对象作为参数传递到Thread类的构造器中，创建Thread类的对象
 * 5、通过Thread类的对象调用start()
 *
 * 例题：创建多线程遍历100以内的偶数
 *
 * 比较创建线程的两种方式
 * 开发中：优先选择：实现Runnable接口的方式
 * 原因：1.实现的方式没有类的但继承性的局限性
 *      2.实现的方式更适合来处理多个线程有共享数据的情况。
 *
 * 相同点：两种方式都需要重写run()，将线程要执行的逻辑声明在run()中。
 *
 * @author muchen
 * @create 2022 - 08 - 2022/8/22 13:48
 */

 // 1、创建一个实现了Runnable接口的类
class Mythread1 implements Runnable{
    @Override
// * 2、实现类去实现Runnable中的抽象方法：run()
    public void run() {
        for (int i = 0; i < 100; i++) {
            if(i % 2 == 0){
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}

public class ThreadTest1 {
    public static void main(String[] args) {
//        3、创建实现类的对象
        Mythread1 m1 = new Mythread1();
//        new Thread(m1).start();

//        4、将此对象作为参数传递到Thread类的构造器中，创建Thread类的对象
        Thread t1 = new Thread(m1);
        t1.setName("线程1");
//        5、通过Thread类的对象调用start()
        t1.start();

//      该方法创建更多线程不需要在创建实现类的对象  只需要共用一个实现类对象即可
        Thread t2 = new Thread(m1);
        t2.setName("线程2");
        t2.start();
    }
}
