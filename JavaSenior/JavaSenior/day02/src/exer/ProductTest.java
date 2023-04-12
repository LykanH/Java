package exer;

/**
 * 线程通信的应用:经典例题:生产者/消费者问题
 * 生产者(Productor)将产品交给店员(CLerk)，而消费者(Customer)从店员处取走产品。
 * 店员一次只能持有固定数量的产品(比如:20)，如果生产者试图生产更多的产品，店员
 * 会叫生产者停一下，如果店中有空位放产品了再通知生产者继续生产；如果店中没有产品了，
 * 店员会告诉消费者等一下，如果店中有产品了再通知消费者来取走产品。
 *
 *
 * 分析： 1．是否是多线程问题﹖是，生产者线程，消费者线程
 * 2．是否有共享数据?是，店员(或产品）
 * 3.如何解决线程的安全问题？同步机制，有三种方法
 * 4.是否涉及线程的通信?是
 *
 *
 * @author muchen
 * @create 2022 - 09 - 2022/9/7 16:37
 */
class Clerk{
    private int proNum = 0;
    public synchronized void product(){
        if (proNum < 20){
            proNum ++;
            notify();
            System.out.println(Thread.currentThread().getName() + "开始生产第" + proNum + "个产品");
        }else {
            try {
                this.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public synchronized void consum() {
        if (proNum > 0) {
            System.out.println(Thread.currentThread().getName() + "开始取走第" + proNum + "个产品");
            proNum--;
            notify();
        }else {
            try {
                this.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
class Productor implements Runnable{
    Clerk c1;
    public Productor(Clerk clerk){
        c1 = clerk;
    }
    @Override
    public void run() {
        System.out.println("生产者开始生产...");
        while (true) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            c1.product();
        }
    }
}
class Customer implements Runnable{
    Clerk c1;
    public Customer(Clerk clerk){
        c1 = clerk;
    }
    @Override
    public void run() {
        System.out.println("消费者开始消费...");
        while (true) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            c1.consum();
        }
    }
}
public class ProductTest {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        Productor p1 = new Productor(clerk);
        Customer c1 = new Customer(clerk);

        Thread t1 = new Thread(p1);
        Thread t2 = new Thread(c1);


        t1.setName("生产者");
        t2.setName("消费者");

        t1.start();
        t2.start();
    }
}
