package LinearStructure.Queue;

import java.util.Scanner;

/**
 * @program: Data-strutre-and-algorithm
 * @description:
 * @author: yuimorii
 * @create: 2023-01-03 10:44
 **/
public class CircleArrayQueueDemo {
    public static void main(String[] args) {
        //测试一把
        System.out.println("测试数组模拟环形队列的案例~~~");

        // 创建一个环形队列
        CircleArrayQueue circleArrayQueue = new CircleArrayQueue(4); //说明设置4, 其队列的有效数据最大是3
        char key = ' '; // 接收用户输入
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        // 输出一个菜单
        while (loop) {
            System.out.println("s(show): 显示队列");
            System.out.println("e(exit): 退出程序");
            System.out.println("a(add): 添加数据到队列");
            System.out.println("g(get): 从队列取出数据");
            System.out.println("h(head): 查看队列头的数据");
            key = scanner.next().charAt(0);
            switch (key) {
                case 's':
                    circleArrayQueue.showQueue();
                    break;
                case 'a':
                    System.out.println("输出一个数");
                    int value = scanner.nextInt();
                    circleArrayQueue.Enqueue(value);
                    break;
                case 'g': // 取出数据
                    try {
                        int res = circleArrayQueue.Dequeue();
                        System.out.printf("取出的数据是%d\n", res);
                    } catch (Exception e) {
                        // TODO: handle exception
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h': // 查看队列头的数据
                    try {
                        int res = circleArrayQueue.headQueue();
                        System.out.printf("队列头的数据是%d\n", res);
                    } catch (Exception e) {
                        // TODO: handle exception
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e': // 退出
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出~~");
    }
}

class CircleArrayQueue {
    private int maxSize; // 表示数组的最大容量
    //front 变量的含义做一个调整： front 就指向队列的第一个元素, 也就是说 arr[front] 就是队列的第一个元素
    //front 的初始值 = 0
    private int front;
    //rear 变量的含义做一个调整：rear 指向队列的最后一个元素的后一个位置. 因为希望空出一个空间做为约定.
    //rear 的初始值 = 0
    private int rear; // 队列尾
    private int[] arrayQueue; // 该数据用于存放数据, 模拟队列

    public CircleArrayQueue(int arrMaxSize) {
        maxSize = arrMaxSize;
        arrayQueue = new int[maxSize];
    }

    //判断环形队列是否满
    public boolean isFull() {

        return (rear + 1) % maxSize == front;
    }

    // 判断队列是否为空 rear =0 ,front =0
    public boolean isEmpty() {
        return rear == front;
    }

    //Enqueue() – Adds (or stores) an element to the end of the queue
    public void Enqueue(int data) {
        if (isFull()) {
            System.out.println("queue is full");
            return;
        }
        //Input data directly into arrayAQueue
        arrayQueue[rear] = data;
        //将rear指针后移，这里必须考虑reminder，因为rear如果是数组最后一个位置
        rear = (rear + 1) % maxSize;
    }

    //Dequeue() - get an element from the end of the queue
    public int Dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("queue is empty");
        }
        // 这里需要分析出 front是指向队列的第一个元素
        // 1. 先把 front 对应的值保留到一个临时变量
        // 2. 将 front 后移, 考虑取模
        // 3. 将临时保存的变量返回
        int value = arrayQueue[front];
        front = (front + 1) % maxSize;
        return value;
    }

    //ShowQueue
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("queue is empty");
            return;
        }
        //从front 开始遍历， 遍历多少个元素
        //for(int i =front; i <front+ ? ;i++) ? 代表一个方法
        //思考为什么是i%maxSize,
        for (int i = front; i < front + queuePresentSize(); i++) {
            System.out.printf("arr[%d] = %d\n", i % maxSize, arrayQueue[i] % maxSize);
        }
    }

    public int queuePresentSize() {
        return (rear + maxSize - front) % maxSize;

    }

    // 显示队列的头数据， 注意不是取出数据
    public int headQueue() {
        // 判断
        if (isEmpty()) {
            throw new RuntimeException("队列空的，没有数据~~");
        }
        return arrayQueue[front];
    }

}
