package objectinputoutputstreamTest;

import org.junit.Test;

import java.io.*;

/**
 * @author muchen
 * @create 2022 - 11 - 2022/11/6 21:33
 *
 * 对象流的使用
 * ObjectInputStream 和 ObjectOutputStream
 *
 * 作用：用于存储和读取基本数据类型数据或对象的处理流
 */
public class ObjectInputStreamTest {
    //需要先对对象进行序列化，即ObjectOutputStream(),将对象数据读入硬盘
    //序列化过程：将内存中的Java对象保存到磁盘中或通过网络传输出去,也可以保存基本数据类型的数据
    //使用ObjectOutputStream
    @Test
    public void test1(){
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(new File("object.dat"))));

            oos.writeDouble(15.13);
            oos.flush();
            oos.writeDouble(1455.143);
            oos.flush();
            oos.writeObject(new String("我是一个中国人Chinese"));
            oos.flush();
            oos.writeObject(new Person("张三",123));
            oos.flush();

            //加入自定义类的对象(自定义类必须实现可序列化（Serial）接口，同时
            // )

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (oos!=null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    @Test
    public void test2(){
        //反序列化：将磁盘中的对象还原为内存中的一个Java对象
        //使用ObjectInputStream来实现、字节流
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(new File("object.dat")));

            //从序列化的文件中提取元素需要按照放入的顺序取出，如果顺序不一致，会类型不匹配报错
            double d1 = ois.readDouble();
            double d2 = ois.readDouble();
            String s1 =  (String)ois.readObject();
            Person p1 = (Person)ois.readObject();
            System.out.println(s1 + d1 + " :" + d2 + p1);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (ois != null)
                ois.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
