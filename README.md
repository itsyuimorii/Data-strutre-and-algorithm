# Data structure and algorithm

# **What is Linked List**

Like arrays, a Linked List is a linear data structure. Unlike arrays, linked list elements are not stored at a contiguous location; the elements are linked using pointers. They include a series of connected nodes. Here, each node stores the data and the address of the next node.

[What is Linked List - GeeksforGeeks](https://www.geeksforgeeks.org/what-is-linked-list/)

## Advantages of Linked Lists over arrays:

- Dynamic Array.
- Ease of Insertion/Deletion.

## Types of Linked Lists:

- **Simple Linked List** – In this type of linked list, one can move or traverse the linked list in only one direction. where the next pointer of *each node points to other nodes but the next pointer of the last node points to NULL.* It is also called *“***Singly Linked List”**.
- **[Doubly Linked List](https://www.geeksforgeeks.org/doubly-linked-list/)** – In this type of linked list, one can move or traverse the linked list in both directions (Forward and Backward)
- **[Circular Linked List](https://www.geeksforgeeks.org/circular-linked-list/)** – In this type of linked list, the last node of the linked list contains the link of the first/head node of the linked list in its next pointer.
- **[Doubly Circular Linked List](https://www.geeksforgeeks.org/doubly-circular-linked-list-set-1-introduction-and-insertion/)** – A Doubly Circular linked list or a circular two-way linked list is a more complex type of linked list that contains a pointer to the next as well as the previous node in the sequence. The difference between the doubly linked and circular doubly list is the same as that between a singly linked list and a circular linked list. The circular doubly linked list does not contain null in the previous field of the first node.
- **[Header Linked List](https://www.geeksforgeeks.org/header-linked-list-in-c/)** – A header linked list is a special type of linked list that contains a header node at the beginning of the list.

# **Singly Linked List**

1. A linked table is **ordered**
2. the linked table is stored as nodes, it is chain storage
3. each node contains data domain, next domain: point to the next node
4. as shown in the figure: found that the ** individual nodes of the chain table are not necessarily stored consecutively**
5. the chain table is divided into **chain table with head node** and **chain table without head node**, according to the actual needs to determine

## What is the singly linked list?

The logical structure of a single linked table (with a head node) is shown below (** he is only logically ordered, but physically he is not ordered)**

![Untitled]([UntitledSll.png](https://github.com/itsyuimorii/Data-strutre-and-algorithm/blob/main/img/UntitledSll.png))

> head节点: 不存放具体的数据, 作用是表示单链表的头

## The idea of creating a single linked table

1. Adding (creating)
   1. create a head node, the role is to represent the head of the single-linked table
   2. then, each added node is added directly to the back of the chain
2. traversal
   1. iterate through the entire chain table with the help of an auxiliary variable

### Full Code

> The complete code simulates a single linked table

```java
package com.atguigu.linkedlist;

import java.util.Stack;

public class SingleLinkedListDemo {

	public static void main(String[] args) {
		//进行测试
		//先创建节点
		HeroNode hero1 = new HeroNode(1, "A", "AA");
    HeroNode hero2 = new HeroNode(2, "B", "BB");
    HeroNode hero3 = new HeroNode(3, "C", "CC");
    HeroNode hero4 = new HeroNode(4, "D", "DD");
		 
		
		//创建要给链表
		SingleLinkedList singleLinkedList = new SingleLinkedList();
		
		
		//加入
		singleLinkedList.add(hero1);
		singleLinkedList.add(hero4);
		singleLinkedList.add(hero2);
		singleLinkedList.add(hero3);

		// 测试一下单链表的反转功能
		System.out.println("原来链表的情况~~");
		singleLinkedList.list();
		
//		System.out.println("反转单链表~~");
//		reversetList(singleLinkedList.getHead());
//		singleLinkedList.list();
		
		System.out.println("测试逆序打印单链表, 没有改变链表的结构~~");
		reversePrint(singleLinkedList.getHead());
		
/*		
		//加入按照编号的顺序
		singleLinkedList.addByOrder(hero1);
		singleLinkedList.addByOrder(hero4);
		singleLinkedList.addByOrder(hero2);
		singleLinkedList.addByOrder(hero3);
		
		//显示一把
		singleLinkedList.list();
		
		//测试修改节点的代码
		HeroNode newHeroNode = new HeroNode(2, "小卢", "玉麒麟~~");
		singleLinkedList.update(newHeroNode);
		
		System.out.println("修改后的链表情况~~");
		singleLinkedList.list();
		
		//删除一个节点
		singleLinkedList.del(1);
		singleLinkedList.del(4);
		System.out.println("删除后的链表情况~~");
		singleLinkedList.list();
		
		//测试一下 求单链表中有效节点的个数
		System.out.println("有效的节点个数=" + getLength(singleLinkedList.getHead()));//2
		
		//测试一下看看是否得到了倒数第K个节点
		HeroNode res = findLastIndexNode(singleLinkedList.getHead(), 3);
		System.out.println("res=" + res);
*/		
		
	}
	
	//方式2：
	//可以利用栈这个数据结构，将各个节点压入到栈中，然后利用栈的先进后出的特点，就实现了逆序打印的效果
	public static void reversePrint(HeroNode head) {
		if(head.next == null) {
			return;//空链表，不能打印
		}
		//创建要给一个栈，将各个节点压入栈
		Stack<HeroNode> stack = new Stack<HeroNode>();
		HeroNode cur = head.next;
		//将链表的所有节点压入栈
		while(cur != null) {
			stack.push(cur);
			cur = cur.next; //cur后移，这样就可以压入下一个节点
		}
		//将栈中的节点进行打印,pop 出栈
		while (stack.size() > 0) {
			System.out.println(stack.pop()); //stack的特点是先进后出
		}
	}
	
	//将单链表反转
	public static void reversetList(HeroNode head) {
		//如果当前链表为空，或者只有一个节点，无需反转，直接返回
		if(head.next == null || head.next.next == null) {
			return ;
		}
		
		//定义一个辅助的指针(变量)，帮助我们遍历原来的链表
		HeroNode cur = head.next;
		HeroNode next = null;// 指向当前节点[cur]的下一个节点
		HeroNode reverseHead = new HeroNode(0, "", "");
		//遍历原来的链表，每遍历一个节点，就将其取出，并放在新的链表reverseHead 的最前端
		//动脑筋
		while(cur != null) { 
			next = cur.next;//先暂时保存当前节点的下一个节点，因为后面需要使用
			cur.next = reverseHead.next;//将cur的下一个节点指向新的链表的最前端
			reverseHead.next = cur; //将cur 连接到新的链表上
			cur = next;//让cur后移
		}
		//将head.next 指向 reverseHead.next , 实现单链表的反转
		head.next = reverseHead.next;
	}
	
	//查找单链表中的倒数第k个结点 【新浪面试题】
	//思路
	//1. 编写一个方法，接收head节点，同时接收一个index 
	//2. index 表示是倒数第index个节点
	//3. 先把链表从头到尾遍历，得到链表的总的长度 getLength
	//4. 得到size 后，我们从链表的第一个开始遍历 (size-index)个，就可以得到
	//5. 如果找到了，则返回该节点，否则返回nulll
	public static HeroNode findLastIndexNode(HeroNode head, int index) {
		//判断如果链表为空，返回null
		if(head.next == null) {
			return null;//没有找到
		}
		//第一个遍历得到链表的长度(节点个数)
		int size = getLength(head);
		//第二次遍历  size-index 位置，就是我们倒数的第K个节点
		//先做一个index的校验
		if(index <=0 || index > size) {
			return null; 
		}
		//定义给辅助变量， for 循环定位到倒数的index
		HeroNode cur = head.next; //3 // 3 - 1 = 2
		for(int i =0; i< size - index; i++) {
			cur = cur.next;
		}
		return cur;
		
	}
	
	//方法：获取到单链表的节点的个数(如果是带头结点的链表，需求不统计头节点)
	/**
	 * 
	 * @param head 链表的头节点
	 * @return 返回的就是有效节点的个数
	 */
	public static int getLength(HeroNode head) {
		if(head.next == null) { //空链表
			return 0;
		}
		int length = 0;
		//定义一个辅助的变量, 这里我们没有统计头节点
		HeroNode cur = head.next;
		while(cur != null) {
			length++;
			cur = cur.next; //遍历
		}
		return length;
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
	public void add(HeroNode heroNode) {
		
		//因为head节点不能动，因此我们需要一个辅助遍历 temp
		HeroNode temp = head;
		//遍历链表，找到最后
		while(true) {
			//找到链表的最后
			if(temp.next == null) {//
				break;
			}
			//如果没有找到最后, 将将temp后移
			temp = temp.next;
		}
		//当退出while循环时，temp就指向了链表的最后
		//将最后这个节点的next 指向 新的节点
		temp.next = heroNode;
	}
	
	//第二种方式在添加英雄时，根据排名将英雄插入到指定位置
	//(如果有这个排名，则添加失败，并给出提示)
	public void addByOrder(HeroNode heroNode) {
		//因为头节点不能动，因此我们仍然通过一个辅助指针(变量)来帮助找到添加的位置
		//因为单链表，因为我们找的temp 是位于 添加位置的前一个节点，否则插入不了
		HeroNode temp = head;
		boolean flag = false; // flag标志添加的编号是否存在，默认为false
		while(true) {
			if(temp.next == null) {//说明temp已经在链表的最后
				break; //
			} 
			if(temp.next.no > heroNode.no) { //位置找到，就在temp的后面插入
				break;
			} else if (temp.next.no == heroNode.no) {//说明希望添加的heroNode的编号已然存在
				
				flag = true; //说明编号存在
				break;
			}
			temp = temp.next; //后移，遍历当前链表
		}
		//判断flag 的值
		if(flag) { //不能添加，说明编号存在
			System.out.printf("准备插入的英雄的编号 %d 已经存在了, 不能加入\\n", heroNode.no);
		} else {
			//插入到链表中, temp的后面
			heroNode.next = temp.next;
			temp.next = heroNode;
		}
	}

	//修改节点的信息, 根据no编号来修改，即no编号不能改.
	//说明
	//1. 根据 newHeroNode 的 no 来修改即可
	public void update(HeroNode newHeroNode) {
		//判断是否空
		if(head.next == null) {
			System.out.println("链表为空~");
			return;
		}
		//找到需要修改的节点, 根据no编号
		//定义一个辅助变量
		HeroNode temp = head.next;
		boolean flag = false; //表示是否找到该节点
		while(true) {
			if (temp == null) {
				break; //已经遍历完链表
			}
			if(temp.no == newHeroNode.no) {
				//找到
				flag = true;
				break;
			}
			temp = temp.next;
		}
		//根据flag 判断是否找到要修改的节点
		if(flag) {
			temp.name = newHeroNode.name;
			temp.nickname = newHeroNode.nickname;
		} else { //没有找到
			System.out.printf("没有找到 编号 %d 的节点，不能修改\\n", newHeroNode.no);
		}
	}
	
	//删除节点
	//思路
	//1. head 不能动，因此我们需要一个temp辅助节点找到待删除节点的前一个节点
	//2. 说明我们在比较时，是temp.next.no 和  需要删除的节点的no比较
	public void del(int no) {
		HeroNode temp = head;
		boolean flag = false; // 标志是否找到待删除节点的
		while(true) {
			if(temp.next == null) { //已经到链表的最后
				break;
			}
			if(temp.next.no == no) {
				//找到的待删除节点的前一个节点temp
				flag = true;
				break;
			}
			temp = temp.next; //temp后移，遍历
		}
		//判断flag
		if(flag) { //找到
			//可以删除
			temp.next = temp.next.next;
		}else {
			System.out.printf("要删除的 %d 节点不存在\\n", no);
		}
	}
	
	//显示链表[遍历]
	public void list() {
		//判断链表是否为空
		if(head.next == null) {
			System.out.println("链表为空");
			return;
		}
		//因为头节点，不能动，因此我们需要一个辅助变量来遍历
		HeroNode temp = head.next;
		while(true) {
			//判断是否到链表最后
			if(temp == null) {
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
```

### 1. addData into LinkedList

```java
    //添加节点到单向链表
    //思路，当不考虑编号顺序时
    //1. 找到当前链表的最后节点
    //2. 将最后这个节点的next 指向 新的节点
    public void add(HeroNode heroNode) {

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
```

### 2. addByOrder - add data into list by order 

> Insert the content into the specified position according to the ranking
>
编号问题代码实现
>
> 1. 首先找到要添加节点的位置，我们需要一个辅助变量（指针来作为插入数据的前一个数据），通过遍历来实现
> 2. 当找到位置后就通过  新的节点.next = temp.next来指向4的位置
> 3. temp.next = 新的节点；

```java
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
            System.out.printf("准备插入的英雄的编号 %d 已经存在了, 不能加入\\n", heroNode.no);
        } else {
            //插入到链表中, temp的后面
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }
```

### 3. Update data

> 这里有几个小细节，首先这个变量指向的是头节点的下一个节点，而不是头节点，这样比较快一点
>
> 如果这里还用tmp.next的话最后一个的next就是null就直接break了，有一个节点就不会被操作，所以这里只能是tmp ==null就代表遍历完了。

```java
//修改节点的信息, 根据no编号来修改，即no编号不能改.
	//说明
	//1. 根据 newHeroNode 的 no 来修改即可
	public void update(HeroNode newHeroNode) {
		//判断是否空
		if(head.next == null) {
			System.out.println("链表为空~");
			return;
		}
		//找到需要修改的节点, 根据no编号
		//定义一个辅助变量
		HeroNode temp = head.next;
		boolean flag = false; //表示是否找到该节点
		while(true) {
			if (temp == null) {
				break; //已经遍历完链表
			}
			if(temp.no == newHeroNode.no) {
        //找到需要修改的节点
				flag = true;
				break;
			}
			temp = temp.next;
		}
		//根据flag 判断是否找到要修改的节点
		if(flag) {
			temp.name = newHeroNode.name;
			temp.nickname = newHeroNode.nickname;
		} else { //没有找到
			System.out.printf("没有找到 编号 %d 的节点，不能修改\\n", newHeroNode.no);
		}
	}
	
```

### 4. Delete data

1. 我们先找到 需要删除的这个节点的前一个节点 temp

2. temp.next = temp.next.next

3. 被删除的节点，将不会有其它引用指向，**会被垃圾回收机制回收**

> 注意的细节
>
> 首先tmp指向的必须是头节点如果指向的是Head.next那么第一个节点就会被跳过，就会删除不到
>
> 必须是tmp.next == null 如果不是那么在else if (tmp.next.no == no)中就会有空指针异常，应为在最后指针才会后移，所以当到林冲的时候指针没有移动如果是tmp == null 那么这里就不会break

```java
//删除节点
//思路
//1. head 不能动，因此我们需要一个temp辅助节点找到待删除节点的前一个节点
//2. 说明我们在比较时，是temp.next.no 和  需要删除的节点的no比较
public void del(int no) {
	HeroNode temp = head;
	boolean flag = false; // 标志是否找到待删除节点的
	while(true) {
		if(temp.next == null) { //已经到链表的最后
			break;
		}
		if(temp.next.no == no) {
			//找到的待删除节点的前一个节点temp
			flag = true;
			break;
		}
		temp = temp.next; //temp后移，遍历
	}Reply help 
	//判断flag
	if(flag) {  
		//可以删除
		temp.next = temp.next.next;
	}else {
		System.out.printf("要删除的 %d 节点不存在\\n", no);
	}
}
```

# 单链表算法问题

## 1. 查找单链表的倒数第k个【面试题】

思路：

1. 接收head节点，同时接收一个index
2. index，表示的是倒数第index个节点
3. 先把链表重头到尾遍历一次，等到总长度getlength
4. 得到size后 ，我们从链表的第一个开始遍历（size - index）个，就可以得到
5. 如果找到了就返回该节点，否则就是null

完整代码
