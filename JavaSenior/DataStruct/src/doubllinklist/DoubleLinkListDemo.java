package doubllinklist;

/**
 * @author muchen
 * @create 2022 - 11 - 2022/11/11 17:44
 * //双向链表的代码实现
 */
public class DoubleLinkListDemo {
    public static void main(String[] args) {
        DoubleLinkList doubleLinkList = new DoubleLinkList();
        HeroNode h1 = new HeroNode(1,"aaa","AAA");
        HeroNode h2 = new HeroNode(2,"bbb","BBB");
        HeroNode h3 = new HeroNode(3,"ccc","CCC");
        HeroNode h4 = new HeroNode(1,"ddd","DDD");
        doubleLinkList.addHero(h1);
        doubleLinkList.addHero(h3);
        doubleLinkList.addHero(h2);
        System.out.println("是否修改成功：" + doubleLinkList.updateHeroNode(h4));
        doubleLinkList.list();

        System.out.println();

        System.out.println("是否删除成功：" + doubleLinkList.delHeroNode(h2));
        doubleLinkList.list();
    }
}
