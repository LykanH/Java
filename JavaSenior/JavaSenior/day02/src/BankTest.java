/**
 * @author muchen
 * @create 2022 - 08 - 2022/8/24 17:55
 */
public class BankTest {

}

//单例模式懒汉式
class Bank {
    private Bank() {

    }

    private static Bank b1 = null;

    public static Bank getInstance() {  //假设getInstance在run方法中被调用
        //效率稍差
//        synchronized (Bank.class){
//            if (b1 == null) {
//                b1 = new Bank();
//            }
//            return b1;
//        }
        //方式二：
        if (b1 == null) {
            synchronized (Bank.class) {
                if (b1 == null) {
                    b1 = new Bank();
                }

            }
        }
        return b1;
    }
}
