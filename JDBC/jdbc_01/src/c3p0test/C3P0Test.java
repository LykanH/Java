package c3p0test;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.beans.PropertyVetoException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author muchen
 * @create 2023 - 01 - 2023/1/30 14:38
 */
public class C3P0Test {
    public static void main(String[] args) throws SQLException {
        //方式一：不推荐，推荐使用配置文件
        /*ComboPooledDataSource cpds = new ComboPooledDataSource();
        cpds.setDriverClass( "com.mysql.cj.jdbc.Driver" ); //loads the jdbc driver
        cpds.setJdbcUrl( "jdbc:mysql://localhost:3306/bjpowernode?serverTimezone=GMT%2B8&rewriteBatchedStatements=true" );
        cpds.setUser("root");
        cpds.setPassword("123456");
        //通过相关的参数，对数据库连接进行管理
        //设置初始时数据库连接池中的连接数
        cpds.setInitialPoolSize(10);

        Connection connection = cpds.getConnection();

        System.out.println(connection);*/

        //方式二：使用properties配置文件
       /* FileReader fr = null;
        ComboPooledDataSource cpds = null;
        Connection connection = null;
        try {
            Properties properties = new Properties();
            fr = new FileReader(new File("jdbc.properties"));
            properties.load(fr);
            String name = (String) properties.get("name");
            String password = (String) properties.get("password");
            String url = (String) properties.get("url");
            String driverClass = (String) properties.get("driverClass");
            //获取数据库连接池
            cpds = new ComboPooledDataSource();
            cpds.setDriverClass(driverClass); //loads the jdbc driver
            cpds.setJdbcUrl(url);
            cpds.setUser(name);
            cpds.setPassword(password);

            cpds.setInitialPoolSize(10);
            connection = cpds.getConnection();
            System.out.println(connection);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (PropertyVetoException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if (cpds != null)
                cpds.close();
            if (fr != null) {
                try {
                    fr.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }*/

        ComboPooledDataSource cpds = new ComboPooledDataSource("hellc3p0");
        Connection conn = cpds.getConnection();
        System.out.println(conn);

    }
}
