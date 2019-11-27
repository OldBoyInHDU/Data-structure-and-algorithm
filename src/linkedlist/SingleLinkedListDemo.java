package linkedlist;

public class SingleLinkedListDemo {
    public static void main(String[] args) {
        SingleLinkedList list = new SingleLinkedList();
        Node n1 = new Node(1, "张三");
        Node n2 = new Node(2, "李四");
        Node n3 = new Node(3, "王五");
        Node n4 = new Node(4, "赵六");
        list.addByOrder(n4);
        list.addByOrder(n2);
        list.addByOrder(n1);
        list.addByOrder(n3);

        list.list();
        System.out.println("----------");
        list.delete(2);
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

    //按照no顺序添加结点
    public void addByOrder(Node node) {
        Node temp = head;
        boolean flag = false;
        while (true) {
            //指针已经在最后了
            if (temp.next == null) {
                break;
            }
            //找到位置了
            if (temp.next.no > node.no) {
                break;
            } else if (temp.next.no == node.no) {

                flag = true;
                break;
            }
            temp = temp.next;
        }

        if (flag) {
            System.out.println("该序号结点已存在");
        } else {
            node.next = temp.next;
            temp.next = node;
        }
    }

    //修改结点
    public void update(Node newNode) {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        Node temp = head.next;
        boolean flag = false;
        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.no == newNode.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            //找到了
            temp.name = newNode.name;
        } else {
            System.out.println("没有找到结点");
        }

    }

    //删除结点
    public void delete(int no) {
        if (head.next == null) {
            System.out.println("链表为空，无法删除");
            return;
        }
        Node temp = head.next;
        boolean flag = false;
        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.next.no == no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if (flag) {
            temp.next = temp.next.next;
        } else {
            System.out.println("没有找到待删除的结点");
        }
    }

    //打印链表
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
