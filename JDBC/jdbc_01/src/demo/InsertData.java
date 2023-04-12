package demo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.Properties;

/**
 * @author muchen
 * @create 2023 - 01 - 2023/1/3 18:19
 *
 * 练习题1.向表bjpowernode中插入一条数据
 */
public class InsertData {
    public static void main(String[] args) {
        FileReader fr = null;
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            Properties properties = new Properties();
            fr = new FileReader(new File("jdbc.properties"));
            properties.load(fr);
            String name = properties.getProperty("name");
            String password = properties.getProperty("password");
            String url = properties.getProperty("url");
            String driverClass = properties.getProperty("driverClass");
            //通过反射获取驱动对象，在第三方api中，已经注册过驱动，所以我们并不需要手动注册
            Class clazz = Class.forName(driverClass);//注册驱动
            Constructor constructor = clazz.getDeclaredConstructor();
            Driver driver = (Driver) constructor.newInstance();

            conn = DriverManager.getConnection(url, name, password);//获取链接

            //获取数据库操作对象
//            System.out.println(conn);
            String sql = "insert into dept(deptno,dname,loc) values(?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, 52);
            ps.setString(2, "boy");
            ps.setString(3, "shanghai");
            /*
            ps.excute():
            如果执行的是查询操作，有返回结果，则此方法返回true
            如果执行的是增删改操作，没有返回结果，则此方法返回false
             */
//            ps.execute();
            ps.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if (ps != null){
                try {
                    ps.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if (conn != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
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
