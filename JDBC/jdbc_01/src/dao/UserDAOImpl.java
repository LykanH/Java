package dao;

import java.sql.Connection;
import java.sql.Date;

/**
 * @author muchen
 * @create 2023 - 01 - 2023/1/29 17:54
 */
public class UserDAOImpl extends BaseDao implements CustomerDao {

    @Override
    public void insert(Connection connection, User user) {
        String sql = "insert into t_transaction(name,balence) values(?,?)";
        int update = update(connection, sql, user.getName(), user.getBalance());
        if (update != 0){
            System.out.println(update);
            System.out.println("True!");
        }else {
            System.out.println("False!");
        }
    }

    @Override
    public void delet(Connection connection, int id) {
        String sql = "delete from t_transaction where id = ?";
        update(connection, sql, id);
    }

    @Override
    public void updatById(Connection connection, User user) {
        String sql = "update t_transaction set name=?,balence=? where id = ?";
        update(connection, sql, user.getName(),user.getBalance(),user.getId());
    }

    @Override
    public User queryById(Connection connection, int id) {
        String sql = "select id,name,balence balance from t_transaction where id = ?";
        return getInstance(connection, User.class,sql,id);
    }

    @Override
    public Long getCount(Connection connection) {
        String sql = "select count(*) from t_transaction";
        return (Long) getValue(connection, sql);
    }

    @Override
    public Date getMaxBirth(Connection connection) {
        String sql = "select max(hiredate) from emp";
        Date birth = (Date) getValue(connection,sql);
        return birth;
    }
}
