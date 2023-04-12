package druidtest;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

/**
 * @author muchen
 * @create 2023 - 01 - 2023/1/31 14:49
 */
public class DruidTest {
//    德鲁伊（druid）数据库连接池的简单实用
    public static void main(String[] args) throws Exception {
        Properties pro = new Properties();
        InputStream inStream = DruidTest.class.getClassLoader().getResourceAsStream("druid.properties");

        pro.load(inStream);
        DataSource dataSource = DruidDataSourceFactory.createDataSource(pro);
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
    }

}
