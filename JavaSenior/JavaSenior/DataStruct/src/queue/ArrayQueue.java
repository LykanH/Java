//package queue;
//
//import java.util.Scanner;
//
///**
// * @author muchen
// * @create 2022 - 10 - 2022/10/22 14:30
// * <p>
// *     普通队列（非循环队列）
// * 线性结构中队列的代码实现...
// * 通过数组实现
// */
//public class ArrayQueue {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("输入你想创建队列的大小：");
//        int i = scanner.nextInt();
//        Queue queue = new Queue(i);
//
//        while (true) {
//            System.out.println("输入“1”插入元素\n输入“2”移除元素\n输入“3”显示队列中所有元素:");
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
//                    System.out.println("输入有误，重新输入！");
//            }
//        }
//    }
//}
//
//class Queue {
//    private int front;      //队列头
//    private int rear;       //队列尾
//    private int maxSize;    //队列最大容量
//    private int[] queue;
//
//    public Queue(int maxSize) {
//        this.maxSize = maxSize;
//        queue = new int[maxSize];
//        front = -1;    //指向队列头部，front是指向队列头部的前一个位置
//        rear = -1;      //指向队列尾部的数据
//    }
//
//    public boolean isFull() {
//        //判断队满
//        return rear == maxSize - 1; //返回true则代表队满
//    }
//
//    public boolean isEmpt() {
//        return front == rear;   //返回true则代表队空
//    }
//
//    public void inQueue(int a) {
//        if (isFull()) {
//            System.out.println("队列已满！");
//            return;
//        }
//        queue[++rear] = a;
//    }
//
//    public int outQueue() {
//        if (isEmpt()) {
//            throw new RuntimeException("队列为空");
//        }
//        return queue[++front];
//    }
//
//    public void printQueue() {
//        //显示队列所有数据
//        if (isEmpt()) {
//            System.out.println("队列为空！");
//            return;
//        }
//        System.out.println("front = " + front + "rear = " + rear);
//        for (int i = front + 1; i <= rear; i++) {
//            System.out.printf("%d\t", queue[i]);
//        }
//    }
//}
