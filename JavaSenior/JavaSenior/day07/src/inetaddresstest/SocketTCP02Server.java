package inetaddresstest;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author muchen
 * @create 2022 - 12 - 2022/12/4 10:20
 * TCP编程案例二：（使用字符流）
 * 1.编写一个客户端和服务端
 * 2.服务端在9999端口监听
 * 3.客户端链接到服务器端并发送hello,server,并接收服务器端回发的hello,client再退出
 * 4.服务端接收到客户端发送的信息，输出并发送hello,client，在退出
 */
public class SocketTCP02Server {
    public static void main(String[] args) throws IOException {
        //服务器端
        ServerSocket serverSocket = new ServerSocket(9999);
        Socket socket = serverSocket.accept();
        System.out.println("连接建立成功！");
        //创建流，开始传输数据(因为需要使用字符流，则需使用到转换流！)
        InputStream is = socket.getInputStream();
        OutputStream os = socket.getOutputStream();
        InputStreamReader isr = new InputStreamReader(is,"UTF-8");
        OutputStreamWriter osw = new OutputStreamWriter(os,"UTF-8");
        //输入流，接收客户端发送的数据
        int read;
        char[] chars = new char[1024];
        while ((read = isr.read(chars)) != -1){
            System.out.println(new String(chars,0,read));
        }
        //输出流，给客户端传送数据
        osw.write("hello,client".toCharArray());
        osw.flush();//写入数据时，必须手动刷新，不然不会写入输出通道
        socket.shutdownOutput();

        socket.close();
        isr.close();
        osw.close();
        serverSocket.close();
    }
}
