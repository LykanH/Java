package queue;

import java.util.Scanner;

/**
 * @author muchen
 * @create 2022 - 10 - 2022/10/22 14:30
 * <p>
 * 寰幆闃熷垪
 * 绾挎�х粨鏋勪腑闃熷垪鐨勪唬鐮佸疄鐜�...
 * 閫氳繃鏁扮粍瀹炵幇
 */
public class ArrayQueue_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("杈撳叆浣犳兂鍒涘缓闃熷垪鐨勫ぇ灏忥細");
        int i = scanner.nextInt();
        Queue queue = new Queue(i);

        while (true) {
            System.out.println("*****************");
            System.out.println("杈撳叆鈥�1鈥濇彃鍏ュ厓绱燶n杈撳叆鈥�2鈥濈Щ闄ゅ厓绱燶n杈撳叆鈥�3鈥濇樉绀洪槦鍒椾腑鎵�鏈夊厓绱燶n" +
                    "杈撳叆鈥�4鈥濊緭鍑洪槦棣栧厓绱燶n杈撳叆鈥�5鈥濊緭鍑洪槦鍒椾腑鍏冪礌涓暟:");
            int a = scanner.nextInt();
            switch (a) {
                case 1:
                    queue.inQueue(5);
                    break;
                case 2:
                    queue.outQueue();
                    break;
                case 3:
                    queue.printQueue();
                    break;
                case 4:
                    queue.printFirstNum();
                    break;
                case 5:
                    System.out.printf("鍏冪礌涓暟涓猴細%d", queue.printfNum());
                    break;
                default:
                    System.out.println("杈撳叆鏈夎锛岄噸鏂拌緭鍏ワ紒");
            }
        }
    }
}

class Queue {
    private int front;      //闃熷垪澶�
    private int rear;       //闃熷垪灏�
    private int maxSize;    //闃熷垪鏈�澶у閲�
    private int[] queue;

    public Queue(int maxSize) {
        this.maxSize = maxSize;
        queue = new int[maxSize];
        front = 0;    //鎸囧悜闃熷垪澶撮儴锛宖ront鏄寚鍚戦槦鍒楀ご閮ㄦ暟鎹�
        rear = 0;      //鎸囧悜闃熷垪灏鹃儴鐨勬暟鎹殑鍚庝竴涓綅缃�
    }

    public boolean isFull() {
        //鍒ゆ柇闃熸弧
        return (rear + 1) % maxSize == front; //杩斿洖true鍒欎唬琛ㄩ槦婊�
    }

    public boolean isEmpt() {
        return front == rear;   //杩斿洖true鍒欎唬琛ㄩ槦绌�
    }

    public void inQueue(int a) {
        if (isFull()) {
            System.out.println("闃熷垪宸叉弧锛�");
            return;
        }
        queue[rear] = a;
        rear = (rear + 1) % maxSize;
//        rear = rear % (maxSize - 1);
//        queue[rear++] = a;
    }

    public int outQueue() {
        if (isEmpt()) {
            throw new RuntimeException("闃熷垪涓虹┖");
        }
//        front = (front % (maxSize - 1));
//        front++;
//        return queue[front];
        int value = queue[front];
        front = (front + 1) % maxSize;          //鍥犱负鍙湁rear鍚庤竟鎵嶇┖涓�浣嶄綔涓烘爣璇嗭紝front鍚庡苟涓嶇┖鏍�
        return value;
    }

    public void printQueue() {
        //鏄剧ず闃熷垪鎵�鏈夋暟鎹�
        if (isEmpt()) {
            System.out.println("闃熷垪涓虹┖锛�");
            return;
        }
        System.out.println("front = " + front + "rear = " + rear);
        for (int i = front; i < front + printfNum(); i++) {
            System.out.printf("arr[%d] = %d\t", i % maxSize, queue[i % maxSize]);
        }
    }

    public void printFirstNum() {
        //杈撳嚭闃熷垪涓涓�涓暟鎹�
        if (isEmpt()) {
            System.out.println("闃熷垪涓虹┖锛�");
            return;
        }
        System.out.println("绗竴涓厓绱狅細" + queue[front]);
    }

    public int printfNum() {
        //杈撳嚭闃熷垪涓湁澶氬皯涓厓绱�
//        if (isEmpt()) {
//            System.out.println("闃熷垪涓虹┖");
//            return;
//        }
//        System.out.println("闃熷垪涓厓绱犱釜鏁颁负锛�" + (rear + maxSize - front) % maxSize);
        return (rear + maxSize - front) % maxSize;
    }
}
