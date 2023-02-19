package josephu;

//import java.util.Iterator;
/**
 * 约瑟夫问题的代码实现
 * @author LykanHyper
 *
 */

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

	/**
	 * 
	 * @param begin    开始报数的位置
	 * @param interval 表示数几下出列
	 * @param nums     起初有多少个小孩
	 */
	public void countBoy(int begin, int interval, int nums) {
		if (nums < begin) {
			System.out.println("输入数值有误，重新输入");
			return;
		}

		System.out.println("间隔为：" + interval);
		// 指定一个指针指在first位置的前一个位置，保证链表不会断
		Boy curBoy = first;
		while (true) {
			if (curBoy.getNext() == first) {
				break;
			}
			curBoy = curBoy.getNext();
		}

		for (int i = 1; i < begin; i++) {
			first = first.getNext();
			curBoy = curBoy.getNext();
		}
		while (true) {
			if (curBoy == first) {
				break;
			} else {
				for (int i = 1; i < interval; i++) {
					first = first.getNext();
					curBoy = curBoy.getNext();
					if (i == (interval - 1)) {
						System.out.println(first.getNo() + "出列");
						first = first.getNext();
						curBoy.setNext(first);
					}
				}
			}
		}
		System.out.println(first.getNo() + "最后出列");
	}

	public void list() {
		Boy curBoy = first;
		do {
			System.out.println(curBoy);
			curBoy = curBoy.getNext();
		} while (curBoy != first);
	}
}
