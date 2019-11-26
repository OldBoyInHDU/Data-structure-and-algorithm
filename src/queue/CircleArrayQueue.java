package queue;

import java.util.Scanner;

public class CircleArrayQueue {
    public static void main(String[] args) {
        CircleArray queue = new CircleArray(4);
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
                    queue.add(value);
                    break;
                case 'g' :
                    System.out.println(queue.get());
                    break;
                case 'h' :
                    System.out.println(queue.head());
                    break;
                case 's' :
                    queue.show();
                    break;
                case 'e' :
                    loop = false;
                    break;
            }
        }
    }
}

class CircleArray {
    private int front;
    private int rear;
    private int maxSize;
    private int[] arr;

    public CircleArray(int maxSize) {
        this.front = 0;
        this.rear = 0;
        this.maxSize = maxSize;
        this.arr = new int[maxSize];
    }

    public boolean isEmpty() {
        return front == rear;
    }

    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    public void add(int value) {
        if (isFull()) {
            System.out.println("队列已满");
            return;
        }
        arr[rear] = value;
        rear = (rear + 1) % maxSize;
    }

    public int get() {
        if (isEmpty()) throw new RuntimeException("队列为空，不能获取");
        int temp = arr[front];
        front = (front + 1) % maxSize;
        return temp;
    }

    public int head() {
        if (isEmpty()) throw new RuntimeException("队列为空，不能查看");
        return arr[front];
    }

    public int size() {
        return (rear + maxSize - front) % maxSize;//这里+maxSize是为了保证rear - front为正数！
    }

    public void show() {
        if (isEmpty()) throw new RuntimeException("队列为空，不能查看");
        for (int i = front; i < front + size(); i++) {
            System.out.printf("arr[%d] : %d\n", i % maxSize, arr[i % maxSize]);//front可能在数组后面，必须取模，不然+size()后可能会越界
        }
    }

}
