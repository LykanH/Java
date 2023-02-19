package day01;

/**
 * @author muchen
 * @create 2022 - 11 - 2022/11/17 23:02
 * 给定字符串 s和字符串数组words, 返回words[i]中是s的子序列的单词个数。
 *
 * 字符串的 子序列 是从原始字符串中生成的新字符串，可以从中删去一些字符(可以是none)，而不改变其余字符的相对顺序。
 *
 * 例如， “ace” 是 “abcde” 的子序列。
 *
 * 示例 1:
 * 输入: s = "abcde", words = ["a","bb","acd","ace"]
 * 输出: 3
 * 解释: 有三个是s 的子序列的单词: "a", "acd", "ace"。
 *
 * Example 2:
 * 输入: s = "dsahjpjauf", words = ["ahjpjau","ja","ahbwzgqnuk","tnmlanowax"]
 * 输出: 2
 *
 */
public class NumMatchingSubseq {
    public static void main(String[] args) {
        System.out.println(numMatchingSubseq("gggggggggggq",
                new String[]{"gq", "gq", "gq", "gq", "gq", "gq", "gq", "gq",}));
    }

    public static int numMatchingSubseq(String s, String[] words) {
        //使用ArrayList
        int ans = 0,temp = 0;
        // for(String s1 : words){
        for(int k = 0;k < words.length;k++){
            String s1 = words[k];
            if(k > 0 && (words[k-1].equals(s1))){
                ans += temp;
                continue;
            }
            int i = 0,j=0;
            while(i < s1.length() && j < s.length()){
                if(s1.charAt(i) == s.charAt(j)){
                    i++;j++;
                }else{
                    j++;
                    temp = 0;
                }
                if(i == s1.length()){
                    temp = 1;
                    ans += temp;
                    break;
                }
            }
        }
        return ans;
    }
}
