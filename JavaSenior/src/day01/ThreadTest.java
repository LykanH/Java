package day01;

/**
 * @author muchen
 * @create 2022 - 08 - 2022/8/20 21:35
 */
/*
多线程的创建，方式一：继承Thread类
1.创建一个继承于Thread类的子类
2.重写Thread类中的run()  即：将此线程执行的操作声明在run()中
3.创建Thread类子类的对象
4.通过子类调用start()
 */



//创建一个类继承于Thread；
class Mythread extends Thread{
//    重写该类中的run方法
    public void run() {
        for (int i = 0; i < 10000; i++) {
            if(i % 2 == 0){
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}


public class ThreadTest {
    public static void main(String[] args) {
//        在主类的main方法中实例化该类，即创建Thread类的子类对象
        Mythread t1 = new Mythread();
//         通过此对象调用start()
        t1.start();
//        t1.run();    //不能用创建的子类对象直接调用run()方法
        //如果想再次执行一遍遍历10000以内偶数的线程，不可以让已经start()的线程去执行，会报错误
        //而可以重新new一个实例化对象，重新调用start；
//        t1.start();
        Mythread t2 = new Mythread();
        t2.start();
        System.out.println("hello");
        for (int i = 0; i < 10000; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName()+ ":" + i + "main()");
            }
        }
    }
}
//运行结果体现出两个线程的交互性