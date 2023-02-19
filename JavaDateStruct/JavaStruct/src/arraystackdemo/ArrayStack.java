package arraystackdemo;

/**
 * 栈类的创建(数组栈)
 * @author LykanHyper
 *
 */
public class ArrayStack {
	private int maxSize;
	private int top = -1;
	private int[] stack;
	
	public ArrayStack(int maxSize) {
		this.maxSize = maxSize;
		stack = new int[maxSize];
	}
	
	public boolean isEmpt() {
		return (top == -1);
	}
	
	public boolean isFull() {
		return (top == maxSize-1);
	}
	
	public void push(int value) {
		if (isFull()) {
			System.out.println("栈满，不能插入");
			return;
		}
		stack[++top] = value;
	}
	
	public int pop() {
		if (isEmpt()) {
			throw new RuntimeException("栈空");
		}
		
		return stack[top--];
//		return value;
		
	}
	
	//遍历，从栈顶开始遍历
	public void list() {
		if (isEmpt()) {
			System.out.println("栈为空");
			return;
		}
		int temp = top;
		while(true) {
			if(temp == -1) {
				break;
			}
			System.out.printf("stack[%d] = %d\n",temp,stack[temp]);
			temp--;
		}
	}
}
