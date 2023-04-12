package fileinputstream;

import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author muchen
 * @create 2022 - 11 - 2022/11/5 10:43
 * <p>
 * 将两张图片进行复制操作  (FileWriter和FileReader是队字符流进行处理的)，而图片属于字节流，需要使用
 * FileInputStrea和FileOutputStream来进行处理
 * <p>
 * 结论：
 * 1.对于文本文件(.txt,.java,.c,.cpp)，使用字符流处理
 * 2.对于非文本文件(.jpg,.mp3,.mp4,.avi,.doc,.ppt)，使用字节流处理
 * 其中 使用FileInputStream和FileOutputStream来读取文本文件可能出现乱码，但是可以对文本文件尽行复制
 * 使用FileWriter和FileReader来处理非文本文件会导致资源损坏
 */
public class FileInputStream {
//    @Test
//    public void test1() {
//        java.io.FileInputStream fileInputStream = null;
//        FileOutputStream fileOutputStream = null;
//        //实例化两个file类，其中一个为需要复制的图片  另外一个为硬盘中不存在的图片文件
//        try {
//            File photo1 = new File("photo1.jpg");
//            File photo2 = new File("photo2.jpg");
//
//            //实例化流，处理图片文件时需要用到FileInputStrea和FileOutputStream
//            fileInputStream = new java.io.FileInputStream(photo1);
//            fileOutputStream = new FileOutputStream(photo2);
//
//            //读出文件中的数据（字节）
//            byte[] bytes = new byte[100];
//            int length;
//            while ((length = fileInputStream.read(bytes)) != -1) {
//                fileOutputStream.write(bytes, 0, length);
//            }
//            System.out.println("复制成功！");
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        } finally {
//            //关闭字节流
//            try {
//                if (fileInputStream != null) {
//                    fileInputStream.close();
//                }
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            } finally {
//                try {
//                    if (fileOutputStream != null) {
//                        fileOutputStream.close();
//                    }
//                } catch (IOException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//        }
//    }

    //将复制非文本文件进行的方法进行封装处理
    public void test2(String src,String des) {
        java.io.FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        //实例化两个file类，其中一个为需要复制的图片  另外一个为硬盘中不存在的图片文件
        try {
            File photo1 = new File(src);
            File photo2 = new File(des);

            //实例化流，处理图片文件时需要用到FileInputStrea和FileOutputStream
            fileInputStream = new java.io.FileInputStream(photo1);
            fileOutputStream = new FileOutputStream(photo2);

            //读出文件中的数据（字节）
            byte[] bytes = new byte[1024];
            int length;
            while ((length = fileInputStream.read(bytes)) != -1) {
                fileOutputStream.write(bytes, 0, length);
            }
            System.out.println("复制成功！");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            //关闭字节流
            try {
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            } finally {
                try {
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
    //对封装起来的复制操作进行测试
    @Test
    public void test3(){
        long start = System.currentTimeMillis();

        String src = "E:\\必剪\\视频\\video1.mp4";
        String des = "E:\\必剪\\视频\\video2.mp4";
        test2(src,des);


        long end = System.currentTimeMillis();
        System.out.println("所用时间为：" + (end - start));

    }
}