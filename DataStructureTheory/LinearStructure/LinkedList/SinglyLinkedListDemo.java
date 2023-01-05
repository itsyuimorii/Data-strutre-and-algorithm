package LinearStructure.LinkedList;


/**
 * @program: Data-strutre-and-algorithm
 * @description:
 * @author: yuimorii
 * @create: 2023-01-03 13:34
 **/
public class SinglyLinkedListDemo {
    //进行测试
    public static void main(String[] args) {
        //先创建节点
        HeroNode hero1 = new HeroNode(1, "Hero-A", "AA");
        HeroNode hero2 = new HeroNode(2, "Hero-B", "BB");
        HeroNode hero3 = new HeroNode(3, "Hero-C", "CC");
        HeroNode hero4 = new HeroNode(4, "Hero-D", "DD");

        //创建要给链表
        SingleLinkedList singleLinkedList = new SingleLinkedList();
//
//        //第一种添加方式addHero
//        singleLinkedList.addHero(hero1);
//        singleLinkedList.addHero(hero4);
//        singleLinkedList.addHero(hero2);
//        singleLinkedList.addHero(hero3);

        //第二种添加方式addByOrder
        singleLinkedList.addByOrder(hero1);
        singleLinkedList.addByOrder(hero4);
        singleLinkedList.addByOrder(hero3);
        singleLinkedList.addByOrder(hero2);

        //测试
        singleLinkedList.list();

    }
}

//定义SingleLinkedList 管理我们的英雄
class SingleLinkedList {
    //先初始化一个头节点, 头节点不要动, 不存放具体的数据
    private HeroNode head = new HeroNode(0, "", "");


    //返回头节点
    public HeroNode getHead() {
        return head;
    }

    //添加节点到单向链表
    //思路，当不考虑编号顺序时
    //1. 找到当前链表的最后节点
    //2. 将最后这个节点的next 指向 新的节点
    public void addHero(HeroNode heroNode) {

        //因为head节点不能动，因此我们需要一个辅助遍历 temp
        HeroNode temp = head;
        //遍历链表，找到最后
        while (true) {
            //找到链表的最后
            if (temp.next == null) {//
                break;
            }
            //如果没有找到最后, 将将temp后移
            temp = temp.next;
        }
        //当退出while循环时，temp就指向了链表的最后
        //将最后这个节点的next 指向 新的节点
        temp.next = heroNode;
    }

    //第二种方式添加数据时， 根据排名将英雄插入到指定位置
    //如果有这个排名，则添加失败，并给出提示
    public void addByOrder(HeroNode heroNode) {
        //因为头节点不能动， 因此我们需要通过一个辅助指针（变量）来帮助我们找到添加的位置
        //这是单链表， 因为我们找的temp时位于添加位置的前一个节点， 否则插入不了？
        HeroNode temp = head;
        boolean found = false; //标识添加的编号是否存在， 默认为false
        while (true) {
            //思路就是先从头开始遍历节点，获得每个节点的no值，如果next为null则说明已经遍历到最后一个节点，直接插入到最后就行。如果在遍历过程中找到符合插入节点no值在两个相邻节点no值之间，则在此插入
            if (temp.next == null) {//说明temp 已经在链表的最后，不能再添加数据
                break;
            }
            //这里不是让temp跟 加入的数据做比较，而是让temp的下一个节点和加入的数据做比较
            if (temp.next.no > heroNode.no) {
                break;
            } else if (temp.next.no == heroNode.no) {//说明希望添加的heroNode的编号已然存在
                found = true; //说明编号存在
                break;
            }
            temp = temp.next; //后移，遍历当前链表
        }
        //判断flag 的值if found == true
        if (found) { //不能添加，说明编号存在
            System.out.printf("准备插入的英雄的编号 %d 已经存在了, 不能加入\n", heroNode.no);
        } else {
            //插入到链表中, temp的后面
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }


    //显示链表[遍历]
    public void list() {
        //判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //因为头节点，不能动，因此我们需要一个辅助变量来遍历
        HeroNode temp = head.next;
        while (true) {
            //判断是否到链表最后
            if (temp == null) {
                break;
            }
            //输出节点的信息
            System.out.println(temp);
            //将temp后移， 一定小心
            temp = temp.next;
        }
    }
}

//定义HeroNode ， 每个HeroNode 对象就是一个节点
class HeroNode {
    public int no;
    public String name;
    public String nickname;
    public HeroNode next; //指向下一个节点

    //构造器
    public HeroNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    //为了显示方法，我们重新toString
    @Override
    public String toString() {
        return "HeroNode [no=" + no + ", name=" + name + ", nickname=" + nickname + "]";
    }

}