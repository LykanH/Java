package test;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author muchen
 * @create 2022 - 11 - 2022/11/13 21:57
 */
public class Test4 {
    @Test
    /**
     * 1.编程题Homework01.java 5min
     * (1)在判断e盘下是否有文件夹mytemp ,如果没有就创建mytemp
     * (2)在e:llmytemp自录下，创建文件hello.txt
     * (3)如果hello.txt已经存在，提示该文件已经存在，就不要再重复创建了
     */
    public void test1() {
        File file1 = new File("E:\\mytemp");
        File file2 = new File("E:\\mytemp\\hello.txt");
        System.out.println(file1.exists());//存在返回true
        if (!file1.exists()){
            file1.mkdir();
        }
        if (file2.exists()){
            System.out.println("文件已经存在！");
        }else {
            try {
                file2.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            System.out.println("文件创建成功!");
        }
    }
    @Test
    public void test2(){
        /**
         * 使用BufferReader读取一个文本文件，为每行加上行号，
         * 再连同内容一并输入到屏幕上
         */
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(new File("D:\\java\\code\\JavaSenior\\JavaSenior\\day06\\chinese.txt")));
            //正确写法
            String s1 = "";
            int i = 1;
            while ((s1 = br.readLine())!=null){
                System.out.println((i++) + "." + s1);
            }

            //错误写法
//            char[] chars = new char[100];
//            int read;
//            while ((read = br.read(chars))!=-1){
//                System.out.println(new String(chars,0,read));
//                System.out.println(br.readLine());
//            }
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
