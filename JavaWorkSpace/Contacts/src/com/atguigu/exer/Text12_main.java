package com.atguigu.exer;

public class Text12_main {
	public static void main(String[] args) {
		Text12_Boy boy1 = new Text12_Boy();
		boy1.setName("唐伯虎");
		boy1.setAge(20);
		System.out.println("name = " + boy1.getName());
		System.out.println("age = " + boy1.getAge());
		boy1.shout();
		
		Text12_Boy boy = new Text12_Boy("罗密欧", 22);
		System.out.println("name = " + boy.getName());
		System.out.println("age = " + boy.getAge());
		boy.shout();
		
		Text12_Girl girl = new Text12_Girl();
		girl.setAge(22);
		girl.setName("朱丽叶");
		girl.marry(boy);
		
		Text12_Girl girl1 = new Text12_Girl("秋香", 22);
		if(girl1.compare(girl) > 0) {
			System.out.println(girl1.getname() + "年龄大!");
		}else if(girl1.compare(girl) < 0){
			System.out.println(girl.getname() + "年龄大!");
		}else {
			System.out.println("年龄一样大！");
		}
	}
}
	