package inputstreamreadertest;

import java.io.*;

/**
 * @author muchen
 * @create 2022 - 11 - 2022/11/5 17:23
 *
 * 处理流之二：转换流的使用
 *
 * 1.转换流：
 *      InputStreamReader：将一个字节的输入流转换为字符的输入流
 *      OutputStreamWriter：将一个字符输出流转换为字节的输出流
 * 2.作用：提供字节流与字符流之间的转换
 *
 * 3.解码：字节、字节数组——>字符数组、字符串
 *   编码：字符数组、字符串--->字节、字节数组
 *
 *
 */
public class InputStreamReaderTest {
    public static void main(String[] args) {
        BufferedReader br = null;
        try {
//        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(
//               new File("D:\\java\\code\\JavaSenior\\JavaSenior\\day06\\chinese.txt")));
//        InputStreamReader isr = new InputStreamReader(bis,"UTF-8");
            InputStreamReader isr = new InputStreamReader(new FileInputStream(new File(
                    "D:\\java\\code\\JavaSenior\\JavaSenior\\day06\\chinese.txt")),"UTF-8");

            br = new BufferedReader(isr);
        String s1;
            while ((s1 = br.readLine()) != null){
                System.out.println(s1);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }

}
