package exceptiontest;
/*


package exceptiontest;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ecmDef {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		double[] arg = new double[2];
		double resulat = 0;
		try {
		System.out.println("请输入被除数");
		arg[0] = scan.nextDouble();
		System.out.println("请输入除数");
		arg[1] = scan.nextDouble();
		ecmDef Test1 = new ecmDef();
		resulat = Test1.ecm(arg[0],arg[1]);
		}catch(NumberFormatException e){
//			e.printStackTrace();
			
		}catch(ArrayIndexOutOfBoundsException e) {
//			e.printStackTrace();
		}catch(InputMismatchException e) {
			System.out.println("输入的数据不符合输入要求！");
//			e.printStackTrace();
		}catch (EcDef e) {
			System.out.println(e.getMessage());
		}
		

		System.out.println("两数相除结果为：" + resulat);
		
	}
	
	public double ecm(double a,double b) throws EcDef {
		if(a < 0 || b < 0) {
			
			throw new EcDef("输入的分子或者分母为负数！");
		}
			
		return a/b;
		
		
	}
}

class EcDef extends Exception {
	static final long serialVersionUID = -338751124229948L;
	public EcDef() {
		// TODO Auto-generated constructor stub
	}
	public EcDef(String msg) {
		super(msg);
	}
}


*/
