package dao;

import util.JDBCUtiles;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.sql.*;

/**
 * @author muchen
 * @create 2023 - 01 - 2023/1/29 14:50
 */
//通用的dao
public abstract class BaseDao {
    //通用的增删改操作
    public int update(Connection connection, String sql, Object... args) {
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }
            return ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtiles.closeResources(JDBCUtiles.fr, null, ps);
        }
    }

    //通用的查询操作
    public  <T> T getInstance(Connection connection, Class<T> clazz, String sql, Object... args) {
        PreparedStatement ps = null;
        User user_1 = null;
        ResultSet resultSet = null;
        try {
            ps = connection.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }
            resultSet = ps.executeQuery();
            //获取元数据
            ResultSetMetaData rsmd = resultSet.getMetaData();
            //获取结果集中的列数
            int columnCount = rsmd.getColumnCount();
            //处理结果集中每一行数据的每一列
            if (resultSet.next()) {
                Constructor<T> con = clazz.getDeclaredConstructor();
                user_1 = (User) con.newInstance();
                //获取每一行中每一列对应的数据
                for (int j = 0; j < columnCount; j++) {
                    Object object = resultSet.getObject(j + 1);//获取该元集的每一列数据
                    //获取该列名称
                    String columnLabel = rsmd.getColumnLabel(j + 1);
                    //通过反射给各个属性赋值
                    //                clazz.getDeclaredMethod("set"+columnLabel,);
                    Field field = clazz.getDeclaredField(columnLabel);
                    field.setAccessible(true);
                    field.set(user_1, object);
                }
            }
            return (T) user_1;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtiles.closeResources(JDBCUtiles.fr, null, ps, resultSet);
        }
    }
    //针对于组函数的查询方法
    public <T> T getValue(Connection connection,String sql) {
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            ps = connection.prepareStatement(sql);

            resultSet = ps.executeQuery();
            if (resultSet.next()){
                return  (T) resultSet.getObject(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtiles.closeResources(JDBCUtiles.fr, null, ps, resultSet);
        }
        return null;
    }
}
