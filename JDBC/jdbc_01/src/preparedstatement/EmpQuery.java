package preparedstatement;

import org.junit.Test;
import query.Emp;
import util.JDBCUtiles;

import java.io.File;
import java.lang.reflect.Field;
import java.sql.*;

/**
 * @author muchen
 * @create 2023 - 01 - 2023/1/1 15:25
 */
public class EmpQuery {

    @Test
    public void testQueryForEmp(){
        String sql = "select EMPNO,ENAME,JOB,MGR from emp where empno = ?";
        Emp emp = queryForEmp(sql, 7369);
        System.out.println(emp);

    }

    /**
     * 针对Emp表的通用查询操作
     * @param sql ：需要执行的sql语句
     * @param args：sql语句中占位符中的变量
     * @return
     * @throws Exception
     */
    public Emp queryForEmp(String sql,Object...args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            conn = JDBCUtiles.getConnection();
            ps = conn.prepareStatement(sql);
            for (int i = 0;i < args.length;i++){
                ps.setObject(i+1, args[i]);
            }
            resultSet = ps.executeQuery();
            //获取结果集的元数据********
            ResultSetMetaData rsmd = resultSet.getMetaData();
            //通过ResultSetMetaData获取结果集中的列数
            int columnCount = rsmd.getColumnCount();
            if (resultSet.next()){
                Emp emp = new Emp();
                //处理结果集一行数据中的每一个列
                for (int i = 0;i < columnCount;i++){
                    Object columnValue = resultSet.getObject(i + 1);//获取各个字段对应的值
                    //获取列对应的列名：getColumnName()《获取数据库中的字段名》————>不常用
                    //获取列的别名：getColumnLabel()《有别名获取别名，没有别名获取字段名》:一般只用这个，如果没有取别名则列明还为列名
                    /*
                    针对于表的字段名与类的属性名不相同的情况
                    1.必须声明sql时，使用类的属性名来命名字段的别名
                    2.使用ResultSetMetaData时，需要使用getColumnLabel()来替换getColumnName()，
                        来获取类的别名
                     */
                    String columnName = rsmd.getColumnLabel(i + 1);

                    //通过反射给对象的每一个属性赋值
                    Field field = Emp.class.getDeclaredField(columnName);
                    field.setAccessible(true);
                    field.set(emp, columnValue);
                }
                return emp;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtiles.closeResources(JDBCUtiles.fr, conn, ps, resultSet);
        }
        return null;
    }

    public static void main(String[] args) {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            conn = JDBCUtiles.getConnection();//获取数据库连接
            String sql = "select empno,ename,job,mgr,hiredate from emp where empno = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, "7369");
            //执行，并返回结果集
            resultSet = ps.executeQuery();
            if (resultSet.next()){//判断结果集的下一条是否有数据，如果有数据返回true，并指针下移，如果返回false，
                                    // 指针不会下移
                int empno = resultSet.getInt(1);
                String ename = resultSet.getString(2);
                String job = resultSet.getString(3);
                int mgr = resultSet.getInt(4);
                Date hiredate = resultSet.getDate(5);
                //输出：方法一：直接System.out.println();
                //输出：方法二：将数据存放在数组或者集合中；
                //输出：方法三：Java中万事万物皆对象，则创建一个返回数据的类，将其实例化为对象(推荐)
                Emp emp = new Emp(empno,ename,job, mgr, hiredate);
                System.out.println(emp.toString());
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtiles.closeResources(JDBCUtiles.fr, conn, ps, resultSet);
        }
    }
}
