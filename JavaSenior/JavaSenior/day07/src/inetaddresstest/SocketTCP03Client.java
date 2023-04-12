package inetaddresstest;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author muchen
 * @create 2022 - 12 - 2022/12/4 11:05
 *
 * 03任务：
 * 1.编写一个客户端，和一个服务端
 * 2.服务器端在9999端口监听
 * 3.客户端连接到服务器，发送一张图片 e:\\qie.png
 * 4.服务器接收到客户端发送的图片，保存到src下，发送”收到图片“再退出
 * 5.客户端收到服务端发送的“收到图片”在退出
 *
 *
 * dos控制台下执行：
 * netstat -an 可以查看当前主机网络情况，包括网络监听情况和网络连接情况！
 * netstat -anb 可以显示具体哪个程序在监听端口
 */
public class SocketTCP03Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(),9999);
        System.out.println("成功建立连接！");
        File file = new File("TCP1.png");
//        System.out.println(file.getAbsolutePath());
        //读取文件中的数据
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
        //获得套接字的字节流，通过字节流传输图片数据
        OutputStream os = socket.getOutputStream();
        BufferedOutputStream bos = new BufferedOutputStream(os);
        int read;
        byte[] bytes = new byte[1024];
        while ((read = bis.read(bytes))!=-1){
            bos.write(bytes);
            bos.flush();
        }
        socket.shutdownOutput();//停止本次输出

        InputStream is = socket.getInputStream();
//        int read1;
        while ((read = is.read(bytes))!=-1){
            System.out.println(new String(bytes,0,read));

        }
        //关闭流
        is.close();
        bos.close();
        bis.close();
        socket.close();
    }
}
