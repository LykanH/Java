package connection;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author muchen
 * @create 2022 - 12 - 2022/12/22 14:57
 *
 *         //1.注册驱动
 *         //2.获取链接
 *         //3.获取数据库操作对象
 *         //4.执行sql
 *         //5.处理查询结果集
 *         //6.释放资源
 */
public class ConnectionTest {
    //获取数据库连接方式一：
    public static void main(String[] args) throws SQLException {
        Driver driver = new com.mysql.cj.jdbc.Driver();
        String URL = "jdbc:mysql://localhost:3306/test?serverTimezone=GMT%2B8";
        Properties info = new Properties();//将用户名密码封装到Properties文件中
        info.setProperty("user", "root");
        info.setProperty("password", "123456");
        Connection conn = driver.connect(URL, info);

        System.out.println(conn);

    }

    //获取数据库连接方式二：
    @Test
    public void test2() throws Exception {
        //方式二是对方式一的迭代：使用反射获取第三方api
        Class clazz = Class.forName("com.mysql.cj.jdbc.Driver");
        Constructor constructor = clazz.getDeclaredConstructor();
        Driver dirver = (Driver) constructor.newInstance();

        String s = "jdbc:mysql://localhost:3306/test?serverTimezone=GMT%2B8";
        Properties info = new Properties();
        info.setProperty("user", "root");
        info.setProperty("password", "123456");
        Connection conn = dirver.connect(s, info);

        System.out.println(conn);
    }

    //方式三：使用DriverManager替换Driver
        //1.注册驱动
        // 2.获取链接
        // 3.获取数据库操作对象
        //4.执行sql
        // 5.处理查询结果集
        //6.释放资源
    @Test
    public void test3() throws Exception {
        //使用反射获取Driver实现类的对象
        Class clazz = Class.forName("com.mysql.cj.jdbc.Driver");
        Constructor constructor = clazz.getDeclaredConstructor();
        Driver driver = (Driver) constructor.newInstance();

        //注册驱动
        DriverManager.registerDriver(driver);

        String URL = "jdbc:mysql://localhost:3306/test?serverTimezone=GMT%2B8";
        String name = "root";
        String password = "123456";
        //获取链接
        Connection conn = DriverManager.getConnection(URL, name, password);

        System.out.println(conn);
    }

    //方式四：可以只是加载驱动，不用显示注册驱动

    @Test
    public  void test4() throws Exception {
        String URL = "jdbc:mysql://localhost:3306/test?serverTimezone=GMT%2B8";
        String name = "root";
        String password = "123456";

        //注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        //相较于方式三，可以省略如下操作
//        Constructor constructor = clazz.getDeclaredConstructor();
//        Driver driver = (Driver) constructor.newInstance();
//        DriverManager.registerDriver(driver);

        //获取链接
        Connection conn = DriverManager.getConnection(URL, name, password);

        System.out.println(conn);
    }

    //方式五：将URL，用户名，密码，driver类的路径都放入配置文件中
    @Test
    public void test5(){
        FileReader fr = null;
        try {
            Properties info = new Properties();
            fr = new FileReader(new File("..\\jdbc.properties"));
            info.load(fr);
            String name = info.getProperty("name");
            String password = info.getProperty("password");
            String url = info.getProperty("url");
            String driverClass = info.getProperty("driverClass");

            //实例化驱动
            Class clazz = Class.forName(driverClass);
//            Constructor constructor = clazz.getDeclaredConstructor();
//            Driver driver = (Driver) constructor.newInstance();
//
//            DriverManager.registerDriver(driver);

            Connection conn = DriverManager.getConnection(url, name, password);
            System.out.println(conn);

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if (fr != null){
                try {
                    fr.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }
}
