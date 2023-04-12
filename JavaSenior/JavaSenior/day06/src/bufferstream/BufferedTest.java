package bufferstream;

import org.junit.Test;

import java.io.*;

/**
 * @author muchen
 * @create 2022 - 11 - 2022/11/5 13:13
 */
public class BufferedTest {
    /**
     * //使用缓冲流，实现非文本文件的复制
     *  1.处理流之一 ： 缓冲流
     *  BufferedInputStream
     *  BufferedOutputStream
     *  BufferedReader
     *  BufferedWriter
     *
     *  2.作用：提高流的读取、写入速度
     *  底稿读写速度的原因：内部提供了一个缓冲区
     *
     *  3.处理流，就是套接在已有的基础之上 。
     *
     */

    @Test
    public void bufferedStreamTest() {
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            //1.造文件
            File srcFile = new File("photo1.jpg");
            File desFile = new File("photo3.jpg");

            //2.造流  (缓冲流相当于在节点流外边包裹的一层流，因此需要创建节点流)
            //2.1 造节点流
            FileInputStream fis = new FileInputStream(srcFile);
            FileOutputStream fos = new FileOutputStream(desFile);
            //2.2 造缓冲流
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);

            //读取、写入数据
            byte[] bytes = new byte[10];
            int read;
            while ((read = bis.read(bytes)) != -1) {
                bos.write(bytes, 0, read);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            //关闭流
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public void copyFileWithBuffer(String src, String des) {
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            //1.造文件
            File srcFile = new File(src);
            File desFile = new File(des);

            //2.造流  (缓冲流相当于在节点流外边包裹的一层流，因此需要创建节点流)
            //2.1 造节点流
            FileInputStream fis = new FileInputStream(srcFile);
            FileOutputStream fos = new FileOutputStream(desFile);
            //2.2 造缓冲流
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);

            //读取、写入数据
            byte[] bytes = new byte[1024];
            int read;
            while ((read = bis.read(bytes)) != -1) {
                bos.write(bytes, 0, read);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            //关闭流
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    @Test
    public void test3() {
        long start = System.currentTimeMillis();

        String src = new String("E:\\必剪\\视频\\video1.mp4");
        String des = new String("E:\\必剪\\视频\\video3.mp4");
        copyFileWithBuffer(src, des);

        System.out.println("传输完毕！");


        long end = System.currentTimeMillis();
        System.out.println("花费时间为：" + (end - start));
    }


    @Test
    public void test4(){
//        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(new File("E:\\必剪\\视频\\video1.mp4")));
//        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(new File("E:\\必剪\\视频\\video2.mp4")));

        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            br = new BufferedReader(new FileReader(new File("chinese.txt")));
            bw = new BufferedWriter(new FileWriter(new File("chinese_1.txt"),true));


            //缓冲流常用方法  bis.readLine();只适用于字符流 不适用于字节流
            //***************************************************
            String line = null;
            while ((line = br.readLine()) != null){
                bw.write(line + "\n");
            }
            System.out.println("传输完毕！");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (br != null)
                br.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }finally {
                try {
                    if (bw != null)
                    bw.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }
}
