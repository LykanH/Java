package otherstreamtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author muchen
 * @create 2022 - 11 - 2022/11/5 19:31
 * 其他流的使用
 * 1.标准输入、输出流
 * 2.打印流
 * 3.数据流
 *
 */
public class OtherStreamTest {

    /*
    1.标准的输入、输出流
    System.in :标准的输入流、默认从键盘输入       //类型为字节流 InputStream
    System.out : 标准的输出流、默认从控制台输出    //           PrintStream

    1.2
    System类的setIn(InputStream is) /setOut(PringStream ps)方式重新指定输入和输出的流
     */
    public static void main(String[] args) {
        /*
        练习：从键盘输入字符串，要求将读取到的整行字符串转成大写输出，然后继续进行输入操作
        直到输入"e"或者"exit"时退出程序

        方法一：使用scanner实现
        方法二：使用System.in实现，System.in---> 转换流---> BufferReader的readLine();
         */

        BufferedReader br = null;
        try {
            InputStreamReader isr = new InputStreamReader(System.in);
            br = new BufferedReader(isr);

            String s1 = null;
            while (true){
                System.out.print("请输入字符串:");
                s1 = new String(br.readLine());
                if ("e".equalsIgnoreCase(s1) || "exit".equalsIgnoreCase(s1)){
                    System.out.println("程序退出！");
                    break;
                }
                System.out.print("转换后为：");
                System.out.println(s1.toUpperCase());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (br != null)
                br.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
