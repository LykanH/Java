package reflection;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author muchen
 * @create 2022 - 12 - 2022/12/8 21:49
 * 反射
 */
public class ReflectionTest {
    @Test
    //学习反射之前，因为Java的封装性，我们只能调用Java中的public方法
    //而不能在类之外直接调用一个类的私有方法、属性、构造器
    public void test1(){
        Person p1 = new Person();
        p1.setAge(10);
        p1.setName("Jhon");
        System.out.println("p1:" + p1.toString());
        Person p2 = new Person("ypb",12);
        System.out.println("p2:"+p2.toString());
        p2.age = 18;
        System.out.println("p2属性值更改后：" + p2.toString());
    }

    @Test
    public void test2() throws Exception {
        Class<Person> personClass = Person.class;
        //通过反射实例化类的对象
        Constructor<Person> con = personClass.getConstructor(String.class, int.class);
        Object obj = con.newInstance("沐辰", 20);
        Person person = (Person) obj;
        System.out.println(person.toString());

        //通过反射，调用对象指定的属性
        Field age = personClass.getDeclaredField("age");
        age.set(person, 18);
        System.out.println("通过反射修改对象属性后："+person);
        //调用方法
        Method show = personClass.getDeclaredMethod("show");
        show.invoke(person);
        System.out.println("--------------------------------------------");

        //通过反射，可以调用Person类的私有结构，比如私有的属性、方法、构造器
        Constructor<Person> constructor = personClass.getDeclaredConstructor(String.class);
        constructor.setAccessible(true);//使私有方法可以在反射中调用
        Person person1 = constructor.newInstance("杨鹏博");
        System.out.println(person1);

        //调用私有的属性
        Field name = personClass.getDeclaredField("name");
        name.setAccessible(true);
        name.set(person1, "修改后：muchen");
        System.out.println(person1.toString());

        //调用私有方法
        Method nation = personClass.getDeclaredMethod("nation", String.class);
        nation.setAccessible(true);
        Object nat = nation.invoke(person1, "China");//相当于调用了该方法:p1.nation
        System.out.println((String) nat);

    }


    @Test
    /*
    获取Class 实例的的方式
     */
    public void test3() throws ClassNotFoundException {
        //方式一：
        Class<Person> class1 = Person.class;
        System.out.println(class1);
        //方式二:
        Person p1 = new Person();
        Class class2 = p1.getClass();
        System.out.println(class2);
        //方式三：调用Class 的静态方法：forName(string classPath);
        Class class3 = Class.forName("reflection.Person");
        System.out.println(class3);
        //方式四：

    }
}
