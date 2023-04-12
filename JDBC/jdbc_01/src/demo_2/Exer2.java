package demo_2;

import org.junit.Test;
import util.JDBCUtiles;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

/**
 * @author muchen
 * @create 2023 - 01 - 2023/1/4 17:09
 */
public class Exer2 {
    public static void main(String[] args) {
        System.out.print("输入序号：");
        Scanner scan = new Scanner(System.in);
        int flowid = scan.nextInt();
        System.out.print("四级/六级：");
        int type = scan.nextInt();
        System.out.print("输入身份证：");
        String idcard = scan.next();
        System.out.print("输入学号：");
        String examcard = scan.next();
        System.out.print("输入名字：");
        String studentname = scan.next();
        System.out.print("输入家庭住址：");
        String location = scan.next();
        System.out.print("输入成绩：");
        int grade = scan.nextInt();
        String sql = "insert into examstudent(flowid,type,idcard,examcard,studentname,location,grade)" +
                "values(?,?,?,?,?,?,?)";
        if (update(sql, flowid, type, idcard, examcard, studentname, location, grade) != 0) {
            System.out.println("执行成功！");
        } else {
            System.out.println("执行失败！");
        }
    }
    /**
     * 通用的增删改操作
     * @return
     */
    public static int update(String sql,Object...args) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JDBCUtiles.getConnection();
            ps = conn.prepareStatement(sql);
            for (int i = 0;i < args.length;i++){
                ps.setObject(i+1, args[i]);//填补占位符中的内容
            }
            return ps.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtiles.closeResources(JDBCUtiles.fr, conn, ps);
        }
    }
}
