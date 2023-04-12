package inputstreamreadertest;

import org.junit.Test;

import java.io.*;

/**
 * @author muchen
 * @create 2022 - 11 - 2022/11/5 21:34
 *
 * InputStreamReader:将输入的字节流转化为字符流。解码 第二个参数可以指明用什么编码方式读
 *
 */
public class InputStreamReaderTest_1 {
    @Test
    public void test1(){

        //InputStreamReader 的使用实现字节的输入流到字符输入流的转换

        BufferedInputStream bis = null;
        InputStreamReader isr = null;
        try {
            bis = new BufferedInputStream(new FileInputStream(new File("chinese.txt")));
            //参数二指明了字符集，具体使用那个取决于读取的文件当初使用的字符集
            isr = new InputStreamReader(bis,"utf-8");//不带第二个参数时代表使用系统默认的字符集
//            bis = new BufferedInputStream(new InputStreamReader(new FileInputStream(new File(""))));
            int read;
            String s1 = null;
            char[] chars = new char[10];
            while ((read = isr.read(chars)) != -1){
//                s1 = new String(bytes,0,read);
//                System.out.println(s1);
                s1 = new String(chars,0,read);
                System.out.print(s1);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (isr != null) {
                try {
                    isr.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    @Test
    public void test2(){
        InputStreamReader isr = null;
        OutputStreamWriter osw = null;
        try {
            //将一个文件从utf-8编码转到gbk编码
            FileInputStream fis = new FileInputStream(new File("chinese.txt"));
            FileOutputStream fos = new FileOutputStream(new File("chineseChange.txt"));

            isr = new InputStreamReader(fis,"utf-8");
            osw = new OutputStreamWriter(fos,"gbk");

            int read;
            char[] chars = new char[100];
            while ((read = isr.read(chars)) != -1){
                osw.write(chars,0, chars.length);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {

            try {
                if (isr != null)
                isr.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }finally {
                try {
                    if (osw != null)
                    osw.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }


    }
}
