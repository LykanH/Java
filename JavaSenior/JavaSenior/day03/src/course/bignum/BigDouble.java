package course.bignum;

import java.math.BigDecimal;

/**
 * @author muchen
 * @create 2022 - 09 - 2022/9/17 13:06
 */
public class BigDouble {
    public static void main(String[] args) {
//        double d = 12331.1244142354534533465;
//        System.out.println(d);      //输出达不到期望的精度，会四舍五入

        BigDecimal bigDecimal1  = new BigDecimal("123241.124355435363");
        BigDecimal bigDecimal2  = new BigDecimal("2145.12");

        //加
        System.out.println(bigDecimal1.add(bigDecimal2));
        //减
        System.out.println(bigDecimal1.subtract(bigDecimal2));
        //乘
        System.out.println(bigDecimal1.multiply(bigDecimal2));
        //除
        System.out.println(bigDecimal1.divide(bigDecimal2,BigDecimal.ROUND_CEILING));
        //除法运算可能抛出异常，因为可能碰到无限循环小数
        //BigDecimal.ROUND_CEILING表示如果碰到无限循环小数，就会保留分子的精度
    }
}
