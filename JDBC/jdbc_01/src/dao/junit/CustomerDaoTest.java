package dao.junit;

import dao.User;
import dao.UserDAOImpl;
import util.JDBCUtiles;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author muchen
 * @create 2023 - 01 - 2023/1/29 18:24
 */
public class CustomerDaoTest {
    public static void main(String[] args) {
        Connection connection = null;
        try {
            //测试数据库插入数据
            connection = JDBCUtiles.getConnection();
            connection.setAutoCommit(false);

            UserDAOImpl userDAO = new UserDAOImpl();
            User u1 = new User(3, "dam", 1500);
            User u2 = new User(1, "ypb", 3000);
            //测试插入数据
//        userDAO.insert(connection,u1);
            //测试删除数据
//        userDAO.delet(connection, 3);
            //测试修改数据
//        userDAO.updatById(connection, u2);
            //测试查询数据
//            System.out.println(userDAO.queryById(connection, 2));
            //测试分组查询
//            System.out.println("数据总共条数为："+userDAO.getCount(connection));
            //测试获得最大日期方法
            System.out.println(userDAO.getMaxBirth(connection));
            //提交事务
            connection.commit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (connection != null)
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
