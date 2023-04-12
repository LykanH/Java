package blobtest;

import org.hamcrest.core.Is;
import util.JDBCUtiles;

import java.io.*;
import java.sql.*;

/**
 * @author muchen
 * @create 2023 - 01 - 2023/1/5 13:10
 * 测试使用PreparedStatement操作Blob类型的数据
 */
public class BlobTest {
    public static void main(String[] args) {
        //测试增删改等语句
//        FileInputStream fis = null;
//        try {
//            BlobTest blobTest = new BlobTest();
//            String sql = "insert into t_blob(name,email,birth,photo) values(?,?,?,?)";
//            fis = new FileInputStream(new File("photo.jpg"));
//            blobTest.operateBlob(sql,fis,"yang","y@qq.com","2002-02-14");
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        } finally {
//            if (fis != null){
//                try {
//                    fis.close();
//                } catch (IOException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//        }
        //测试查询blob类型数据并存放在指定文件夹下
        BlobTest blobTest = new BlobTest();
        String  sql = "select * from t_blob where id = 4";
        blobTest.readBlob(sql);
    }
    //向数据表中插入blob类型的字段
    //方法一：
    public  int operateBlob(String sql,Object...args) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JDBCUtiles.getConnection();
            ps = conn.prepareStatement(sql);
            for (int i = 0;i < args.length - 1;i++){
                ps.setObject(i + 1, args[i]);
            }
            ps.setBlob(args.length, (InputStream) args[args.length - 1]);
            return ps.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtiles.closeResources(JDBCUtiles.fr, conn,ps);
        }
    }

    //方法二：
//    public  int operateBlob(String sql,FileInputStream fis,Object...args) {
//        Connection conn = null;
//        PreparedStatement ps = null;
//        try {
//            conn = JDBCUtiles.getConnection();
//            ps = conn.prepareStatement(sql);
//            ps.setObject(1, args[0]);
//            ps.setObject(2, args[1]);
//            ps.setObject(3, args[2]);
//            ps.setBlob(4, fis);
////            ps.setBlob(args.length, (InputStream) args[args.length - 1]);
//            return ps.executeUpdate();
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        } finally {
//            JDBCUtiles.closeResources(JDBCUtiles.fr, conn,ps);
//        }
//    }

    //从数据表中读取Blob类型数据
    public void readBlob(String sql){
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        BufferedOutputStream bos = null;
        InputStream is = null;
        try {
            conn = JDBCUtiles.getConnection();

            ps = conn.prepareStatement(sql);
            resultSet = ps.executeQuery();
            ResultSetMetaData rsmd = resultSet.getMetaData();
            if (resultSet.next()){
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String email = resultSet.getString(3);
                String birth = resultSet.getString(4);

                BlobClass blobClass = new BlobClass(id, name, email, birth);
                System.out.println(blobClass.toString());

                Blob photo = resultSet.getBlob(5);
                is = photo.getBinaryStream();
                bos = new BufferedOutputStream(new FileOutputStream(new File("jdbc_01\\src\\blobtest\\photo.jpg")));
                int read;
                byte[]  bytes = new byte[1024];
                while ((read = is.read(bytes)) != -1){
                    bos.write(bytes, 0, read);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtiles.closeResources(JDBCUtiles.fr, conn, ps, resultSet);
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if (is != null){
                try {
                    is.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
