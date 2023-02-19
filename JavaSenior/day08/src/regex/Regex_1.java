package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author muchen
 * @create 2022 - 11 - 2022/11/15 23:55
 * 正则表达式使用二
 */
public class Regex_1 {
    public static void main(String[] args) {
        String contant = "$%^$&*#$%abc()(";

        /*
        在Java中转义号为\\(双斜杠);
        常见转义符有：. * + () $ / \ ? [] ^ {}
         */
        //1.创建匹配的内容
        String regex = "\\$%";
        //2.创建正则表达式对象
        Pattern pattern = Pattern.compile(regex);
        //3.创建匹配器
        Matcher matcher = pattern.matcher(contant);
        //4，开始匹配
        while (matcher.find()){
            System.out.println("找到："+matcher.group(0));
        }
    }
}
