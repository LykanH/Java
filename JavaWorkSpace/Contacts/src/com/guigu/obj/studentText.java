package com.guigu.obj;

public class studentText {
	public static void main(String[] args) {
		
//		Student stu1 = new Student();
//		Student stu1 = new Student();
//		Student stu1 = new Student();
//		Student stu1 = new Student();
//		Student stu1 = new Student();
		
		Students[] stu = new Students[20];
		for(int i = 0;i < stu.length;i++) {
			stu[i] = new Students();
			stu[i].number = ((int)i+1);
			stu[i].state = (int)(Math.random() * 6 + 1);
			stu[i].score = (int)(Math.random() * 100 + 1);
		}
		//遍历学生数组
		for(int i = 0;i < stu.length;i++) {
//			System.out.println(stu[i]);
//			System.out.print(stu[i].state + "\t");
			if(stu[i].state == 3) {
				System.out.println("学号为：" + stu[i].number + "\t" + "年纪为：" + stu[i].state + "\t" + "成绩为：" + stu[i].score);
				
			}
		}
		System.out.println();
		System.out.println();
		System.out.println();
		for(int i = 0;i < stu.length - 1;i++) {
			for(int j = 0;j < stu.length - i - 1;j++) {
				Students temp = new Students();
				if(stu[j].score > stu[j+1].score) {
					temp = stu[j + 1];
					stu[j + 1] = stu[j];
					stu[j] = temp;
					
				}
			}
		}
		for(int i = 0;i < stu.length;i++) {

				System.out.println("学号为：" + stu[i].number + "\t" + "年纪为：" + stu[i].state + "\t" + "成绩为：" + stu[i].score);
				
		}
		
	}
}


class Students {
	
	int number;
	int state;
	int score;
	
}