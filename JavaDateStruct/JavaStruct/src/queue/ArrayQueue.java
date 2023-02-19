//package queue;
//
//import java.util.Scanner;
//
///**
// * @author muchen
// * @create 2022 - 10 - 2022/10/22 14:30
// * <p>
// *     鏅�氶槦鍒楋紙闈炲惊鐜槦鍒楋級
// * 绾挎�х粨鏋勪腑闃熷垪鐨勪唬鐮佸疄鐜�...
// * 閫氳繃鏁扮粍瀹炵幇
// */
//public class ArrayQueue {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("杈撳叆浣犳兂鍒涘缓闃熷垪鐨勫ぇ灏忥細");
//        int i = scanner.nextInt();
//        Queue queue = new Queue(i);
//
//        while (true) {
//            System.out.println("杈撳叆鈥�1鈥濇彃鍏ュ厓绱燶n杈撳叆鈥�2鈥濈Щ闄ゅ厓绱燶n杈撳叆鈥�3鈥濇樉绀洪槦鍒椾腑鎵�鏈夊厓绱�:");
//            int a = scanner.nextInt();
//            switch (a) {
//                case 1:
//                    queue.inQueue(5);
//                    break;
//                case 2:
//                    queue.outQueue();
//                    break;
//                case 3:
//                    queue.printQueue();
//                    break;
//                default:
//                    System.out.println("杈撳叆鏈夎锛岄噸鏂拌緭鍏ワ紒");
//            }
//        }
//    }
//}
//
//class Queue {
//    private int front;      //闃熷垪澶�
//    private int rear;       //闃熷垪灏�
//    private int maxSize;    //闃熷垪鏈�澶у閲�
//    private int[] queue;
//
//    public Queue(int maxSize) {
//        this.maxSize = maxSize;
//        queue = new int[maxSize];
//        front = -1;    //鎸囧悜闃熷垪澶撮儴锛宖ront鏄寚鍚戦槦鍒楀ご閮ㄧ殑鍓嶄竴涓綅缃�
//        rear = -1;      //鎸囧悜闃熷垪灏鹃儴鐨勬暟鎹�
//    }
//
//    public boolean isFull() {
//        //鍒ゆ柇闃熸弧
//        return rear == maxSize - 1; //杩斿洖true鍒欎唬琛ㄩ槦婊�
//    }
//
//    public boolean isEmpt() {
//        return front == rear;   //杩斿洖true鍒欎唬琛ㄩ槦绌�
//    }
//
//    public void inQueue(int a) {
//        if (isFull()) {
//            System.out.println("闃熷垪宸叉弧锛�");
//            return;
//        }
//        queue[++rear] = a;
//    }
//
//    public int outQueue() {
//        if (isEmpt()) {
//            throw new RuntimeException("闃熷垪涓虹┖");
//        }
//        return queue[++front];
//    }
//
//    public void printQueue() {
//        //鏄剧ず闃熷垪鎵�鏈夋暟鎹�
//        if (isEmpt()) {
//            System.out.println("闃熷垪涓虹┖锛�");
//            return;
//        }
//        System.out.println("front = " + front + "rear = " + rear);
//        for (int i = front + 1; i <= rear; i++) {
//            System.out.printf("%d\t", queue[i]);
//        }
//    }
//}
