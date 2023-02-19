package ClassRoom;

/**
 * @author muchen
 * @create 2022 - 09 - 2022/9/9 11:16
 */
public class pwdEncrypt1 {
    static char[] a = new char[]{'h', 'e', 'l', 'l', 'o', 'w', 'o', 'r', 'l', 'd'};

    public static void main(String[] args) {
        encrypt encrypt = new encrypt(a);
        encrypt.enc();

    }
}

class encrypt {
//    char[] c1;
    char[] c1 = new char[10];
    public encrypt(char[] chars) {
        c1.equals(chars);
    }

    private int[] q = new int[]{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1};
    private int num = 0;

    //通过随机获取c1.length个整型随机数
    public void enc() {
        boolean flag = true;
//        System.out.println(c1.length + c1[1]);
//        for (int i = 0; i < c1.length; i++) {

        while (num != c1.length) {
            int rand = (int) (Math.random() * 10);
//            System.out.println(rand);             ********
            for (int j = 0; j <= num; j++) {
                if (rand == q[j]) {
                    flag = false;
//                    System.out.println(j + "+" + q[j]);
//                    System.out.println("****"+j + "+" + num);
                    break;
                }
                break;
            }
            if (flag == true) {
                q[num++] = rand;
//                System.out.println
            }
        }
        System.out.println(q);
    }

}
