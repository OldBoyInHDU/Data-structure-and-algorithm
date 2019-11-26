package queue;

import java.util.Scanner;

public class ArrayQueueDemo {
    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(3);
        boolean loop = true;
        Scanner console = new Scanner(System.in);
        while (loop) {
            System.out.println("e(exit)");
            System.out.println("a(add)");
            System.out.println("h(head)");
            System.out.println("g(get)");
            System.out.println("s(show)");
            System.out.println("-------------------");
            char command = console.next().charAt(0);
            switch (command){
                case 'a':
                    System.out.println("请输入数字：");
                    int value = console.nextInt();
                    queue.addQueue(value);
                    break;
                case 'g' :
                    System.out.println(queue.getQueue());
                    break;
                case 'h' :
                    System.out.println(queue.headQueue());
                    break;
                case 's' :
                    queue.showQueue();
                    break;
                case 'e' :
                    loop = false;
                    break;
            }
        }
    }
}

class ArrayQueue {
    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;

    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        this.front = -1;
        this.rear = -1;
        arr = new int[maxSize];
    }

    public boolean isEmpty() {
        return front == rear;
    }

    public boolean isFull() {
        return rear == maxSize - 1;
    }

    public void addQueue(int value) {
        if (isFull()) {
            System.out.println("队列已满，不能加入");
            return;
        }
        rear++;
        arr[rear] = value;
    }

    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空，不能获得头数据");

        }
        front++;//等价于 front = front + 1 是赋值语句
        return arr[front];
    }

    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空，不能获得头数据");
        }
        return arr[front+1];//是运算语句，没有赋值效果！！
    }

    public void showQueue() {
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]: %d\n", i, arr[i]);
        }
    }
}
