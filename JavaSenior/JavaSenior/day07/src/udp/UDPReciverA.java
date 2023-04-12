package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @author muchen
 * @create 2022 - 12 - 2022/12/4 17:36
 *
 * 1.编写一个接收端A和一个发送端B
 * 2.接收端A在9999端口等待接收数据（recive）
 * 3.发送端B向接收端A发送数据“hello，你好啊！”
 * 4.接收端A收到发送端B发送的数据，回复“好的，已收到”，在退出
 * 5.发送端接收回复的数据在退出
 *
 * UDP
 * 1.没有明确的服务端和客户端，演变成数据的发送端和接收端
 * 2.接收数据和发送数据是通过 DatagramSocket 对象完成
 * 3.将数据封装到DatagramPacket 对象/装包
 * 4.当接收到DatagramPacket 对象，需要进行拆包，取出数据
 * 5.DatagramSocket 可以指定在哪个端口接收数据
 */
public class UDPReciverA {
    public static void main(String[] args) throws IOException {
        //1.创建一个DatagramSocket对象准备在9999端口接收数据
        DatagramSocket ds = new DatagramSocket(9999);
        //2.构建一个DatagramPacket对象准备接收数据
        //  UDP一个数据包最大为64K
        byte[] bytes = new byte[1024];//此byte数组用于接收数据
        DatagramPacket dp = new DatagramPacket(bytes, bytes.length);
        //3.调用接收方法,将通过网络传输的DatagramPacket 对象填充到dp对象

        //当有数据包发送到本机的9999端口时，就会收到数据
        //如果没有数据包发送到本机的9999端口时，就会阻塞等待
        ds.receive(dp);

        //4.可以把dp进行拆包，取出数据并显示
        int length = dp.getLength();//实际收到的数据长度
        byte[] data = dp.getData();//接收到数据
        System.out.println(new String(data,0,length));

        //发送消息给B
        byte[] inf = "我已经收到，谢谢你！".getBytes();
        DatagramPacket dp1 = new DatagramPacket(inf, inf.length, InetAddress.getByName("192.168.56.1"),9998);
        ds.send(dp1);
        System.out.println("A已发送数据...");

        ds.close();
    }
}
