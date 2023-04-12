package fileexer;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * @author muchen
 * @create 2022 - 11 - 2022/11/3 19:20
 * <p>
 * <p>
 * File类的使用、练习
 */
public class FileExer {
    public static void main(String[] args) {
        File file = new File("picture1.png");
        System.out.println(file.getAbsolutePath());
    }
    @Test
    public void test1() throws IOException {
        /*利用File构造器、new一个文件目录file
           ① 在其中创建多个文件和目录
           ② 编写方法实现删除file中指定文件的操作
        */
        File file = new File("D:\\java\\io\\file");
        File file1 = new File("D:\\java\\io\\file\\file_1");
        File file2 = new File("D:\\java\\io\\file\\hello.txt");
        File file3 = new File("D:\\java\\io\\file\\hi.txt");
        System.out.println("创建成功？" + file.mkdir());
        System.out.println("创建成功？" + file1.mkdir());

//        System.out.println("文件长度为：" +file2.length());

        System.out.println("创建成功？" + file2.createNewFile());
        System.out.println("创建成功？" + file3.createNewFile());
//        rmdir(file,"hello.txt");//删除file文件夹下的"hello.txt"文件

    }

    //第一个file1为文件目录，第二个file2为文件目录中的文件
    public void rmdir(File file1, String file2) {
//        File file = new File(file1,file2);
        if (file1.exists()) {

            System.out.println("文件是否删除成功？" + new File(file1, file2).delete());
        } else {
            System.out.println("不存在该文件！");
        }
    }

    @Test
    public void test2() throws IOException {
        //创建一个与file(hello.txt)同目录下的另外一个文件，文件名为haha.txt
        File file = new File("d:\\java\\io\\file\\hello.txt");
        file.createNewFile();
        //同目录下，即先获得file的父目录之后在创建haha.txt
        File file1 = new File(file.getParent(),"haha.txt");
        file1.createNewFile();
    }

    @Test
    public void test3() throws IOException {
        //判断是否有后缀名为.jpg的文件，如果有，就输出该文件名称
        File file1 = new File("d:\\java\\io\\file\\photo.jpg");
        file1.createNewFile();
        File file2 = new File("d:\\java\\io\\file\\photo_1.jpg");
        file2.createNewFile();
        File file3 = new File("d:\\java\\io\\file");
        File[] files = file3.listFiles();
        for (File file : files){
            if (file.getName().contains(".jpg")){
                System.out.println(file.getName());
                System.out.println(file.getAbsolutePath());
            }
        }
    }
    public void test4(){
        //遍历指定目录所有文件名称，包括子文件目录中的文件
        File file = new File("D:\\java\\io\\file");
        File[] files = file.listFiles();
        for (File file1 : files){
            if (file.isDirectory()){

            }
        }

        //拓展1:并计算指定目录占用空间的大小
        //拓展2:删除指定文件目录及其下所有文件


    }
}
