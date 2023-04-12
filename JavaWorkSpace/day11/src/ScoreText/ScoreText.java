package ScoreText;

import java.util.Scanner;
import java.util.Vector;

/*
 * 利用Vector代替数组处理:从键盘读入学生成绩（以负数代表输
 * 入结束)，找出最高分，并输出学生成绩等级。
 * 
 * >提示:数组一旦创建，长度就固定不变，所以在创建数组前就需
 * 要知道它的长度。而问量类java.util.Vector可以根据需要动态伸缩。
 * 
 * >创建Vector对象: Vector v=new Vector()。
 * 
 * >给向量添加元素: v.addElement(Object obj); //obj必须是对象
 * >取出向量中的元素:Object obj=v.elementAt(O);
 * 
 * √注意第一个元素的下标是0，返回值是Object类型的。>计算向量的长度:v.size();
 * 
 * >若与最高分相差10分内:A等;20分内:B等;
 * 
 * 30分内:C等;其它:D等
 * 
 * 
 */
public class ScoreText {
	public static void main(String[] args) {
		//1.实例化scanner，从键盘获取学生成绩
		Scanner scan = new Scanner(System.in);
		//2.创建Vector对象，Vector v = new Vector();相当于原来的数组
		Vector v = new Vector();
		//3.通过for(;;)或while(true)方式，给vector中添加数组
		int maxScore = 0;
		for(;;) {
			System.out.println("请输入学生成绩(输入负数停止)：");
			int score = scan.nextInt();
			//3.2当输入是负数时跳出循环
			if(score < 0) {
				break;
			}
			if(score > 100) {
				System.out.println("您输入的成绩有误，请重新输入：");
				continue;
			}
			
			//jdk 5.0之前（没有自动装箱、自动拆箱）
//			Integer int1 = new Integer(score);
//			//3.1添加操作：v.addElement(Object obj)
//			v.addElement(int1);		//使用了多态
			
			//jdk 5.0之后
			v.addElement(score);		//自动装箱
			
			//4.获取学生数据的最大值
			if(maxScore < score) {
				maxScore = score;
				
			}
		}
		//5.遍历vector，得到每个学生的成绩，并与最大成绩比较，得到每个学生等级
		char level;
		for(int i = 0;i < v.size();i++) {
			Object obj=v.elementAt(i);
			//jdk5.0之前
//			Integer int2 = (Integer)obj;
//			int score = int2.intValue();
			
			//jdk5.0之后
			int score = (int)obj;
			
			if(maxScore - score < 10) {
				level = 'A';
			}else if(maxScore - score < 20) {
				level = 'B';
			}else if(maxScore - score < 30) {
				level = 'C';
			}else {
				level = 'D';
			}
			System.out.println("student_" + i +"分数为：" + score +",等级为：" + level);
		}
		
	}
}
