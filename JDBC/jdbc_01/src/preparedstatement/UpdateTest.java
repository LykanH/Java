package preparedstatement;

import org.junit.Test;
import util.JDBCUtiles;

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
 * @create 2022 - 12 - 2022/12/24 15:47
 *
 * 实现对数据库的增删改查
 * 增：String sql = "insert into dept(deptno,dname,loc) values(?,?,?)"; //占位符
 * 删：String sql = "delete from dept where deptno = 40";
 * 改：String sql = "update dept set dname = ? where deptno = ?";
 *
 */
public class UpdateTest {
    public static void main(String[] args){
        FileReader dr = null;
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            Properties properties = new Properties();
            dr = new FileReader(new File("jdbc.properties"));
            properties.load(dr);

            //从配置文件中读取各个数值
            String name = properties.getProperty("name");
            String password = properties.getProperty("password");
            String url = properties.getProperty("url");
            String driverClass = properties.getProperty("driverClass");

            Class clazz = Class.forName(driverClass);
            Constructor constructor = clazz.getDeclaredConstructor();
            Driver driver = (Driver) constructor.newInstance();

            DriverManager.registerDriver(driver);
            conn = DriverManager.getConnection(url, name, password);
//            System.out.println(conn);
            //预编译sql语句，返回PreparedStatement的实例
            String sql = "insert into dept(deptno,dname,loc) values(?,?,?)"; //占位符
            ps = conn.prepareStatement(sql);
            //填充占位符
            ps.setString(1, "60");
            ps.setString(2, "TEST");
            ps.setString(3, "SHANGHAI");

            //执行sql
            ps.execute();

        } catch (Exception e) {
//            throw new RuntimeException(e);
            e.printStackTrace();
        } finally {
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
            if (dr != null){
                try {
                    dr.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    /**
     * 修改dept表的一条内容
     */
    @Test
    public void test1() throws Exception {
        //1.获取数据库的连接
        Connection conn = JDBCUtiles.getConnection();
        //2.预编译sql语句，返回preparedStatement的实例
        String sql = "update dept set dname = ? where deptno = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        //3.填充占位符
        ps.setString(1,"ypb");
        ps.setInt(2, 50);

        //4.执行
        ps.execute();

        //5.资源的关闭
        JDBCUtiles.closeResources(JDBCUtiles.fr, conn, ps);
    }
}
