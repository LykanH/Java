package text5;

public class CricleText {
	public static void main(String[] args) {
		Cricle cr1 = new Cricle(4.0, "blue", 1.0);
		Cricle cr2 = new Cricle(5.0, "blue", 1.0);
		System.out.println("第一个圆的面积为：" + cr1.findArea());
		System.out.println("两个圆的颜色是否相等：" + cr1.color.equals(cr2.color));
		boolean flag = cr1.equales(cr2);
		System.out.println("半径是否相等:" + flag);
		System.out.println(cr1);
		System.out.println(cr2.toString());
	}
}
