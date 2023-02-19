package reflection;

import org.junit.Test;

import java.util.Random;

/**
 * @author muchen
 * @create 2022 - 12 - 2022/12/19 14:03
 *
 * 使用反射创建对应的运行时类对象
 */
public class NewInstanceTest {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        Class<Person> clazz = Person.class;
        /*
        newInstance():使用该方法调用的是类中的空参构造器，顾名思义，如果没有空参构造器活着空参构造器权限修饰符不足，则
                      会报错。
         */
        Person person = clazz.newInstance();//因为泛型为Person类，所以clazz新建的对象也默认为Person类
        System.out.println(person);
    }

    @Test
    public void test1(){
        //体会反射的用处：创建运行时类对象，
        //即：在编译前并不知道要创建哪个类的对象，只有运行之后才知道
//        int i = (int)(Math.random()*3+1);
        for (int j = 0;j < 100;j++) {
            int i = new Random().nextInt(3);//产生一个边界为3的随机整数
            String path = "";
            switch (i) {
                case 0:
                    path = "java.util.Date";
                    break;
                case 1:
                    path = "java.lang.Object";
                    break;
                case 2:
                    path = "reflection.Person";
                    break;
            }
            try {
                Object con = con(path);
                System.out.println(con);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            } catch (InstantiationException e) {
                throw new RuntimeException(e);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
    }

    //该方法用于创建一个指定类对象（运行时类对象）
    public Object con(String path) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Class clazz = Class.forName(path);
        Object o = clazz.newInstance();
        return o;
    }
}
