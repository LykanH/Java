package filereadwritertest;

import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author muchen
 * @create 2022 - 11 - 2022/11/4 22:38
 * <p>
 * <p>
 *
 *     节点流、缓冲流、转换流、标准输入输出流、打印流、数据流、对象流、随机存取文件流
 * 一、流的分类
 * 1.操作数据单位：字节流、字符流
 * 2.数据的流向：输入流、输出流
 * 3.流的角色：节点流、处理流
 * <p>
 * 二、流的体系结构
 * 抽象基类             节点流                         缓冲流（处理流的一种）
 * InputStream          FileInputStream                 BufferInputStream
 * OutputStream         FileOutputStream                BufferOutputStream
 * Reader               FileReader (字符流)             BufferReader
 * Writer               FileWriter                      BufferWriter
 */
public class FileReadWriterTest {

    //1.read()的理解：返回读入的一个字符。如果达到文件末尾，而返回-1
    //2.异常的处理：为了保证流资源一定可以执行关闭操作，则一般使用try-catch-finally来处理异常
    @Test
    public void test1() {
        FileReader fileReader = null;
        try {
            File file1 = new File("hello.txt");//此时绝对路径为当前module下的路径
//        System.out.println(file1.getAbsolutePath());//而在main中相对路径为该工程的下的文件

            //提供具体读文件的流
            fileReader = new FileReader(file1);

            //方式一
//        int read = fileReader.read();//流的返回值为一个整数类型，当返回值为-1时，则说明文件已读完
//        while (read != -1){
//            System.out.print((char) read);
//            read = fileReader.read();
//        }

            //方式二： 语法上的优化，并非效率上的优化
            int read;
            while ((read = fileReader.read()) != -1) {
                System.out.print((char) read);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                fileReader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }


    }

    @Test
    public void test2() throws IOException {//读入时使用char[]
        //1.File类的实例化
        File file1 = new File("hello.txt");

        //2.FileReader流的实例化
        FileReader fileReader = new FileReader(file1);

        //3.读入的操作
        char[] chars = new char[6];
        int read;//read的值为char中字符的个数
        while ((read = fileReader.read(chars)) != -1) {
//            for (char c : chars){
//                System.out.print(c);
//            }//错误的写法，，
            //方式一
//            for (int i = 0;i<read;i++){
//                System.out.print(chars[i]);
//            }

            //方式二
            String string = new String(chars, 0, read);
            System.out.print(string);
        }

    }

    @Test
    public void test3() {
        //向硬盘中写入数据
        /*
        输出的操作，对应的File，可以不存在。
            如果不存在，在输出的过程中会自动创建此文件
            如果存在，如果使用的流的构造器是FileWriter(file，false) / FileWriter(file):对原有文件的覆盖
                     如果使用的流的构造器是FileWriter(file，true)：不会对原有文件覆盖，而是在原有文件基础上追加内容
         */
        FileWriter fw = null;
        //1.实例化需要写入的文件
        try {
            File file1 = new File("hello1.txt");//此时该module下没有该文件，但在写入的时候Java会自动创建(不会报错)

            //2.创建写入的流
            fw = new FileWriter(file1);

            //3.写入数据的操作
            fw.write("I love China\n");
            fw.write("I am Chinese");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (fw != null) {
                try {
                    fw.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        //关闭流
    }

    @Test
    public void test4() {
        FileReader fr = null;
        FileWriter fw = null;
        File file3 = new File("hello2.txt");
        //先把一个文件读入内存，然后再将其写入另外一个文件中
        try {
            File file1 = new File("hello.txt");
            File file2 = new File("hello1.txt");


            fr = new FileReader(file1);
            fw = new FileWriter(file2, true);
//             fw = new FileWriter()
            char[] chars = new char[6];
            int read;
            String string;
            while ((read = fr.read(chars)) != -1) {
                //方式一
//                string = new String(chars,0,read);
//                fw.write(string);

                //方式二：每次写入len个字符
                fw.write(chars, 0, read);
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            //错误的写法，因为关闭第一个流的时候如果有异常，则第二个流不会关闭
//            try {
//                if (fr != null) {
//                    fr.close();
//                }
//                if (fw != null){
//                    fw.close();
//                }
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }

            //方式一
            try {
                if (fr != null) {
//                    FileReader fw1 = new FileReader(file3);
//                    System.out.println("第一个close执行");
                    fr.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            //上一个try-catch如果抛出异常，下边的try-catch也会继续执行
//            System.out.println("第二段");
            try {
                if (fw != null) {
                    fw.close();
//                    System.out.println("第二个close执行");
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            //方式二
//            try {
//                if (fr != null) {
//                    fr.close();
//
//                }
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }finally {
//                try {
//                    if (fw != null)
//                    fw.close();
//                } catch (IOException e) {
//                    throw new RuntimeException(e);
//                }
//            }
        }

    }

}
