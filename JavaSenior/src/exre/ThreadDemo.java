/**
 * 练习：创建两个分线程，其中一个线程遍历100以内的偶数，另一个线程遍历100以内的奇数
 * @author muchen
 * @create 2022 - 08 - 2022/8/21 10:52
 *
 */
package exre;

//使用Thread继承法
//class Thread01 extends Thread{
//    @Override
//    public void run() {
//        for (int i = 0; i < 100; i++) {
//            if (i % 2 == 0){
//                System.out.println(i + "偶数");
//            }
//        }
//    }
//}
//class thread02 extends Thread{
//    @Override
//    public void run() {
//        for (int i = 0; i < 100; i++) {
//            if (i % 2 != 0) {
//                System.out.println(i + "奇数");
//            }
//        }
//    }
//}

public class ThreadDemo {
    public static void main(String[] args) {
//        Thread01 t1 = new Thread01();
//        t1.start();
//        thread02 t2 = new thread02();
//        t2.start();

//        使用匿名子类方法  因为该对象被创建出来只使用了一次  可以使用匿名子类
        new Thread(){
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    if (i % 2 == 0){
                        System.out.println(i + "偶数");
                    }
                }
            }
        }.start();
        new Thread(){
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    if (i % 2 != 0){
                        System.out.println(i + "奇数");
                    }
                }
            }
        }.start();
    }

}
