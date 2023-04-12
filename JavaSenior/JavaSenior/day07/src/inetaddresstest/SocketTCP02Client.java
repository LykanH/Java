package inetaddresstest;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author muchen
 * @create 2022 - 12 - 2022/12/4 10:20
 */
public class SocketTCP02Client {
    public static void main(String[] args) throws IOException {
        //客户端
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        System.out.println("连接建立成功！");
        OutputStream os = socket.getOutputStream();
        InputStream is = socket.getInputStream();
        //将字节流转化为字符流
        OutputStreamWriter osw = new OutputStreamWriter(os);
        InputStreamReader isr = new InputStreamReader(is);

        //开始给服务器发送数据
        osw.write("hello,server!");
        osw.flush();
        socket.shutdownOutput();//结束客户端的数据发送

        int read = 0;
        char[] chars = new char[1024];
        while ((read = isr.read(chars))!=-1){
            System.out.println(new String(chars,0,read));
        }

        osw.close();
        isr.close();
        socket.close();
    }
}
