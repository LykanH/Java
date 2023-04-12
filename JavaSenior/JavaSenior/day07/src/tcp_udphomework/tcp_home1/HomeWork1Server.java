package tcp_udphomework.tcp_home1;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author muchen
 * @create 2022 - 12 - 2022/12/4 22:19
 */
@SuppressWarnings("all")
public class HomeWork1Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(10009);
        System.out.println("正在与客户端建立连接...");
        Socket socket = serverSocket.accept();//建立连接成功返回套接字
        System.out.println("连接建立成功！");

        //获得输入字节流并将其转换为字符流
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        int read;
        char[] data = new char[1024];
        String s1 = null;
        while ((read = br.read(data)) != -1) {
            s1 = new String(data,0,read);
            System.out.println(s1);
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        if ("name".equals(s1)){
            bw.write("我是nova！");
        } else if ("hobby".equals(s1)) {
            bw.write("编写Java程序！");
        }else {
            bw.write("我不明白什么意思！");
        }
        bw.flush();
        socket.shutdownOutput();

        bw.close();
        br.close();
        socket.close();
        serverSocket.close();
    }
}
