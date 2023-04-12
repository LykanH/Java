package collectionsettest;

import org.junit.Test;

import java.util.*;

/**
 * @author muchen
 * @create 2022 - 10 - 2022/10/18 20:43
 *
 */
public class TreeSetTest {
    @Test
    public void test1(){
        int[] ints = new int[]{33,56,11,3,45,14};
        List ints1 = Arrays.asList(ints);
//        TreeSet treeSet = new TreeSet();


        Iterator iterator1 = ints1.iterator();
        while (iterator1.hasNext()) {
            System.out.println(iterator1.next());
        }

        HashSet hashSet = new HashSet();

        hashSet.addAll(ints1);

//        treeSet.add(123);
//        treeSet.add("aaa");
//        treeSet.add("zzz");
        Iterator iterator = hashSet.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
