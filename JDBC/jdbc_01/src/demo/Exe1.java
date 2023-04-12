package demo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

/**
 * @author muchen
 * @create 2023 - 01 - 2023/1/27 15:38
 *
 *
 */
public class Exe1 {
    public static void main(String[] args) throws Exception {
        FileReader fr = new FileReader(new File("jdbc.properties"));
        Properties properties = new Properties();
        properties.load(fr);

        String name = (String) properties.get("name");
        String password = (String) properties.get("password");
        String url = (String) properties.get("url");
        String driverclass = (String) properties.get("driverClass");
        //注册驱动
        Class clazz = Class.forName(driverclass);

        //获取连接
        Connection conn = DriverManager.getConnection(url, name, password);
//         System.out.println(conn);
        //获取数据库操作对象
        String sql = "insert into t_students (num,name,sex,age,email) values(?,?,?,?,?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, 1003);
        ps.setString(2, "负责人");
        ps.setString(3, "男");
        ps.setInt(4, 20);
        ps.setString(5, "3455@qq.com");

        ps.execute();

    }
}
