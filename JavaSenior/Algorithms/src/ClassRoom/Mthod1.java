package ClassRoom;

/**
 * 将密码按照行排为矩阵，然后按照列输出进行加密
 *
 * @author muchen
 * @create 2022 - 09 - 2022/9/19 19:21
 */
public class Mthod1 {
    public static void main(String[] args) {
        String secret = "qwertyuiopasdfghjklzxcvbnm";
        char[] chars = secret.toCharArray();
//        System.out.println("希望进行几列的加密方式：");
        System.out.println("按照5列加密方式");
//        int list = new Scanner(System.in).nextInt();
        int list = 5;
//        inSecret(chars, list);


        String s = outSecret(chars, list,secret.length());
        System.out.println(s);
    }

    //加密
    private static char[][] inSecret(char[] chars, int list) {
        int length = (chars.length - 1), m = 0;
        char[][] chars1 = new char[(length / list + 1)][list];
        for (int i = 0; i < (length / list + 1); i++) {
            for (int j = 0; j < list; j++) {
                if (m <= length) {
                    chars1[i][j] = chars[m++];

                }else {
                    return chars1;
                }
            }
        }
        return chars1;
    }

    private static String outSecret(char[] chars, int list, int length) {
        int m = 0;
        char[] console = new char[length - 1];
        char[][] chars1 = inSecret(chars, list);
        String con = null;
        for (int j = 0; j < chars1.length; j++) {
            for (int i = 0; i < chars1[0].length; i++) {
                console[m++] = chars1[i][j];
                if (m == length - 1) {
                    con = new String(console);
                    return con;
                }
            }
        }
        return con;
    }
}
