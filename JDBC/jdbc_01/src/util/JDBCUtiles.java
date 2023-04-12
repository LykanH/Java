package util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.sql.*;
import java.util.Properties;

/**
 * @author muchen
 * @create 2022 - 12 - 2022/12/24 17:02
 *
 * 操作数据库的工具类
 */

public class JDBCUtiles {
    /**
     * 获取数据库的连接
     * @return
     * @throws Exception
     */
    public static FileReader fr = null;
    public static Connection getConnection() throws Exception {
        Properties properties = new Properties();
//        FileReader fr = new FileReader(new File("..\\jdbc.properties"));
        fr = new FileReader(new File("jdbc.properties"));
        properties.load(fr);

        //从配置文件中读取各个数值
        String name = properties.getProperty("name");
        String password = properties.getProperty("password");
        String url = properties.getProperty("url");
        String driverClass = properties.getProperty("driverClass");

        Class clazz = Class.forName(driverClass);
        Constructor constructor = clazz.getDeclaredConstructor();
        Driver driver = (Driver) constructor.newInstance();

        DriverManager.registerDriver(driver);
        Connection conn = DriverManager.getConnection(url, name, password);

        return conn;
    }


    /**
     * 关闭资源
     * @param fr
     * @param conn
     * @param ps
     */
    public static void closeResources(FileReader fr,Connection conn, PreparedStatement ps){
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if (conn != null) {
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
    public static void closeResources(FileReader fr,Connection conn, PreparedStatement ps,ResultSet resultSet){
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if (conn != null) {
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
        if (resultSet != null){
            try {
                resultSet.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
