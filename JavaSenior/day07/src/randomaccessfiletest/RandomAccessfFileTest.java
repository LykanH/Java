package randomaccessfiletest;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @author muchen
 * @create 2022 - 11 - 2022/11/8 18:21
 *
 *
 * RandomAccessFile的使用
 * 1.RandomAccessFile直接继承于java.lang.object类，实现了DateInput和DateOutput接口
 * 2.RandomAccessFile既可以作为一个输入流也可以作为一个输出流
 *
 * 3.如果RandomAccessFile作为输出流时，写到的文件如果不存在，则在执行的过程中自动创建该文件
 *   如果写到的文件存在，则会对原有的文件内容进行覆盖。（默认情况下，从头对源文件内容进行覆盖）
 *
 *
 * RandomAccessFile类有两个构造函数，其实这两个构造函数基本相同，只不过是指定文件的形式不同
 * 一个需要使用String参数来指定文件名，一个使用File参数来指定文件本身。除此之外，
 * 创建RandomAccessFile对象时还需要指定一个mode参数，该参数指定RandomAccessFile的访问模式，一共有4种模式。
 *
 * "r" :  以只读方式打开。调用结果对象的任何 write 方法都将导致抛出 IOException。
 * "rw": 打开以便读取和写入。
 * "rws": 打开以便读取和写入。相对于 "rw"，"rws" 还要求对“文件的内容”或“元数据”的每个更新都同步写入到基础存储设备。
 * "rwd" : 打开以便读取和写入，相对于 "rw"，"rwd" 还要求对“文件的内容”的每个更新都同步写入到基础存储设备。
 *
 */
public class RandomAccessfFileTest {
    @Test
    public void test1(){
        RandomAccessFile raf = null;
        RandomAccessFile raf1 = null;
        try {
            raf = new RandomAccessFile(new File("hello.txt"),"rw");
            raf1 = new RandomAccessFile(new File("hello.txt"),"r");

            raf.write("abcdefg".getBytes());
            raf.seek(3);//将文件记录指针定位到pos位置，从pos位置开始覆盖源文件
            raf.write("xyz".getBytes());
            System.out.println("写入成功");

            int read;
            byte[] bytes = new byte[3];
            String s1 ;
            while (((read = raf1.read(bytes)) != -1)){
                s1 = new String(bytes,0,read);
//                System.out.print("zzz");
                System.out.print(s1);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (raf!=null) {
                try {
                    raf.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if (raf1 != null){
                try {
                    raf1.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
    //在hello.txt文件中的abc后插入xyz其余内容及顺序不变
    //提示：raf.seek(3);//将文件记录指针定位到pos位置，从pos位置开始覆盖源文件

    //下例：通过相关操作，实现RandomAccessFile插入数据的效果
    @Test
    public void test2() {
        RandomAccessFile raf = null;
        try {
            raf = new RandomAccessFile(new File("hello1.txt"),"rw");

            raf.seek(3);
            int read;
            StringBuffer stringBuffer = new StringBuffer((int) new File("hello1.txt").length());
            byte[] bytes = new byte[5];
            while ((read = raf.read(bytes))!=-1){
                stringBuffer.append(new String(bytes,0,read));
            }

            //调回指针，指针会跟着write和read进行移动
            raf.seek(3);
            raf.write("xyz".getBytes());

            raf.write(stringBuffer.toString().getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (raf != null) {
                try {
                    raf.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
