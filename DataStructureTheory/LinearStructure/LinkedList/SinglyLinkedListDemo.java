package LinearStructure.LinkedList;
import java.util.Stack;
/**
 * @program: Data-strutre-and-algorithm
 * @description:
 * @author: yuimorii
 * @create: 2023-01-03 13:34
 **/
public class SinglyLinkedListDemo {
    public static void main(String[] args) {
        //进行测试
        //先创建节点
        HeroNode hero1 = new HeroNode(1, "AA", "a");
        HeroNode hero2 = new HeroNode(2, "B", "b");
        HeroNode hero3 = new HeroNode(3, "C", "c");
        HeroNode hero4 = new HeroNode(4, "D", "d");
        //创建链表
        SinglyLinkedList singleLinkedList = new SinglyLinkedList();
        //添加英雄
        singleLinkedList.addNode(hero1);
        singleLinkedList.addNode(hero2);
        singleLinkedList.addNode(hero3);
        singleLinkedList.addNode(hero4);
        //显示英雄

        singleLinkedList.ShowLinkedList();
    }
}

class SinglyLinkedList {
    //initialize a headNode, the head node can't move otherwise it can't locaate the other nodes
    private HeroNode heroNode = new HeroNode(0, "0", "A");


    // Add nodes to the linkedList
    //思路：当不考虑不考虑编号的顺序时：
    //1.找到当前链表的最后节点，
    //2.将最后这个节点的next 指向新的节点
    //2.通过循环找到循环的末尾
    public void addNode(HeroNode heroNode) {
        //创建一个辅助变量来管理头节点，因为head节点不能动，因此需要一个辅助变量tmp
        HeroNode tmp = heroNode;
        //只要找到的那个tmp不为空，就说明还没有找到最后一个，此时就继续while循环
        while (true) {
            if (tmp.next == null) {
                break;
            }
            //tmp继续后移到下一个继续找
            tmp = tmp.next;
        }
        //当退出while循环时，tmp就指向链表的最后
        tmp.next = heroNode;
    }

    // show the whole linkedList
    public void ShowLinkedList() {
        //判断链表是否为空
        if (heroNode.next == null) {
            System.out.println("LinkedList is empty");
            return;
        }
        //因为头节点不能动所以只能用一个辅助变量来遍历
        HeroNode tmp = heroNode.next;

        //第一种写法：
        while (true) {
            //判断是否到了链表最后
            if (tmp.next == null) {
                break;
            }
            System.out.println(tmp);
            //一定要记得将节点下移不然就会死循环
            tmp = tmp.next;
        }
    }
}
        //第二种写法：
//        while (tmp.next != null) {
//            //一定要记得将节点下移不然就会死循环
//            tmp = tmp.next;
//            System.out.println(tmp.toString());
//        }


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
