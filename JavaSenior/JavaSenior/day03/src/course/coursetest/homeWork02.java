package course.coursetest;

import java.util.Scanner;

/**
 * @author muchen
 * @create 2022 - 09 - 2022/9/18 20:36
 * <p>
 * 输入用户名、密码、邮箱，如果信息录入正确，则提示注册成功
 * 否则生成异常对象
 * （1）用户名长度为2或3或4
 * （2）密码长度为6 要求全是数字
 * （3）邮箱中包含@和. 并且@在.的前面
 */
public class homeWork02 {
    static Scanner sacn = new Scanner(System.in);

    public static void main(String[] args) {
        String username, password, email;
        try {
            username = getUsername();
            password = getPassword();
            email = getEmail();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }
        System.out.println("用户名：" + username);
        System.out.println("密码：" + password);
        System.out.println("电子邮箱：" + email);
    }

    private static String getEmail() {
        System.out.print("请输入邮箱：");
        String email = sacn.nextLine();
        int last = email.lastIndexOf("@");
        if (!(email.indexOf("@") < email.indexOf(".") && email.indexOf("@") > 0)) {
            throw new RuntimeException("邮箱设置错误!");
        }
        return email;
    }

    private static String getPassword() {
        System.out.print("请输入密码：");
        String password = sacn.nextLine();
        if (password.length() != 6) {
            throw new RuntimeException("密码长度错误！");
        }
        for (int i = 0; i < password.length(); i++) {
            if ('0' > password.charAt(i) || password.charAt(i) > '9') {
                throw new RuntimeException("密码必须为纯数字！");
            }
        }
        return password;
    }

    private static String getUsername() {
        System.out.print("请输入用户名：");
        String Username = sacn.nextLine();
        if (!(Username.length() >= 2 && Username.length() <= 4)) {
            throw new RuntimeException("用户名长度错误!");
        }
        return Username;
    }
}
