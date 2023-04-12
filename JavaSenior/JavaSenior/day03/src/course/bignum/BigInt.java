package course.bignum;

import java.math.BigInteger;

/**
 * @author muchen
 * @create 2022 - 09 - 2022/9/17 12:52
 *
 */
public class BigInt {
    public static void main(String[] args) {
//        long l = 11231435212423423543534534l;       //当一个整数太大long型也装不下的时候使用
        BigInteger bigInteger1 = new BigInteger("11231435212423423543534534");
        BigInteger bigInteger2 = new BigInteger("124342333");

        //如果想让两个过大的整数加减乘除  需要将其转化为bigInteger
        //加
        System.out.println(bigInteger1.add(bigInteger2));

        //减
        System.out.println(bigInteger1.subtract(bigInteger2));

        //乘
        System.out.println(bigInteger1.multiply(bigInteger2));

        //除
        System.out.println(bigInteger1.divide(bigInteger2));

        System.out.println(bigInteger1.getClass().getName().toString());     //输出bigInteger1的类型
    }
}
