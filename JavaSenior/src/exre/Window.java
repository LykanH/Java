package exre;

/**
 * @author muchen
 * @create 2022 - 08 - 2022/8/22 13:21
 * 例子：创建三个窗口买票，总票数为100张
 */
class windows extends Thread{
    private static int stick = 100;

    private static Object obj = new Object();
    @Override
    public void run() {
        while (true) {
            synchronized (obj) {

                try {
                    sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                if (stick > 0) {
                    System.out.println(getName() + "买票:" + stick);
                    stick--;
                } else {
                    break;
                }
            }
        }
    }
}

public class Window {
    public static void main(String[] args) {
        windows w1 = new windows();
        windows w2 = new windows();
        windows w3 = new windows();
        w1.setName("窗口1");
        w2.setName("窗口2");

        w3.setName("窗口3");
        w1.start();
        w2.start();
        w3.start();
    }
}
