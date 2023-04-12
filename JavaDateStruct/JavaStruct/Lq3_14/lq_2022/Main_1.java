package lq_2022;

import java.math.BigInteger;

/**
 * [问题描述] 
 * 已知今天是星期六，请问20^22天后是星期几? 注意用数字1到7表示星期一到星期日。 
 * [答案提交]
 * 这是一道结果填空的题，你只需要算出结果后提交即可。本题的结果为一 个整数，在提交答案时只填写这个整数，填写多余的内容将无法得分。
 */
public class Main_1 {
	public static void main(String[] args) {
		BigInteger b2 = new BigInteger("20");
		BigInteger b1 = new BigInteger("22");
		BigInteger pow = b1.pow(22);
		BigInteger mod = pow.mod(new BigInteger("7"));
		System.out.println(mod);
	}
}
