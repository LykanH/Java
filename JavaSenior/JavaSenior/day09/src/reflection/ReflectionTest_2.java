package reflection;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author muchen
 * @create 2022 - 12 - 2022/12/19 15:43
 *
 * 调用运行时类中的指定属性
 */
public class ReflectionTest_2 {
    public static void main(String[] args) throws Exception {
        Class<Person> clazz = Person.class;
        //1.创建运行时类对象
        Person person = clazz.newInstance();

        //getField()：此方法只能获取运行时类中的public方法，一般使用getDeclaredField()
//        Field age = clazz.getField("name");//name 权限修饰符为private 使用此方法报错
        Field name = clazz.getDeclaredField("name" );

        //2.保证该属性可以访问
        name.setAccessible(true);//私有属性必须将此设置为true才能修改，否则报错（非法访问）
        name.set(person, "101");


        String a = (String)name.get(person);
        System.out.println(a);
    }

    /*
    如何操作运行时类的方法
     */
    @Test
    public void test1() throws Exception {
        Class<Person> clazz = Person.class;
        //实例化运行时类对象
        Person person = clazz.newInstance();
        //获取指定的某个方法:参数1：指明所获取的方法名称   参数2.方法形参列表
        Method nation = clazz.getDeclaredMethod("nation", String.class);

        //保证当前方法可以访问
        nation.setAccessible(true);
        /*
        2.调用方法的invoke():参数1：方法的调用者  参数2：给方法形参赋值的实参
        invoke()的返回值即为调用方法的返回值。
         */
        Object o = nation.invoke(person, "中国");
        System.out.println(o);

        System.out.println("******************如何调用静态方法**************");

        Method betuful = clazz.getDeclaredMethod("betuful");
        Object o1 = betuful.invoke(Person.class);
        System.out.println(o1);//因为没有返回值，所以o1为null;


    }
}
