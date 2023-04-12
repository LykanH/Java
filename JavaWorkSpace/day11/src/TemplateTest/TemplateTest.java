package TemplateTest;

public class TemplateTest {
	public static void main(String[] args) {
		SubTemplate sub = new SubTemplate();
		sub.spendTime();
	}
}

abstract class Template {
	public void spendTime() {
		long start = System.currentTimeMillis();

		code();

		long end = System.currentTimeMillis();
		System.out.println("执行时间：" + (end - start));
	}

	public abstract void code();
}

//非质数
class SubTemplate extends Template {
	public void code() {
		for (int i = 2; i < 1000; i++) {
			boolean flag = false;
			for (int j = 2; j <= Math.sqrt(i); j++) {
				if (i % j == 0) {
					flag = true;
				}
			}
			if (flag) {
				System.out.println(i);
			}
		}
	}
}
