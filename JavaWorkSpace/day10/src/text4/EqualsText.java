package text4;

import java.util.Objects;

/**
 * 
 * @Description 实现equals方法的重写
 * @author muchen
 * @version
 * @date 2022年5月30日下午4:20:39
 *
 */
public class EqualsText {
	public static void main(String[] args) {
		int a = 10;
		double b = 10.0;
		System.out.println(a == b);		//true

		char c = 10;
		System.out.println(c == a);		//true

//		String d = "10";
//		System.out.println(d == a);		//编译就报错

		Customer cus1 = new Customer("zhangsan", 18);
		Customer cus2 = new Customer("zhangsan", 18);
//		System.out.println(cus1 == cus2);			//false
		System.out.println(cus1.equals(cus2));		//false
		
		
		String str1 = new String("dad");
		String str2 = new String("dad");
//		System.out.println(str1 == str2);
		System.out.println(str1.equals(str2));		//true
		
	}
}

class Customer {
	protected String name;
	protected int age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Customer(String name, int age) {
		super();
		this.age = age;
		this.name = name;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		return age == other.age && Objects.equals(name, other.name);
	}
	
	//重写Customer类中的equals方法
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj) {
//            return true;
//        }
//		if(obj instanceof Customer) {
//			Customer cusObj = (Customer)obj;
//			if(cusObj.age == this.age && this.name.equals(cusObj.name)) {
//				return true;
//			}
//		}
//		return false;
//	}
	
	//快捷键直接生成
	

}
