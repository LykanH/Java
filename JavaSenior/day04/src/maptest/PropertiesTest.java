package maptest;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * @author muchen
 * @create 2022 - 10 - 2022/10/31 21:11
 */
public class PropertiesTest {
    //Properties:常用来处理配置文件。key和value都是String类型
    public static void main(String[] args) throws Exception {
        Properties properties = new Properties();

        FileInputStream fis = new FileInputStream("jdbc.properties");
        properties.load(fis);//加载流对应的文件

        String name = properties.getProperty("name");
        String password = properties.getProperty("password");

        System.out.println("name = "+name+",password = "+password);
        fis.close();
    }
}
