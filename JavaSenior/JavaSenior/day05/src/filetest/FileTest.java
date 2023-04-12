package filetest;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * @author muchen
 * @create 2022 - 11 - 2022/11/3 10:11
 * File类的使用
 * 1.File类的一个对象，代表一个文件或者一个文件目录（俗称：文件夹）
 * 2.File类声明在java.io包下
 */
public class FileTest {
    @Test
    public void test1() {
        //File类构造器的使用
        //1.File(String filePath)
        //2.File(String parentPath,String childPath)
        //3.File(File parentFile,String childPath)

        //相对路径、即在本Module文件夹下边新建一个hello.txt文件
        File file = new File("hello.txt");

        //绝对路径
        //双反斜杠是因为Java中的转义字符
        File file1 = new File("D:\\java\\code\\JavaSenior\\JavaSenior\\day05\\he.txt");
        System.out.println(file);
        System.out.println(file1);

        File file2 = new File("D:\\java\\code\\JavaSenior", "javas");
        System.out.println(file2);

        File file3 = new File(file2, "java.txt");
        System.out.println(file3);
    }

    @Test
    public void test2() {
        File file1 = new File("hello.txt");
        File file2 = new File("D:\\io\\hi.txt");

        //public String getAbsolutePath():获取绝对路径
        System.out.println("绝对路径" + file1.getAbsolutePath());
        //public String getPath():获取路径
        System.out.println("相对路径" + file1.getPath());
        //public String getName():获取名称
        System.out.println("名称：" + file1.getName());
        //public String getParent():获取上层目录文件路径，若无则返回null
        System.out.println("上层目录文件路径：" + file1.getParent());
        //public long length():获取文件长度，（即字节数）。不能获取目录的长度
        System.out.println("文件长度（字节）：" + file1.length());
        //public long lastModified():获取最后一次修改时间，即毫秒值
        System.out.println("最后修改时间：" + file1.lastModified());

        System.out.println();
        //file2
        System.out.println("绝对路径" + file2.getAbsolutePath());
        System.out.println("相对路径" + file2.getPath());
        System.out.println("名称：" + file2.getName());
        System.out.println("上层目录文件路径：" + file2.getParent());
        System.out.println("文件长度（字节）：" + file2.length());
        System.out.println("最后修改时间：" + file2.lastModified());
        System.out.println();

        File file3 = new File("D:\\java\\code");

        //public String[] list():获取指定目录下的所有文件或者文件目录的名称数组
        String[] list = file3.list();
        for (String string : list) {
            System.out.println(string);
        }
        System.out.println();
        //public File[] listFiles():获取指定目录下的所有文件或者文件目录的File数组
        File[] files = file3.listFiles();
        for (File file : files) {
            System.out.println(file);
        }


    }

    //public boolean renameTo(File des):把文件重命名为指定的文件路径
    //比如：file1.renameTo(file2)为例
    //  想要保证返回true，需要file1在硬盘中是存在的，file2不能在硬盘中存在
    @Test
    public void test3() {
        File file1 = new File("hello.txt");
        File file2 = new File("d:\\java\\io\\hi.txt");
        boolean renameTo = file2.renameTo(file1);       //简单理解为剪切+重命名（re:重命名，To:移动）
        System.out.println(renameTo);
    }

    @Test
    public void test4() throws IOException {
        //public boolean createNewFile():创建文件。若文件存在则不创建返回false

        File file = new File("hi.txt");
        if (file.createNewFile()) {
            System.out.println("创建成功！");
        } else {
            System.out.println("创建失败！");
        }

        //public boolean mkdir():创建文件目录，若此文件目录存在则不创建，若目录的上层目录不存在则不创建
        //public boolean mkdirs():创建文件目录。若上层文件目录不存在，一并创建
        File file1 = new File("d:\\java\\io\\test2\\test1_1");
        File file2 = new File("d:\\java\\io\\test2\\test1_2");

        if (file1.mkdir()) {
            System.out.println("文件夹一创建成功");
        } else {
            System.out.println("文件夹一创建失败");
        }
        if (file2.mkdirs()) {
            System.out.println("文件夹二创建成功");
        } else {
            System.out.println("文件夹二创建失败");
        }

    }

    @Test
    public void test5() {
        File file = new File("d:\\java\\io\\test2\\test1_2");
        System.out.println("删除成功？" + file.delete());
    }
}
