package exer;

/**
 * @author muchen
 * @create 2022 - 09 - 2022/9/26 20:10
 * <p>
 * 获取一个字符串在另一个字符传中出现的次数。
 * 比如：获取ab在afgsdgabgfsdabasfaab中出现的次数
 */
public class StringDemo {
    public static void main(String[] args) {
//        String[] split = new String("ababfgsdgabgfsdabasfababs").split("ab");
//        System.out.println(split.length);
//        System.out.println(Arrays.toString(split));

        //方法一：
        String s1 = new String("ababfgsdgabgfsdabasfababs");

        int num = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == 'a' && s1.charAt(i + 1) == 'b') {
                num++;
            }
        }
        System.out.println(num);


        int num1 = 0,index = 0;
        String sub = "ab";
        String s2 = new String("ababfgsdgabgfsdabasfababs");
        //方法二：
//        while ((index = s2.indexOf(sub)) != -1){
//            num1++;
//            s2 = s2.substring(index + sub.length());
//        }
        //方法三：对方法二的改进
        //indexOf中index 的含义为：从index位置开始查找是否存在sub字符串
        while ((index = s2.indexOf(sub,index)) != -1){
            num1 ++;
            index += sub.length();
        }

//        System.out.println(s2.indexOf(sub));
        System.out.println("**********"+num1);
    }
}
