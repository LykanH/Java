package tcp_udphomework.tcp_home1;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author muchen
 * @create 2022 - 12 - 2022/12/4 22:19
 * <p>
 * 服务端使用10009端口
 * 1.使用字符流的方式，编写一个客户端程序和服务器端程序(表明使用TCP网络编程)
 * 2.客户端发送“name”，服务器端收到后返回“我是nova”，
 * 3.客户端发送“hobby”，服务器端收到后，返回“编写Java程序”
 * 4.不是这两个问题：回复“我不明白什么意思”
 */
public class HomeWork1Client {
    public static void main(String[] args) throws IOException {
        //客户端实例化套接字与服务端连接，准备进行传输
        Socket socket = new Socket(InetAddress.getByName("127.0.0.1"), 10009);
        System.out.println("正在和服务端进行连接...");
        //从套接字获得字节输出流并将其转换为字符输出流
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        System.out.print("输入你想问的内容：");
        String input = new Scanner(System.in).next();
        bw.write(input);
        bw.flush();
        socket.shutdownOutput();

        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        int read;
        char[] chars = new char[1024];
        while ((read = br.read(chars)) != -1) {
            System.out.println(new String(chars,0,read));
        }

        //关闭流
        br.close();
        bw.close();
        socket.close();
    }
}
