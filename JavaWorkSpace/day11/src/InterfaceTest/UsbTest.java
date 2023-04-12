package InterfaceTest;

public class UsbTest {
	public static void main(String[] args) {
		Computer com1 = new Computer();
		com1.transferData(new Flash());		//多态的体现
											//Usb是一个接口不能实例化。
	}
}

class Computer {
	public void transferData(Usb usb) {
		usb.start();
		
		System.out.println("电脑在传输数据");
		
		usb.end();
	}
}

interface Usb{
	void start();
	
	void end();
}

class Flash implements Usb{
	public void start() {
		System.out.println("U盘开始工作");
	}
	public void end() {
		System.out.println("U盘终止工作");
	}
}

class Printer implements Usb {

	@Override
	public void start() {
		// TODO Auto-generated method stub
		System.out.println("打印机开始工作");
		
	}
	
	@Override
	public void end() {
		// TODO Auto-generated method stub
		System.out.println("打印机停止工作");
	}
}