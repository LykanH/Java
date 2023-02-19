package arraystackdemo;

//import javax.lang.model.element.NestingKind;
//import javax.xml.transform.Templates;

/**
 * 
 * @author LykanHyper 通过链表实现栈
 */
public class LinkStack {
	public static void main(String[] args) {
		Stack stack = new Stack(3);
		stack.addNode(new Num(1));
		stack.addNode(new Num(2));
		stack.addNode(new Num(3));
//		stack.addNode(new Num(4));
		stack.delNode();
		stack.delNode();
		stack.delNode();
//		stack.delNode();
		String s1 = "abcdef";
		System.out.println(s1.length());
	}
}

class Stack {
	private int curCount = 0;
	private int maxSize;
	Num heaNum = new Num(0);//头节点
	Num topNum = heaNum;
	
	public Stack(int maxSize) {
		this.maxSize = maxSize;
	}
	
	public boolean isEmpt() {
		return (curCount == 0);
	}
	public boolean isFull() {
		return (curCount == maxSize);
	}
	
	public void addNode(Num num) {
		if (isFull()) {
			System.out.println("栈满，不能入栈");
			return;
		}
		System.out.println(num + "入栈成功");
		topNum.setNextNum(num);
		topNum = topNum.getNextNum();
		curCount++;
	}
	
	public void delNode() {
		if (isEmpt()) {
			System.out.println("栈空，出栈失败");
			return;
		}
		Num tempNum = heaNum;
		while(true) {
			if (tempNum.getNextNum() == topNum) {
				System.out.println(topNum+"出栈");
				topNum = tempNum;
				curCount--;
				return;
			}
			tempNum = tempNum.getNextNum();
		}
	}
	
//	Num firstNum = new Num(-1); // 创建不带头结点的单向链表，给头节点随意赋个值，后续改
//	public void addNode(Num num) {
//		if (firstNum.getNextNum() == null) {
//			firstNum.setCount(num.getCount());
//			return;
//		}
//		Num curNum = firstNum.getNextNum();
//		while(true) {
//			if (curNum.getNextNum() == null) {
//				curNum.setNextNum(num);
//			}
//			curNum = curNum.getNextNum();
//		}
//	}
	

}

class Num {
	private int count;
	private Num nextNum; // 单向链表的后继节点

	public Num(int count) {
		super();
		this.count = count;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Num getNextNum() {
		return nextNum;
	}

	public void setNextNum(Num nextNum) {
		this.nextNum = nextNum;
	}

	@Override
	public String toString() {
		return "Num [count=" + count + "]";
	}

}