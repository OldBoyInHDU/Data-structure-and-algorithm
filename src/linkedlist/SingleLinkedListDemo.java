package linkedlist;

public class SingleLinkedListDemo {
    public static void main(String[] args) {
        SingleLinkedList list = new SingleLinkedList();
        Node n1 = new Node(1, "张三");
        Node n2 = new Node(2, "李四");
        Node n3 = new Node(3, "王五");
        list.add(n1);
        list.add(n2);
        list.add(n3);
        list.list();
    }
}

class  SingleLinkedList {
    private Node head = new Node(0, "");

    public void add(Node node) {
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
    }

    public void list() {
        Node temp = head.next;
        if (temp == null) {
            System.out.println("链表为空");
            return;
        }
        while (temp != null) {
            System.out.println(temp);
            temp = temp.next;
        }

    }
}

class Node {
    int no;
    String name;
    Node next;

    public Node(int no, String name) {
        this.no = no;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Node{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }
}
