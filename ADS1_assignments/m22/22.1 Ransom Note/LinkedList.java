/**
 * Class for node.
 */
class Node {
    /**
     * Data variable.
     */
    String data;
    /**
     * Value Variable.
     */
    int value;
    /**
     * Next Node address.
     */
    Node next;
    Node(String key, int value1) {
        data = key;
        value = value1;
        next = null;
    }
    /**
     * Gets the address.
     *
     * @return     The address.
     */
    public Node getAddress() {
        return next;
    }
    /**
     * Set the address of next node.
     *
     * @param      address  The address
     */
    public void setAddress(Node address) {
        next = address;
    }
    /**
     * Set the data for data variable.
     *
     * @param      data1  The data 1
     */
    public void setdata(String data1) {
        data = data1;
    }
}

/**
 * List of linkeds.
 */
class LinkedList {
    /**
     * Head Node
     */
    Node head;
    /**
     * Tail Node.
     */
    Node tail;
    /**
     * Size of Linked List.
     */
    int size;
    /**
     * Insert Node at Head.
     *
     * @param      data   The data
     * @param      value  The value
     */
    public void insertAtHead(String data, int value) {
        Node start = new Node(data, value);
        size++;
        if (head == null) {
            head = start;
            tail = start;
            // System.out.println(printList());
            return;
        }
        start.setAddress(head);
        head = start;
        // System.out.println(printList());
        return;
    }
}
    // public void insertAfterElement(int data, int element) {
    //     Node ins = new Node(element);
    //     Node temp1 = head;
    //     int flag = 0;
    //     int cmp = temp1.data.compareTo(data);
    //     while (cmp != 0) {
    //         temp1 = temp1.getAddress();
    //         cmp = temp1.data.compareTo(data);
    //         if (cmp == 0) {
    //             flag = 1;
    //             break;
    //         }
    //     }
    //     if (flag == 1) {
    //         Node temp2 = temp1.getAddress();
    //         temp1.setAddress(ins);
    //         ins.setAddress(temp2);
    //         size++;
    //     }
    // }

    // public void insertAtTail(int data) {
    //     Node end = new Node(data);
    //     tail.next = end;
    //     tail = end;
    //     size++;
    //     System.out.println(printList());
    // }

//     public void popAtHead() {
//         if (size == 0) {
//             System.out.println("Deck is empty");
//             return;
//         }
//         Node temp = head;
//         head = head.getAddress();
//         temp = null;
//         size--;
//         System.out.println(printList());
//     }

//     public void popAtTail() {
//         if (size == 0) {
//             System.out.println("Deck is empty");
//             return;
//         }
//         Node temp = head;
//         boolean flag = false;
//         while (temp.next.next != null) {
//             temp = temp.getAddress();
//         }
//         tail = temp;
//         temp.next = null;
//         size--;
//         System.out.println(printList());
//     }

//     public void deleteAfterElement(String data) {
//         Node temp = head;
//         int cmp = temp.data.compareTo(data);
//         while (cmp != 0) {
//             temp = temp.next;
//             cmp = temp.data.compareTo(data);
//         }
//         temp.next = temp.next.next;
//         size--;
//     }

//     public String printList() {
//         Node temp = head;
//         String str = "[";
//         if (size > 0) {
//             while (temp.next != null) {
//                 str += temp.data + " - " + temp.value + ", ";
//                 temp = temp.getAddress();
//             }
//             str += temp.data;
//         }
//         str += "]";
//         return str;
//     }
//     public int size() {
//         return size;
//     }
// }

// public class LinkedList {
//     public static void main(String[] args) {
//         Operations op = new Operations();
//     }
// }