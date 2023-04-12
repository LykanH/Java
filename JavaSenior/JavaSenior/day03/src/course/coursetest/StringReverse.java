package course.coursetest;

/**
 *
 * 交换字符串中的第2到第n-1个字符的顺序
 * *************自己写的*****************
 *
 * @author muchen
 * @create 2022 - 09 - 2022/9/18 17:36
 */
public class StringReverse {
    public static void main(String[] args) {
        String s1 = "1234567";
        StringBuffer s2 = new StringBuffer(s1);
        int start = 1,end = s1.length() - 2;
        stringReverse(s2,start,end);
    }

    private static void stringReverse(StringBuffer s1, int start, int end) {
        String empt;
        while (start < end){
            empt = s1.substring(start,start + 1);
            s1.replace(start,start + 1,s1.substring(end,end + 1));
            s1.replace(end,end + 1,empt);
            start++;
            end--;
        }
        System.out.println(s1.toString());
    }
}
