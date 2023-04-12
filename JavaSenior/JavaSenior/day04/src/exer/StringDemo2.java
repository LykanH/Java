package exer;

/**
 * ********************************************************
 * @author muchen
 * @create 2022 - 09 - 2022/9/27 21:39
 * 获取两个字符串中最大相同字符串。比如：
 * str1 = "sdfshfgjhkhjklkjgdfd" str2 = "asdfgjhkhff"
 * 提示：将短的那个串进行长度依次递减的字串与较长的串比较
 */
public class StringDemo2 {
    public static void main(String[] args) {
        String str1 = "sdfshfgjhkhjklkjgdfd";
        String str2 = "asdfgjhkhff";
        System.out.println(compareStr(str1, str2));
    }

    private static String compareStr(String str1, String str2) {
        String maxStr = str1.length() >= str2.length() ? str1 : str2;
        String minStr = str1.length() < str2.length() ? str1 : str2;
        
        for (int i = 0; i < minStr.length(); i++) {
            for (int x = 0,y = minStr.length() - i;y <= minStr.length();x++,y++){
                if (maxStr.contains(minStr.substring(x,y))){
                    return minStr.substring(x,y);
                }
            }

        }
        return null;
    }
}
