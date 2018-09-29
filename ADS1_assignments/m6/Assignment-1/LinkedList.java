class Node {
    private int data;
    private Node next;
    Node(int value) {
        data = value;
        next = null;
    }

    public Node getNext() {
        return next;
    }

    public int getData() {
        return data;
    }

    public void setNext(Node node) {
        next = node;
    }

    public void setData(int value) {
        data = value;
    }
}


public class LinkedList {
    Node head;
    Node tail;
    int size = 0;
    public void insertAtTail(int data) {
        Node item = new Node(data);
        size++;
        if (head == null) {
            item.setNext(null);
            head = item;
            tail = item;
            return;
        }
        tail.setNext(item);
        tail = item;
        return;
    }
    public void popAtHead() {
        Node temp = head;
        head = head.getNext();
        temp = null;
        size--;
    }

    public void popAtTail() {
        if(size == 1){
            size--;
            head = null;
            tail = null;
            return;
        }
        Node temp = head;
        while (temp.getNext().getNext() != null) {
            temp = temp.getNext();
        }
        if (size > 1) {
            size--;
            temp.setNext(null);
            tail = temp;
        }
    }

    public int eleAtTail() {
        return tail.getData();
    }

    public void insertAtHead(int data) {
        Node start = new Node(data);
        size++;
        if (head == null) {
            head = start;
            tail = start;
            return;
        }
        start.setNext(head);
        head = start;
        return;
    }


    // public void insertAtHead(int data) {
    //     Node item = new Node(data);
    //     if (head == null) {
    //         head = item;
    //         tail = item;
    //     }
    //     item.setNext(head);
    //     head = item;
    // }


    public int size() {
        return size;
    }
    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.getData());
            temp = temp.getNext();
        }
    }


    public void display(){
        Node temp = head;
        while (temp != null) {
            System.out.print(temp+" == "+temp.getData()+" | "+temp.getNext()+" -->");
            temp = temp.getNext();
        }
    }
}