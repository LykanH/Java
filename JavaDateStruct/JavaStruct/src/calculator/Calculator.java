package calculator;

/**
 * 使用数组栈实现综合计算器
 * 
 * @author LykanHyper
 *
 */
public class Calculator {
	public void calculator(String string) {
		ArrayStack operArrayStack = new ArrayStack(10);
		ArrayStack numArrayStack = new ArrayStack(20);
		int num1, num2;
		int opera;
		char ch;
		int index = 0;
		int temp = 0;
		while (true) {
			ch = string.charAt(index);
			// 遍历是数字还是符号
			if (operArrayStack.isOpera(ch)) {
				if (operArrayStack.isEmpt()) {
					// 如果符号位为空直接插入、
					operArrayStack.push(ch);
				} else {
					// 符号位不为空，比较当前符号优先级是否小于或等于pop所指优先级，若是，则从符号栈中pop出符号，
					// 在数字栈中pop两个数字，并做处理
					if (operArrayStack.priority(ch) < operArrayStack.priority((char) operArrayStack.topOpera())) {
						num1 = numArrayStack.pop();
						num2 = numArrayStack.pop();
						opera = operArrayStack.pop();
						numArrayStack.push(value(num1, num2, opera));
						operArrayStack.push(ch);
					} else {
						operArrayStack.push(ch);
					}
				}
				index++;
			} else {
				// 数字的情况
//				if (index < string.length()&&operArrayStack.isOpera(string.charAt(index+1))) {
//					numArrayStack.push(ch - '0');					
//					index++;
//				}else {
					while(!(index >= string.length()||operArrayStack.isOpera(string.charAt(index)) )) {
						ch = string.charAt(index);
						temp = (ch-'0') + temp * 10;
						index++;
//						i++;
					}
//					index++;
					numArrayStack.push(temp);
					temp = 0;
//				}
			}
			if (index == string.length()) {
				break;
			}
		}
		while (!operArrayStack.isEmpt()) {
			num1 = numArrayStack.pop();
			num2 = numArrayStack.pop();
			opera = operArrayStack.pop();
			numArrayStack.push(value(num1, num2, opera));
		}
		System.out.println(string + "=" + numArrayStack.pop());

	}

	public int value(int num1, int num2, int opera) {
		switch (opera) {
		case '+': {
			return (num1 + num2);
		}
		case '-': {
			return (num2 - num1);
		}
		case '*': {
			return (num2 * num1);
		}
		case '/': {
			return (num2 / num1);
		}default:return 1;
		}
	}
}
