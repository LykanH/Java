package exer;

import java.util.Scanner;

/**
 * 在main方法中启动两个线程
 *      在第一个线程中循环随机打印100以内的整数
 *      知道第二个线程从键盘读取了“Q”命令
 *
 * @author muchen
 * @create 2022 - 08 - 2022/8/31 23:05
 */
public class HomeWork1 {
    public static void main(String[] args) {
        A a = new A();
        B b = new B(a);

        Thread t1 = new Thread(b);
        a.start();
        t1.start();
    }
}
class A extends Thread{
    private boolean flag = true;

    public void setFlag(boolean bool){
        flag = bool;
    }

    @Override
    public void run() {
        System.out.println("线程1开始打印随机数");
        while (flag){
            System.out.println((int)(Math.random()*100 + 1));

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("线程1结束执行");
    }
}

class B implements Runnable{
    public A a1 ;

    public B(A a){
        a1 = a;
    }
    Scanner scan = new Scanner(System.in);
    @Override
    public void run() {
        char stop = scan.next().toUpperCase().charAt(0);
        if (stop == 'Q'){
            a1.setFlag(false);
            System.out.println("线程2停止运行");
            return;
        }
    }
}










//思路错误！

//    public static void main(String[] args) {
//        Rand r1 = new Rand();
//        Thread t1 = new Thread(r1);
//        Thread t2 = new Thread(r1);
////        Thread t3 = new Thread(r1);
//
//        t1.setName("xiancheng1");
//        t2.setName("xiancheng2");
//
//        t1.start();
//        t2.start();
////        t3.start();
//    }
//}
//
//class Rand implements Runnable {
//    Random r1 = new Random();
//    int i = 0;
//    public static Object obj = new Object();
//    private boolean flag = true;
//    private char c;
//
//    @Override
//
//    public void run() {
//        while (flag) {
//
////            if (Thread.currentThread().getName() == "xiancheng1") {
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//            synchronized (this) {
////                    this.notify();
//                System.out.println(Thread.currentThread().getName() + ":" + r1.nextInt(100));
//                i++;
//
//                if (i >= 100) {
//                    break;
//                } else {
////                        this.notify();
//                    try {
//                        c = (char) System.in.read();
//                    } catch (IOException e) {
//                        throw new RuntimeException(e);
//                    }
//                    if (c == 'Q') {
//                        flag = false;
//                    }
////                        try {
////                            this.wait();
////                        } catch (InterruptedException e) {
////                            throw new RuntimeException(e);
////                        }
//                }
//            }
//        }
//    }
//}
//
