package collectionexer_2;

import org.junit.Test;

import java.util.*;

/**
 * @author muchen
 * @create 2022 - 10 - 2022/10/27 21:03
 * 去除list中的重复值，要求尽量简单
 */
public class RmSimlar {
    public ArrayList duplicateList(List list){
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.addAll(list);
        return new ArrayList(linkedHashSet);
    }
    @Test
    public void test1(){
        ArrayList arrayList = new ArrayList();
        arrayList.add(123);
        arrayList.add(456);
        arrayList.add("a");
        arrayList.add(true);
        arrayList.add(123);
        arrayList.add("a");

        arrayList = duplicateList(arrayList);
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
//        System.out.println("**************");
//
//        LinkedHashSet hashSet = new LinkedHashSet(arrayList);
//
//        Iterator iterator_1 = hashSet.iterator();
//        while (iterator_1.hasNext()) {
//            System.out.println(iterator_1.next());
//        }

    }
}
