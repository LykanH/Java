package course.coursetest;

/**
 * 交换string指定区间字符的顺序
 * @author muchen
 * @create 2022 - 09 - 2022/9/18 20:03
 */
public class StringReverse1 {
    public static void main(String[] args) {
        String string = "123456789";
        String consquence;
        try {
            System.out.println("最初状态：" + string.toString());
            consquence = reverse(1, 7, string);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }
        System.out.println("转换之后：" + consquence.toString());

    }

    private static String reverse(int start, int end, String string) {
        //进行异常处理：
        if(!(string.length() > 0 && start > 0 && end < string.length() && start < end)){
            throw new RuntimeException("数据异常");
        }


        char[] chars = string.toCharArray();
        char empt = ' ';
        for(int i = start,j = end; i < j;i++,j--){
            empt = chars[i];
            chars[i] = chars[j];
            chars[j] = empt;

        }
        return new String(chars);
    }
}