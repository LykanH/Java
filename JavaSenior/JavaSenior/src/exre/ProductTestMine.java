package exre;

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
public class ProductTestMine {
    public static void main(String[] args) {
        clerk clerk = new clerk();
        productor p1 = new productor(clerk);
        customer c1 = new customer(clerk);

        Thread t1 = new Thread(p1);
        Thread t3 = new Thread(p1);
        Thread t2 = new Thread(c1);

        t1.setName("生产者1");
        t3.setName("生产者2");
        t2.setName("消费者1");

        t1.start();
        t2.start();
        t3.start();
    }
}
class clerk{
    private int num = 0;
    public synchronized void procuct() {     //生产产品

        if (num < 20){
            num++;
            this.notify();
            System.out.println(Thread.currentThread().getName() + "正在生产第" + num + "个产品");
        }else {
            try {
                this.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public synchronized void custom() {      //消费产品
        try {
            Thread.sleep(0);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if (num > 0){
            System.out.println(Thread.currentThread().getName() + "正在消费第" + num + "个产品");
            num--;
            this.notify();
        }else {
            try {
                this.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
//生产者(Productor)将产品交给店员(CLerk)，而消费者(Customer)从店员处取走产品。
class productor implements Runnable{
    clerk c1;
    public productor(clerk clerk){
        c1 = clerk;
    }

    @Override
    public void run() {
        while (true) {
            c1.procuct();
        }
    }
}
class customer implements Runnable{
    clerk c2;
    public customer(clerk clerk){
        c2 = clerk;
    }

    @Override
    public void run() {
        while (true) {
            c2.custom();
        }
    }
}