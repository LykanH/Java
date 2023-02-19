package inetaddresstest;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author muchen
 * @create 2022 - 12 - 2022/12/3 17:42
 *
 *
 */
public class SocketTCP01Server {
    public static void main(String[] args) throws IOException {
        //在本机9999端口监听，等待连接
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("服务器端在等待连接...");
        //当没有客户端连接9999端口时，服务器程序会处于阻塞状态
        //当有客户端链接9999端口，ServerSocket实例化对象accept()将会返回一个套接字(Socket)
        //使用Socket可以实例化字节流对象并进行数据传输
        Socket accept = serverSocket.accept();
//        System.out.println("服务器端连接已建立！"+ accept.getClass());

        //输入流
        InputStream inputStream = accept.getInputStream();
        //输出流
        OutputStream outputStream = accept.getOutputStream();

        //字节流的基本使用
        int read;
        byte[] bytes = new byte[10];
        System.out.print("客户传输内容为：");
        while ((read = inputStream.read(bytes)) != -1){
            System.out.print(new String(bytes,0,read));
        }

        outputStream.write("hello,client".getBytes());
        accept.shutdownOutput();//***************************

        System.out.println("通信结束！");
        inputStream.close();
        outputStream.close();
        accept.close();
        serverSocket.close();
    }
}
