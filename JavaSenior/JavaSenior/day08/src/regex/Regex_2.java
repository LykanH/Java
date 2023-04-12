package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author muchen
 * @create 2022 - 11 - 2022/11/16 0:13
 */
public class Regex_2 {
    public static void main(String[] args) {
        String contain = "abc1tcABCi75f";

        //创建匹配规则
//        String regex = "[a-z]";     //[a-z]说明可以匹配a-z中任意一个字符
//        String regex = "(?i)abc";//实现不区分大小写    a(?i)bc:表示bc不区分大小写 a((?i)b)c 表示只有b不区分大小写
//        String regex = "[0-9]";//匹配0到9任意一个数字
//        String regex = "(?i)[^a-z]";//表示匹配不是a-z中的字符.不区分大小写
        String regex = "[^a-z]";//区分大小写
//        String regex = "[0-9]";

        //实例化正则表达式  //compile 编写
        Pattern pattern = Pattern.compile(regex);
        //创建匹配器     //matcher  匹配器
        Matcher matcher = pattern.matcher(contain);
        while(matcher.find()){
            System.out.println("找到 " + matcher.group(0));
        }
    }
}
