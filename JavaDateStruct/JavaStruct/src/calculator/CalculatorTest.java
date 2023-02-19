package calculator;

public class CalculatorTest {
	public static void main(String[] args) {
		Calculator calculator1 = new Calculator();
		calculator1.calculator("7*8+5-2*6");
		//30+2*6-2 :40
		//7*2*2-5+1-5+3-4:18
		//3+2*6-2:13
	}
}
