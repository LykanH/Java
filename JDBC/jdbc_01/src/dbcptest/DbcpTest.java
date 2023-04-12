package dbcptest;

import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author muchen
 * @create 2023 - 01 - 2023/1/31 13:33
 */
public class DbcpTest {
    /**
     测试dbcp的数据库连接池技术
     *
     */
    public static void main(String[] args) throws SQLException {
        //创建了DBCP的数据库连接池
        BasicDataSource bds = new BasicDataSource();
        bds.setPassword("123456");
        bds.setUsername("root");
        bds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        bds.setUrl("jdbc:mysql://localhost:3306/bjpowernode?serverTimezone=GMT%2B8&rewriteBatchedStatements=true");

//      还可以设置其他设计数据库连接池管理的相关属性
        bds.setInitialSize(10);

        Connection connection = bds.getConnection();
    }
}
