package udp;

import java.io.IOException;
import java.net.*;

/**
 * @author muchen
 * @create 2022 - 12 - 2022/12/4 17:37
 */
public class UDPReciverB {
    public static void main(String[] args) throws IOException {
        //1.创建该对象，准备发送和接收数据
        DatagramSocket ds = new DatagramSocket(9998);
        //2.将需要发送的数据封装到DatagramPacket对象中
        byte[] bytes = "hello,你好啊!".getBytes();
        //说明：封装的DatagramPacket对象 data内容字节数组，data。length，主机IP，端口
        DatagramPacket dp = new DatagramPacket(bytes, bytes.length, InetAddress.getByName("192.168.56.1"), 9999);
        ds.send(dp);

        //接受A发来的信息
        byte[] data = new byte[1024];
        DatagramPacket dp1 = new DatagramPacket(data,data.length);

        ds.receive(dp1);
        byte[] inf = dp1.getData();
        System.out.println(new String(inf,0,dp1.getLength()));

        ds.close();
    }
}
