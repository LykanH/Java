package josephu;

public class Josephu {

	public static void main(String[] args) {
		int num = 25;
		LoopLinkList lll = new LoopLinkList();
		
		for(int i = 2;i<=num;i++) {
			lll.addNode(new Boy(i));
		}
//		lll.addNode(new Boy(2));
//		lll.addNode(new Boy(3));
//		lll.addNode(new Boy(4));
//		lll.addNode(new Boy(5));
		
		
		lll.list();
		
		lll.countBoy(1, 3, 25);
	}
}
