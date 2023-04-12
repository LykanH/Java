package exer;

/**
 * @author muchen
 * @create 2022 - 10 - 2022/10/20 20:57
 */
class Solution {
//    public int lengthOfLongestSubstring(String s) {

    //        return maxString(s);
//    }
    public static void main(String[] args) {
        String s = "abcde";
//        System.out.println(s.substring(1,2));
        System.out.println(maxString(s));
    }

    public static int maxString(String s) {
        int a = 0,b=0;
        for (int i = 0; i < s.length(); i++) {
            for (int x = 0, y = s.length() - i; y < s.length(); x++, y++) {
                String s_1 = s.substring(x, y);
                for (int j = 0; j < s_1.length(); j++) {
                    String s_2 = s_1.substring(j, j + 1);
                    if (s_1.indexOf(s_2) == s_1.lastIndexOf(s_2)) {
                        return s_1.length();
                    }
                }
            }
        }
        return 0;
    }
}
