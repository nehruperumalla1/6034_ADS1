class Node {
    int data;
    Node next;
    Node(int value) {
        data = value;
        next = null;
    }
    // Node head;
    public Node getAddress() {
        return next;
    }
    public void setAddress(Node address) {
        next = address;
    }

    public void setdata(int data1) {
        data = data1;
    }
}

class Operations {
    Node head;
    Node tail;
    int size;
    public void insertAtHead(int data) {
        Node start = new Node(data);
        size++;
        if (head == null) {
            head = start;
            tail = start;
            return;
        }
        start.setAddress(head);
        head = start;
        return;
    }

    public void insertAfterElement(int data, int element) {
        Node ins = new Node(element);
        Node temp1 = head;
        int flag = 0;
        while (temp1.data != data) {
            temp1 = temp1.getAddress();
            if (temp1.data == data) {
                flag = 1;
                break;
            }
        }
        if (flag == 1) {
            Node temp2 = temp1.getAddress();
            temp1.setAddress(ins);
            ins.setAddress(temp2);
            size++;
        }
    }

    public void insertAtTail(int data) {
        Node end = new Node(data);
        tail.next = end;
        tail = end;
        size++;
    }

    public void popAtHead() {
        if (size == 0) {
            System.out.println("Deck is empty");
            return;
        }
        Node temp = head;
        head = head.getAddress();
        temp = null;
        size--;
    }

    public void popAtTail() {
        if (size == 0) {
            System.out.println("Deck is empty");
            return;
        }
        Node temp = head;
        boolean flag = false;
        while (temp.next.next != null) {
            temp = temp.getAddress();
        }
        tail = temp;
        temp.next = null;
        size--;
    }

    public void deleteAfterElement(int data) {
        Node temp = head;
        while (temp.data != data) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
        size--;
    }
    public void printList() {
        if (size == 0) return;
        Node temp = head;
        System.out.print("[");
        while (temp.next != null) {
            System.out.print(temp.data + ", ");
            temp = temp.getAddress();
        }
        System.out.println(temp.data + "]");
    }
    public int size() {
        return size;
    }
}

public class LinkedList {
    public static void main(String[] args) {
        Operations op = new Operations();
    }
}