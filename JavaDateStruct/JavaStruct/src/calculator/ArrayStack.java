package calculator;

/**
 * 栈类的创建(数组栈)
 * 
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
		return (top == maxSize - 1);
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

	// 遍历，从栈顶开始遍历
	public void list() {
		if (isEmpt()) {
			System.out.println("栈为空");
			return;
		}
		int temp = top;
		while (true) {
			if (temp == -1) {
				break;
			}
			System.out.printf("stack[%d] = %d\n", temp, stack[temp]);
			temp--;
		}
	}
	//获得栈顶所指符号
	public int topOpera() {
		return stack[top];
	}
	
	// 判断字符是否为运算符
	public boolean isOpera(char opera) {
		return (opera == '+' || opera == '-' || opera == '*' || opera == '/');
	}

	// 给运算符设置优先级，通过数字大小判断优先级
	public int priority(char opera) {
		switch (opera) {
		case '+':
		case '-':
			return 0;
		case '*':
		case '/':
			return 1;
		default:
			return -1;
		}
	}
}
