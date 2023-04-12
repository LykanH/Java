package test;

import org.junit.Test;

import java.io.*;

/**
 * @author muchen
 * @create 2022 - 11 - 2022/11/25 18:30
 * 将文本文件按行输出，并且每行前面加上行号。//在本moudle下的test4已经完成
 * 进阶：假设文本文件的编码格式为ANSI（国标码）,在完成上述任务
 */
public class Test7 {
    /*
    使用转换流
     */
    @Test
    public void test1(){
        InputStreamReader is = null;
        try {
            BufferedInputStream bi = new BufferedInputStream
                    (new FileInputStream(new File("D:\\java\\code\\JavaSenior\\JavaSenior\\day06\\chinese.txt")));
//            BufferedOutputStream br = new BufferedOutputStream
//                    (new FileOutputStream(new File("D:\\java\\code\\JavaSenior\\JavaSenior\\day06\\chinese.txt")));
            is = new InputStreamReader(bi);
            char[] chars = new char[100];
            int read;
            while ((read = is.read(chars)) != -1){
                System.out.println(new String(chars,0,read));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }  catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }






    }
}
