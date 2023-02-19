package inetaddresstest;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author muchen
 * @create 2022 - 11 - 2022/11/10 16:49
 *
 * 三、通信要素一：IP和端口号
 * 1、IP：唯一的表识Internet上的计算机（通信实体）
 * 2、在Java中用InetAddress类代表IP
 * 3、IP分类：IPv4 和 IPv6；万维网和局域网
 * 4、域名
 * 5、本地回路地址（表示本机）：127.0.0.1 对应着 localhost
 *
 * InerAddress:构造器被私有化，不可以直接进行实例化，需要调用方法为该类进行实例化
 *
 * 6.如何去实例化InerAddress：两个方法：getByName(String host)和 getLocalHost()
 *
 * 7.端口号：正在计算机上运行的进程
 * 要求：不同的进程有不同的端口号
 * 范围：规定为一个16位的整数
 *      工人端口：0~1023
 *      注册端口：1024~49151
 *
 * 8：端口号与IP地址组合得出的一个套接字：Socket
 */
public class InetAddressTest {
    public static void main(String[] args) {
        try {
            InetAddress ia =  InetAddress.getByName("www.baidu.com");//需要dns解析显示域名和IP

            //两个重要方法getHostName(),getHostAddress
            String hostName = ia.getHostName();
            String hostAddress = ia.getHostAddress();
            System.out.println("主机名：" + hostName +" IP: "+hostAddress);

            System.out.println(ia);

            InetAddress ia1 = InetAddress.getByName("112.54.108.102");//不需要dns解析，故不显示域名
            System.out.println(ia1);

            //获取本机IP的三种方法：
            InetAddress ia2 = InetAddress.getByName("localhost");
            InetAddress ia3 = InetAddress.getByName("127.0.0.1");
            System.out.println(ia2);
            InetAddress ia4 = InetAddress.getLocalHost();//获取到的为该局域网中的IP
            System.out.println(ia4);

        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
    }
}
