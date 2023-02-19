package doubllinklist;

/**
 * @author muchen
 * @create 2022 - 11 - 2022/11/11 19:42
 */
public class DoubleLinkList {

    //初始化头节点
    HeroNode head = new HeroNode(0,"","");
    HeroNode temp = head;


    //返回头节点
    public HeroNode getHead(){
        return head;
    }

    //双向链表删除节点（通过no删除）
    public boolean delHeroNode(HeroNode heroNode){
        if (isEmpt()){
            System.out.println("删除失败，链表为空");
            return false;
        }


        temp = head.next;
        while (temp != null){
            if (temp.no == heroNode.no){
                if (temp.next == null){
                    temp.pre.next = temp.next;
                }else {
                    temp.pre.next = temp.next;
                    temp.next.pre = temp.pre;
                    return true;
                }
            }
            temp = temp.next;
        }
        return false;
    }

    //根据传入节点的no值，修改双向链表中节点内容,修改成功返回true
    public boolean updateHeroNode(HeroNode heroNode){
        if (isEmpt()){
            System.out.println("链表为空");
            return false;
        }
        temp = head;
        while (temp.next != null){
            if (heroNode.no == temp.no){
                temp.pre.next = heroNode;
                heroNode.pre = temp.pre;
                temp.next.pre = heroNode;
                heroNode.next = temp.next;
                return true;
            }else {
                temp = temp.next;
            }
        }
        return false;
    }

    //添加（默认添加到双向链表的最后）
    public void addHero(HeroNode heroNode){
        temp = head;
        while (true){
            if (temp.next != null){
                temp = temp.next;
            }else {
                break;
            }
        }
        temp.next = heroNode;
        heroNode.pre = temp;
    }


    //遍历双向链表，与单向链表一样
    public void list(){
        if (isEmpt()){
            System.out.println("链表为空！");
            return;
        }
        HeroNode temp = head.next;
        while (temp != null){
            System.out.println(temp.toString());
            temp = temp.next;
        }
    }
    public boolean isEmpt(){        //链表为空返回true
        return (head.next == null);
    }

}
