package properties;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * @author muchen
 * @create 2022 - 11 - 2022/11/26 15:30
 *
 * 使用Properties完成对问价内容的读取
 */
public class Properties2 {
    public static void main(String[] args) throws IOException {
        //使用Properties类来读取mysql.properties文件

        //实例化Properties对象
        Properties properties = new Properties();
        //加载指定配置文件
        properties.load(new FileReader(new File("day07\\src\\mysql.properties")));
        //把k-v显示到控制台
        properties.list(System.out);
        //根据key获取相应的值
        System.out.println();
        String user = properties.getProperty("user");
        String ip = properties.getProperty("ip");

        System.out.println(user);
        System.out.println(ip);

    }
}
