package ClassRoom;

/**
 * @author muchen
 * @create 2022 - 09 - 2022/9/19 20:12
 * 按照给定的加密数组来加密
 */
public class Mthod2 {
    public static void main(String[] args) {
        String s1 = "1234567890";
        char[] chars = new char[]{6,9,4,1,2,0,7,3,8,5};
//        int m = 0,list = 3;
//        int line = s1.length() % 3 > 0 ? (s1.length() / 3 + 1) : (s1.length());
////        while
//        char[] chars = new char[s1.length()];

        //该方法用于加密
        String con = swap(s1,chars);
        System.out.println(con);
    }

    private static String swap(String s1, char[] chars) {
        char[] charArray = s1.toCharArray();
        char[] empt = new char[s1.length()];

        for (int i = 0;i < chars.length;i++){
           empt[i] = charArray[(int)chars[i]];
        }
        return new String(empt);
    }

}
