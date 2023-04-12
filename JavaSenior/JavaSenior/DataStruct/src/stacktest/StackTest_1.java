package stacktest;

import java.util.Stack;

/**
 * @author muchen
 * @create 2022 - 11 - 2022/11/11 17:04
 *
 * Java API 中栈对象的创建与使用，栈的初级理解
 * 使用Java工具类
 */
public class StackTest_1 {
    public static void main(String[] args) {
        Stack<String> st = new Stack<>();
        st.add("tom");
        st.add("amy");
        st.add("DM");
        st.add("smith");

        while (st.size() > 0){//栈的大小随着栈内元素的pop而减小
            System.out.println(st.pop());
        }
    }
}
