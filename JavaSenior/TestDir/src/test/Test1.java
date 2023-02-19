package test;

/**
 * @author muchen
 * @create 2022 - 10 - 2022/10/26 18:52
 */

public class Test1{
    public static void main(String[] args) {
        Print p1 = new Print();
        System.out.println( "和为：" + p1.sum());
    }
}

interface Animal{
    //	public int num ;
    public void cry();
    int a = 10;
    int b = 10;
}

abstract class Plant{
    public abstract void age();
    public void type(){
        System.out.println("草本植物！");
    }
}
class Print extends Plant implements Animal{
    @Override
    public void cry() {
        // TODO Auto-generated method stub
        System.out.println("动物叫");
    }
    @Override
    public void age() {
        // TODO Auto-generated method stub
        System.out.println("植物3岁");
    }
    public int sum(){
        int c = 1,b = 3,a;

        return a = (c++)*3;//结果为3   该句执行完之后c才会进行++ 操作
    }
}