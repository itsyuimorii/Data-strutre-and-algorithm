package LinearStructure.Queue;

import java.util.Scanner;

/**
 * @program: Data-strutre-and-algorithm
 * @description:
 * @author: yuimorii
 * @create: 2023-01-01 09:51
 **/
public class ArrayQueueDemo {
    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(3);
        char key = ' '; //获取用户输入
        Scanner sc = new Scanner(System.in);

        //输出一个菜单
        boolean loop = true;
        while (loop) {
            System.out.println("s(show): 显示队列");

            System.out.println("e(exit): 退出程序");
            System.out.println("a(add): 添加数据到队列");
            System.out.println("g(get): 从队列取出数据");
            System.out.println("h(head): 查看队列头的数据");
        }
    }


    //使用数组模拟队列-编写一个ArrayQueue的类
    static class ArrayQueue {
        private int maxSize; // indicates the maximum capacity of the array
        private int front; //queue front
        private int rear; //queue rear
        private int[] arrayQueue; //  simulate queues store data

        // Constructor for creating a queue
        public ArrayQueue(int arrMaxSize) {
            maxSize = arrMaxSize;
            arrayQueue = new int[maxSize];
            front = -1; //initialize to -1, Point to the data header position
            rear = -1; //initialize to -1，Point to the data tail position
        }

        //rear() – This operation returns the element at the rear end without removing it.
        public void rear() {
            System.out.println(rear);
        }

        //isFull() – Validates if the queue is full.
        public boolean isFull() {
            return rear == maxSize - 1;
        }

        //isNull() – Checks if the queue is empty.
        public boolean isNull() {
            return rear == front;
        }

        /*
        * Step 1: Check if the queue is full.
        Step 2: If the queue is full, return overflow error and exit.
        Step 3: If the queue is not full, increment the rear pointer to point to the next empty space.
        Step 4: Add the data element to the queue location, where the rear is pointing.
        Step 5: return success.*/
        //Enqueue() – Adds (or stores) an element to the end of the queue
        public void Enqueue(int data) {
            if (isFull()) {
                System.out.println("Queue is Full");
                return;
            }
            rear++;
            arrayQueue[rear] = data;
        }

        // Dequeue() – Removal of elements from the queue.
        public int Dequeue() {
            if (isNull()) {
                throw new RuntimeException("Queue is Empty");
                //不能返回-1， 这里不是数组越界
            }
            front++;
            return arrayQueue[front];
        }
    }

}



