package numberstest;

import util.JDBCUtiles;

import java.sql.Connection;
import java.sql.PreparedStatement;


/**
 * @author muchen
 * @create 2023 - 01 - 2023/1/7 17:20
 *
 * 使用PreparedStatement实现批量数据的操作
 */
public class InsertTest {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        String sql = "insert into people(name) values(?)";
        new InsertTest().operateData3(sql,2000000);
        long end = System.currentTimeMillis();
        System.out.println("时间为："+(end-start));
    }

    //方法一：
    //执行20000条插入语句需要15s
    public void operateData(String sql,int num) {
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = JDBCUtiles.getConnection();
            ps = connection.prepareStatement(sql);
            for (int i = 0;i < num;i++) {
                ps.setString(1, "name");
                ps.execute();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtiles.closeResources(JDBCUtiles.fr, connection, ps);
        }
    }

    /*
    方法二：
    1.addBatch()、excuteBanch()、clearBanth()
    2.mysql 服务器默认是关闭批处理的，我们需要通过一个参数，让MySQL开启批处理的支持
    &rewriteBatchedStatements=true 放在url的后边

    20000条数据执行时间为：436ms
    2000000条数据 ：10419ms
     */
    public void operateData2(String sql,int num) {
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = JDBCUtiles.getConnection();
            ps = connection.prepareStatement(sql);
            for (int i = 1;i <= num;i++) {
                ps.setString(1, "name");

                //1.攒sql、相当于io流当中的缓冲数组一样，先将数据缓冲下来 最后同一执行
                ps.addBatch();

                if (i != 0 && i % 500 == 0){
                    //执行
                    ps.executeBatch();
                    //清空
                    ps.clearBatch();
                }    //一定要把原来的excute()从代码行给删掉
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtiles.closeResources(JDBCUtiles.fr, connection, ps);
        }
    }

    /**
     * 方法三：
     * 执行2000000条数据时间：8239ms
     * @param sql
     * @param num
     */
    public void operateData3(String sql,int num) {
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = JDBCUtiles.getConnection();
            //设置不允许自动提交
            connection.setAutoCommit(false);

            ps = connection.prepareStatement(sql);
            for (int i = 1;i <= num;i++) {
                ps.setString(1, "name");

                //1.攒sql、相当于io流当中的缓冲数组一样，先将数据缓冲下来 最后同一执行
                ps.addBatch();

                if (i != 0 && i % 500 == 0){
                    //执行
                    ps.executeBatch();
                    //清空
                    ps.clearBatch();
                }    //一定要把原来的excute()从代码行给删掉
            }

            connection.commit();//统一的进行提交，节约时间
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtiles.closeResources(JDBCUtiles.fr, connection, ps);
        }
    }
}
