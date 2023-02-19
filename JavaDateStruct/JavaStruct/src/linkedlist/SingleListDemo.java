package linkedlist;

/**
 * @author muchen
 * @create 2022 - 10 - 2022/10/22 18:44
 *
 * 4个面试题
 * 1.求单链表中有效节点的个数
 * 2.查找单链表中倒数第K个节点
 * 3.单链表的反转（两种方法）
 * 4.从尾到头打印单链表（使用到栈，可以不破坏原来链表顺序，如果先将链表反转再打印的话，会破坏原来链表结构）
 * 5.合并两个有序的单链表，合并之后的单链表仍然有序
 */
public class SingleListDemo {
    public static void main(String[] args) {
        SingleList singleList = new SingleList();
        HeroNode hero1 = new HeroNode(3, "a", "a1");
        HeroNode hero2 = new HeroNode(5, "b", "b1");
        HeroNode hero3 = new HeroNode(2, "c", "c1");
        HeroNode hero4 = new HeroNode(4, "d", "d1");
//        HeroNode hero5 = new HeroNode(2, "f", "f1");
//        HeroNode hero6 = new HeroNode(2, "g", "g1");
        HeroNode hero7 = new HeroNode(1, "h", "h1");

        singleList.addHero(hero1);
        singleList.addHero(hero2);
        singleList.addHero(hero3);
        singleList.addHero(hero4);
        singleList.addHero(hero7);
//        singleList.addByOrder(hero1);
//        singleList.addByOrder(hero3);
//        singleList.addByOrder(hero2);
//        singleList.addByOrder(hero4);
//        singleList.addByOrder(hero5);
//        singleList.addByOrder(hero6);
//        singleList.addByOrder(hero7);
        System.out.println("原来链表情况：");
        singleList.list();
        System.out.println();

        //更新链表内容
//        HeroNode newHero = new HeroNode(1, "张无忌", "张无忌");
//        singleList.setHero(newHero);

//        singleList.rmHero(1);
//        singleList.rmHero(2);

        //单链表反转
        singleList.rollBack_1();


//        System.out.println("该链表节点个数:" + singleList.nodeNum());

//        //查找单链表中元素倒数第K个元素
//        System.out.println("查找单链表倒数第1个元素" + singleList.findNode(1));
//        System.out.println("查找单链表倒数第0个元素" + singleList.findNode(0));
//        System.out.println("-----------------------");
//        System.out.println("查找单链表倒数第1个元素" + singleList.findNode_2(1));
//        System.out.println("查找单链表倒数第5个元素" + singleList.findNode_2(5));
//        singleList.rmHero(3);
//        singleList.rmHero(4);
//        singleList.rmHero(5);
//        singleList.addByOrder(hero2);

        singleList.list();
    }
}

class SingleList {
    HeroNode head = new HeroNode(0, "", "");

    HeroNode temp = head;


    //添加节点
    public void addHero(HeroNode heroNode) {
        while (temp.next != null) {
            //temp后移
            temp = temp.next;
        }
        temp.next = heroNode;
    }

    //老师讲的
    public void rollBack_1() {
        if (head.next == null || head.next.next == null) {
            System.out.println("该表不需要反转");
            return;
        }

        HeroNode cur = head.next;
        HeroNode curNext = null;
        HeroNode newHead = new HeroNode(0, "", "");
        while (cur != null) {
            curNext = cur.next;//先暂时保存当前节点的下一个节点，后边使用
            cur.next = newHead.next;//将cur的下一个节点指向新的链表最前端
            newHead.next = cur;//将cur 连接在新的链表上
            cur = curNext;//将原来head链表上的值重新赋给cur
        }
        head.next = newHead.next;

    }


    //单链表的反转(自己写的)
    public void rollBack() {
        if (head.next == null || head.next.next == null) {
            System.out.println("该表不需要反转");
            return;
        }
        HeroNode temp = head.next;
        HeroNode tempFormer;
        while (temp.next != null) {
//            temp.next.next = head.next;
//            head.next = temp;
//            temp = temp.next;
            tempFormer = head.next;//创建一个节点用于保存上一次被前移的节点
            head.next = temp.next;
            temp.next = temp.next.next;
            head.next.next = tempFormer;
        }
    }


    //查找单链表中倒数第K个节点改进版(使用双指针(快慢指针))!
    public HeroNode findNode_2(int k) {
        HeroNode fast = head;//定义快指针
        HeroNode lowe = head;//定义慢指针
        if (head.next == null) {
            System.out.println("链表为空,不存在要查找的节点!");
            return null;
        } else {
            while (k > 0) {
                k--;
                fast = fast.next;
            }
            while (fast != null) {
                fast = fast.next;
                lowe = lowe.next;
            }
        }
        return lowe;
    }

    //查找单链表中倒数第K个节点
    public HeroNode findNode(int k) {
        int allNum = nodeNum();
        HeroNode temp = head.next;
        if (k > allNum || k <= 0) {
            System.out.println("不存在要查找的节点!");
            return null;
        } else {
            for (int i = 0; i < (allNum - k); i++) {
                temp = temp.next;
            }
        }
        return temp;
    }


    //返回单链表中节点个数!
    public int nodeNum() {
        if (head.next == null) {
            return 0;
        }
        HeroNode temp = head.next;
        int num = 0;
        while (temp != null) {
            num++;
            temp = temp.next;
        }
        return num;
    }


    //通过编号顺序添加节点
    public void addByOrder(HeroNode heroNode) {
        HeroNode temp = head;
        while (true) {
//            if (heroNode.no == temp.next.no) {
//                System.out.println("节点序号重复插入失败");
//                return;
//            } else
            if (temp.next == null || temp.next.no >= heroNode.no) {
                if (temp.next != null && temp.next.no == heroNode.no) {
                    System.out.println("节点序号重复插入失败");
                    return;
                } else {
                    heroNode.next = temp.next;
                    temp.next = heroNode;
                    return;
                }
            }
            temp = temp.next;

        }
    }

    //修改节点内容
    public void setHero(HeroNode heroNode) {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = head;
        boolean flag = false;

        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no == heroNode.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag == true) {
            temp.next.name = heroNode.name;
            temp.next.nickName = heroNode.nickName;
        } else {
            System.out.printf("%d号节点没找到，修改失败！", heroNode.no);
        }
    }

    public void rmHero(int no) {
        if (head.next == null) {
            System.out.println("链表为空！");
            return;
        }
        HeroNode temp = head;
        boolean flag = false;

        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no == no) {
                flag = true;
                break;
            }
        }
        if (flag == true) {
            temp.next = temp.next.next;
        } else {
            System.out.println("未找到该节点！");
        }
    }

    public void list() {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = head.next;
        while (temp != null) {
            System.out.println(temp.toString());
            temp = temp.next;
        }
    }
}

class HeroNode {
    public int no;
    public String name;
    public String nickName;
    public HeroNode next;

    public HeroNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
