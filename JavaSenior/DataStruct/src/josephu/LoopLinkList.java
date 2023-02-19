package josephu;

public class LoopLinkList {
	Boy curBoy = null;
	Boy first = null;
	public LoopLinkList() {
		first = new Boy(1);
		first.setNext(first);
		curBoy = first;
	}
	public void addNode(Boy boy) {
		curBoy.setNext(boy);
		boy.setNext(first);
		curBoy = curBoy.getNext();
	}
	
	public void list() {
		Boy curBoy = first;
		do {
			System.out.println(curBoy);
			curBoy = curBoy.getNext();	
		}while(curBoy != first);
	}
}
