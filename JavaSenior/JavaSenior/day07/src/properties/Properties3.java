package properties;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

/**
 * @author muchen
 * @create 2022 - 11 - 2022/11/26 15:46
 */
public class Properties3 {
    public static void main(String[] args) throws IOException {
        //使用properties类添加key-val到新文件mysql2.properties中

        //实例化Properties
        Properties properties = new Properties();
        properties.setProperty("class","A2041");
        properties.setProperty("name","杨鹏博");
        properties.setProperty("age","20");

        //store方法会将内存中的key-val放入到指定的文件中
        properties.store(new FileWriter("day07\\src\\mysql2.properties"),null);
        System.out.println("文件初始化完毕！");

    }
}
