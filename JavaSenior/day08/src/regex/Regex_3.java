package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author muchen
 * @create 2022 - 11 - 2022/11/16 0:33
 * 选择匹配符
 */
public class Regex_3 {
    public static void main(String[] args) {
        String contain = "abyc1tyangcAB杨Ci75f";

        //创建匹配规则
        String regex = "yang|y|杨";
        //实例化正则表达式
        Pattern pattern = Pattern.compile(regex);
        //创建匹配器
        Matcher matcher = pattern.matcher(contain);
        while (matcher.find()){
            System.out.println("找到 "+matcher.group(0));
        }
    }
}
