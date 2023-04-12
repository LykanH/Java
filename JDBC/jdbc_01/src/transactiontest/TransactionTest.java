package transactiontest;

import util.JDBCUtiles;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author muchen
 * @create 2023 - 01 - 2023/1/27 17:09
 * 事务：一组逻辑操作单元，使数据从一种状态转换到另一种状态。
 *          > 一组逻辑操作单元：一个或多个DML操作
 *
 *  事务处理的原则：保证所有事物都作为一个工作单元来执行，即使出现了故障，也不能改变这种方式
 *  当在一个事务中执行多个操作时，要么所有的事务都被提交(commit)，那么这些修改都会永久的保存
 *  下来。要么数据库管理系用将放弃所有修改，整个事务回滚到（rollback）最初状态
 *
 *  3.数据一旦提交，不可回滚
 *
 *  4.哪些操作会导致事物的自动提交
 *          >DDL操作一旦执行，都会自动提交
 *
 *          >DML默认情况下一旦执行就自动提交。
 *              >我们可以通过set autocommit = false取消DML操作的自动提交
 *          >默认在关闭连接的时候会自动提交（所以需要两个DML操作公用一个Connection连接）
 */
public class TransactionTest {
    /*public static void main(String[] args) {
        //向t_transaction表中插入两条数据
//        String sql1 = "insert into t_transaction(name,balence) values(?,1000)";
//        String sql2 = "insert into t_transaction(name,balence) values(?,1000)";
//        if (operate(sql1, "sam") != 0 && operate(sql1,"jam") != 0){
//            System.out.println("TRUE!");
//        }else {
//            System.out.println("FALSE!");
//        }
        String sql3 = "update t_transaction set balence = balence - 100 where id = ?";
        String sql4 = "update t_transaction set balence = balence + 100 where id = ?";
        if (operate(sql3, 1) != 0 && operate(sql4,2) != 0){
            System.out.println("TRUE!");
        }else {
            System.out.println("FALSE!");
        }
    }*/
    public static void main(String[] args){
        Connection connection = null;
        try {
            connection = JDBCUtiles.getConnection();
            System.out.println(connection.getAutoCommit());
            connection.setAutoCommit(false);

            String sql3 = "update t_transaction set balence = balence - 100 where id = ?";
            String sql4 = "update t_transaction set balence = balence + 100 where id = ?";
            operate1(connection,sql3, 1);
            System.out.println(10/0);//假设事务出现异常
            operate1(connection,sql4, 2);
            connection.commit();
        } catch (Exception e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            throw new RuntimeException(e);
        } finally {
            //修改其为自动提交数据
            try {
                connection.setAutoCommit(true);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }
    /*
    2.0适用于事物的通用增删改操作
    将Connection对象作为变量放在括号中；
     */
    public static int operate1(Connection connection,String sql,Object...args) {
        PreparedStatement ps = null;
        try {
            //获取数据库操作对象
            ps = connection.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                //填充占位符
                ps.setObject(i + 1, args[i]);
            }
            return ps.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtiles.closeResources(JDBCUtiles.fr, null, ps);
        }
    }

    //写一个通用的增删改操作
    public static int operate(String sql,Object...args) {
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = JDBCUtiles.getConnection();
            ps = connection.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }
            return ps.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtiles.closeResources(JDBCUtiles.fr, connection, ps);
        }
    }
}
