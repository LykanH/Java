package dao;

/**
 * @author muchen
 * @create 2023 - 01 - 2023/1/29 16:54
 */

import java.sql.Connection;
import java.sql.Date;

/**
 * 此接口用于规范对于customer表的常用操作
 */
public interface CustomerDao {

    /**
     *
     * @param connection
     * @param user:需要插入的对象
     */
    public void insert(Connection connection,User user);

    /**
     *
     * @param connection
     * @param id 需要删除数据的id
     */
    void delet(Connection connection,int id);

    /**
     *
     * @param connection
     * @param user 需要修改的数据
     */
    void updatById(Connection connection,User user);

    /**
     *
     * @param connection
     * @param id 通过id查询数据
     */
    User queryById(Connection connection,int id);

    /**
     * 返回数据表中的数据条目数
     * @param connection
     * @return
     */
    Long getCount(Connection connection);

    Date getMaxBirth(Connection connectionw);
}
