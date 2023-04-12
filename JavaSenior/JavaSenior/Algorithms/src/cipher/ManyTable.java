package cipher;

/**
 * @author muchen
 * @create 2022 - 09 - 2022/9/23 10:42
 * 多表代换，将明文分片为和加密密文一样长度的代码块，再将其一一对应进行置换
 */
public class ManyTable {
    public static void main(String[] args) {
        String s1 = "HELLOJAVATESTES";
        char[] chars = s1.toCharArray();    //明文

//        System.out.println("输入三个字母密钥");
//        int script = new Scanner().nextInt();

        char[] script = new char[]{'f', 'a', 'c'};
        System.out.print("加密后的结果为：");
        System.out.println(manyTable(chars, script));
    }

    private static String manyTable(char[] chars, char[] script) {
        for (int i = 0; i < chars.length; ) {
            for (int j = 0; j < script.length; j++) {
//                if (chars [i] > 'A' && chars[i] < 'Z'){
//
//                }else if (chars [i] > 'a' && chars[i] < 'z'){
//
//                }
//                System.out.println(script[j] - 'a');
                chars[i++] += (script[j] - 'a');
//                System.out.println(chars[i]);
            }
        }
//        System.out.println(Arrays.toString(chars));
        return new String(chars);
    }
}
