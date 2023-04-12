package inetaddresstest;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author muchen
 * @create 2022 - 12 - 2022/12/3 17:42
 *
 * 1.编写一个服务器和一个客户端
 * 2，服务器在9999端口监听
 * 3.客户端连接到服务器端，发送hello，server，然后退出
 * 4.服务器端收到客户端发送的信息，输出并发送hello,client，再退出
 */
public class SocketTCP01Client {
    public static void main(String[] args){
        Socket clietntSocket = null;
        OutputStream outputStream = null;
        InputStream inputStream = null;
        try {
            //1.创建一个套接字(Socket)对象，并传入服务器端的IP和端口。
            //  连接本机的9999端口，若连接成功则返回Socket对象
            clietntSocket = new Socket(InetAddress.getLocalHost(),9999);
            System.out.println("成功与服务器建立连接！");
//            System.out.println("客户端socket" + clietntSocket.getClass());

            //连接上并生成Socket后，通过Soket来get输入流，进行内容的传输
            //输出流
            outputStream = clietntSocket.getOutputStream();
            //输入流
            inputStream = clietntSocket.getInputStream();
            String s1 = "hello,server";
//        byte[] bytes = new byte[10];
//            outputStream.write("hello,cerver".getBytes());
            byte[] bytes = s1.getBytes();
            //发送给服务器数据
            outputStream.write(bytes);

            //***设置结束标记***
            clietntSocket.shutdownOutput();

            //接受客户端发送的数据
            int read = 0;
            byte[] bytes1 = new byte[10];
            while ((read = inputStream.read(bytes1)) != -1){
                System.out.print(new String(bytes1,0,read));
            }
            System.out.println("通信结束！");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (outputStream!=null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if (clietntSocket != null) {
                try {
                    clietntSocket.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if (inputStream != null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
