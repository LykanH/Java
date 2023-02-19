package exer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author muchen
 * @create 2022 - 10 - 2022/10/17 21:05
 */
public class CollectionTest {
    @Test
    public void test1(){
        ArrayList arrayList = new ArrayList();
        arrayList.add("aaa");
        arrayList.add("bbb");
        arrayList.add(123);
        arrayList.add(true);
        arrayList.add(new man("ypb",20));


//        arrayList.remove(2);
        Iterator iterator = arrayList.iterator();


        while (iterator.hasNext()){
            System.out.println("*" + iterator.next());
        }

        arrayList.set(2,new man("qwe",18));
        Object o = arrayList.get(2);

        System.out.println(o.toString());
//        arrayList.remove(2);
        for (Object obj:arrayList){
            System.out.println(obj);
        }
    }
    class man{
        String name;
        int age;

        public man(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "man{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}
