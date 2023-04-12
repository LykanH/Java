package utilc3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author muchen
 * @create 2023 - 01 - 2023/1/30 16:40
 */
public class C3P0Test1 {
    public static Connection getConnection() throws SQLException {
        ComboPooledDataSource cpds = new ComboPooledDataSource("hellc3p0");
        Connection conn = cpds.getConnection();
        return conn;
    }
}
