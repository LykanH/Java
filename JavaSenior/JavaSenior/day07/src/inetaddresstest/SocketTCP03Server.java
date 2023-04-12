package inetaddresstest;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author muchen
 * @create 2022 - 12 - 2022/12/4 11:05
 */
public class SocketTCP03Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("正在建立连接....");
        Socket socket = serverSocket.accept();
        System.out.println("连接建立成功！");
//        InputStream is = socket.getInputStream();
        //建立存储文件的流
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(new File("day07\\src\\pic.png")));
        BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
        int read;
        byte[] bytes = new byte[1024];
        while ((read = bis.read(bytes))!=-1){
            bos.write(bytes);
            bos.flush();
        }

        //发送“收到图片”提示信息
        OutputStream os = socket.getOutputStream();
        os.write("服务器收到图片".getBytes());
        os.flush();
        socket.shutdownOutput();

        bis.close();
        bos.close();
        os.close();
        socket.close();

    }
}
